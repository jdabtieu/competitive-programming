section .text
global _start

; int readint()
; byte _read_buf()

; void printint(int num) --> edi
; void newline()
; void printspace()
; void write_out(char *buf, int count) --> rdi, esi
; void _write_buf(char *buf, int count) --> rdi, esi
; void flush_obuf()

; rax caller-save function return value
; rbx callee-save
; rcx caller-save arg4
; rdx caller-save arg3
; rsi caller-save arg2
; rdi caller-save arg1
; rsp caller-save stack pointer
; rbp callee-save base pointer
; r8  caller-save arg5
; r9  caller-save arg6
; r10 caller-save
; r11 caller-save
; r12 callee-save
; r13 callee-save
; r14 callee-save
; r15 callee-save


_start:
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 16                 ; align stack to keep 16 bytes for buffering
    call readint
    mov r12d, eax
    call readint
    mov r13d, eax
    cmp r12d, 3
    jl c1d
    cmp r13d, 4
    jg c1d
    lea rdi, [rel troy]
    lea esi, [rel tl]
    call _write_buf
 c1d:
    cmp r12d, 6
    jg c2d
    cmp r13d, 2
    jl c2d
    lea rdi, [rel vlad]
    lea esi, [rel vl]
    call _write_buf
c2d:
    cmp r12d, 2
    jg c3d
    cmp r13d, 3
    jg c3d
    lea rdi, [rel grae]
    lea esi, [rel gl]
    call _write_buf
c3d:
    call flush_obuf             ; flush output buffer very important
    mov rax, 60                 ; rax = 60 for sys_exit
    xor rdi, rdi                ; exit code = 0
    syscall


readint:                        ; int readint()
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 16                 ; align stack to keep 16 bytes for buffering
    mov byte [rsp+4], 0         ; bool neg = false
    mov dword [rsp+8], 0        ; int num = 0
_readint_init:
    call _read_buf              ; read one char from buffer
    cmp al, 45                  ; compare character to '-'
    je _readint_neg             ; jump to negative
    cmp al, 48                  ; compare character to '0'
    jl _readint_init            ; skip if char < '0'
    cmp al, 57                  ; compare charcter to '9'
    jg _readint_init            ; skip if char > '9'
    sub al, 48                  ; convert char to int
    mov dword [rsp+8], eax      ; num = rax
    jmp _readint_loop_init
_readint_neg:
    mov byte [rsp+4], 1         ; bool neg = true
_readint_loop_init:
    lea rsi, [rsp+12]           ; use rsp+12 as buffer
    xor edi, edi                ; rdi = 0, for STDIN
_readint_loop:
    call _read_buf              ; read one character
    xor ebx, ebx                ; clear rbx
    mov bl, al                  ; move char to bl
    cmp bl, 48                  ; compare character to '0'
    jl _readint_done            ; end if char < '0'
    sub bl, 48                  ; convert char to int
    mov edx, dword [rsp+8]      ; move num to edx
    mov eax, edx                ; move num to eax
    shl eax, 3                  ; eax *= 8
    add eax, edx                ; eax = 9 * num
    add eax, edx                ; eax = 10 * num
    add eax, ebx                ; eax = 10 * num + char
    mov dword [rsp+8], eax      ; move result back to num
    jmp _readint_loop
_readint_done:
    cmp byte [rsp+4], 0         ; check if neg flag is set
    je _readint_exit
    xor dword [rsp+8], -1       ; set sign bit if negative
    add dword [rsp+8], 1
_readint_exit:
    mov eax, dword [rsp+8]      ; move num to eax
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


printint:                       ; void printint(int num) --> edi
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 20                 ; align stack to keep 20 bytes for buffering
    cmp edi, 0                  ; compare num to 0
    je _printint_zero           ; 0 is special case
    mov qword [rsp+8], 0        ; clear the buffer
    mov dword [rsp+16], 0       ; 12 bytes from [8, 20)
    mov r8, rsp                 ; position counter
    add r8, 20
    xor r11, r11                ; clear negative tracking register
    cmp edi, 0
    jg _printint_loop           ; don't print negative sign if positive

    inc r11                     ; set neg = true
    neg edi                     ; remove sign bit
_printint_loop:
    cmp edi, 0                  ; compare edi to 0
    je _printint_done           ; if edi == 0 then we are done
    mov     edx, edi            ; move num to edx
    movsxd  rax, edx            ; mov edx to rax
    imul    rax, rax, 1717986919; magic number division
    shr     rax, 34
    mov     ecx, edx
    shr     ecx, 31
    sub     eax, ecx
    mov     edi, eax            ; done division
    shl     eax, 2
    add     eax, edi
    add     eax, eax            ; multiply by 10
    sub     edx, eax            ; subract from original for remainder
    add dl, 48                  ; convert to ascii
    mov byte [r8], dl           ; move remainder to buffer
    dec r8                      ; move 1 position to the left in buffer
    jmp _printint_loop
_printint_done:
    cmp r11, 0                  ; check if number is negative
    je _printint_pos
    mov byte [r8], 45
    dec r8
_printint_pos:
    lea rsi, [rsp+20]           ; set rsi as pointer to end of buffer
    lea rdi, [r8+1]             ; load buffer
    sub rsi, r8                 ; calculate length of buffer
    call _write_buf
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret
_printint_zero:
    mov byte [rsp+2], 48        ; put '0' in rsp+2
    mov rsi, 1                  ; 1 byte
    lea rdi, [rsp+2]            ; load '0' as buf
    call _write_buf
    xor eax, eax                ; clear return register
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


newline:                        ; void newline()
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 4                  ; align stack to keep 4 byte for buffering
    mov byte [rsp], 10          ; put '\n' in buf
    mov esi, 1                  ; 1 byte
    lea rdi, [rsp]              ; load '\n' as buf
    call _write_buf             ; write to output buffer
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


printspace:                     ; void printspace()
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 4                  ; align stack to keep 4 byte for buffering
    mov byte [rsp], 32          ; put ' ' in buf
    mov esi, 1                  ; 1 byte
    lea rdi, [rsp]              ; load ' ' as buf
    call _write_buf             ; write to output buffer
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


_read_buf:                      ; byte _read_buf()
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 8                  ; align stack to keep 8 bytes for buffering
    mov ebx, dword [rel ibuf_start]
    mov eax, dword [rel ibuf_end]
    cmp ebx, eax                ; check if we're at the end of the buffer
    jne _read_buf_done
    xor eax, eax                ; rax = 0 for sys_read
    xor edi, edi                ; rdi = 1 for STDIN
    lea rsi, [rel input_buf]    ; read into input_buf
    mov rdx, 1024               ; read up to 1024 characters
    syscall
    mov dword [rel ibuf_start], 0; reset start of buffer
    mov dword [rel ibuf_end], eax; set end of buffer
_read_buf_done:
    lea rcx, [rel input_buf]    ; load buffer into rcx
    xor r11d, r11d              ; prepare r11d as index
    mov r11d, dword [rel ibuf_start]
    add rcx, r11                ; rcx now pointing to buffer position
    xor eax, eax                ; clear rax
    mov al, byte [rcx]          ; return al
    inc dword [rel ibuf_start]  ; increment pointer
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


write_out:                      ; void write_out(char *buf, int count) --> rdi, esi
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 8                  ; align stack to keep 8 bytes for buffering
    cmp esi, 1024
    jge _write_out_large        ; check if count is greater than 1024
    call _write_buf             ; call _write_buf if count < 1024
    jmp _write_out_done
_write_out_large:
    call flush_obuf             ; flush output buffer
    mov rax, 1                  ; rax = 1 for sys_write
    xor edx, edx                ; clear rdx
    mov edx, esi                ; write [count] bytes
    mov rsi, rdi                ; load buf into rsi
    mov rdi, 1                  ; rdi = 1 for STDOUT
    syscall
_write_out_done:
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret

_write_buf:                     ; void _write_buf(char *buf, int count) --> rdi, esi
    ; warning: only use _write_buf if count is guaranteed to be < 1024 bytes
    ; for variable length output or longer strings, use write_out instead
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 8                  ; align stack to keep 8 bytes for buffering
    mov ebx, dword [rel obuf_start]
    mov ecx, ebx                ; run a check using ecx
    add ecx, esi                ; ecx is size of buf after write
    mov r8, rdi                 ; r8 is new buf pointer
    xor r9d, r9d
    mov r9d, esi                ; r9d is new count variable
    cmp ecx, 1024
    jl _write_buf_l2_init       ; do not print if buffer can hold buf
    call flush_obuf
_write_buf_l2_init:
    xor ebx, ebx                ; clear rbx (index counter)
    lea rax, [rel output_buf]   ; load output buffer into rax
    xor r11d, r11d              ; empty r11 register
    mov r11d, dword [rel obuf_start]
    add rax, r11                ; rax now points to first empty char in buffer
_write_buf_l2:
    cmp ebx, r9d
    je _write_buf_done          ; if index = end of buf, stop writing
    mov cl, byte [r8]           ; move one char from buf to cl
    mov byte [rax], cl          ; move cl to buffer
    inc ebx
    inc rax
    inc r8
    jmp _write_buf_l2
_write_buf_done:
    add dword [obuf_start], r9d ; update start of buffer
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


flush_obuf:                     ; void flush_obuf()
    mov rax, 1                  ; rax = 1 for sys_write
    mov rdi, 1                  ; rdi = 1 for STDOUT
    lea rsi, [rel output_buf]   ; load output buffer
    xor edx, edx                ; clear edx
    mov edx, dword [rel obuf_start]; size of output buffer
    syscall
    mov dword [rel obuf_start], 0; reset obuf counter
    ret


section .bss
input_buf:     resb 1024        ; reserve 1024 bytes
output_buf:    resb 1024        ; reserve 1024 bytes

section .data
ibuf_start:    dd 1024          ; index 1024
ibuf_end:      dd 1024          ; index 1024
obuf_start:    dd 0             ; index 0
troy: db "TroyMartian", 10
tl:   equ $-troy
vlad: db "VladSaturnian", 10
vl:   equ $-vlad
grae: db "GraemeMercurian", 10
gl:    equ $-grae
