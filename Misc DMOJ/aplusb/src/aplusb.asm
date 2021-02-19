section .text
global _start

_start:
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 16                 ; align stack to keep 16 bytes for buffering

    call readint                ; result stored in eax
    mov dword [rsp+4], eax      ; i = readint()
loop:
    cmp dword [rsp+4], 0        ; while (i > 0)
    je done
    call readint
    mov dword [rsp+8], eax
    call readint
    add dword [rsp+8], eax
    mov edi, dword [rsp+8]
    call printint               ; print result
    call newline                ; print newline
    dec dword [rsp+4]           ; i--
    jmp loop
done:
    mov rax, 60                 ; rax = 60 for sys_exit
    xor rdi, rdi                ; exit code = 0
    syscall


readint:
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


printint:                       ; num in edi
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
    lea rdx, [rsp+20]           ; set rdx as pointer to end of buffer
    lea rsi, [r8+1]             ; load buffer
    sub rdx, r8                 ; calculate length of buffer
    mov rax, 1                  ; rax = 1 for sys_write
    mov rdi, 1                  ; rdi = 1 for STDOUT
    syscall

    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret
_printint_zero:
    mov byte [rsp+2], 48        ; put '0' in rsp+2
    mov rax, 1                  ; rax = 1 for sys_write
    mov rdi, 1                  ; rdi = 1 for STDOUT
    lea rsi, [rsp+2]            ; load '0' as buf
    mov rdx, 1                  ; print 1 byte
    syscall

    xor eax, eax                ; clear return register
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


newline:
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 4                  ; align stack to keep 4 byte for buffering
    mov byte [rsp], 10          ; put '\n' in buf
    mov rax, 1                  ; rax = 1 for sys_write
    mov rdi, 1                  ; rdi = 1 for STDOUT
    lea rsi, [rsp]              ; load '\n' as buf
    mov rdx, 1                  ; print 1 byte
    syscall
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret


printspace:
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    sub rsp, 4                  ; align stack to keep 4 byte for buffering
    mov byte [rsp], 32          ; put ' ' in buf
    mov rax, 1                  ; rax = 1 for sys_write
    mov rdi, 1                  ; rdi = 1 for STDOUT
    lea rsi, [rsp]              ; load ' ' as buf
    mov rdx, 1                  ; print 1 byte
    syscall
    mov rsp, rbp                ; restore stack and base pointers
    pop rbp
    ret

_read_buf:
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

section .bss
input_buf:     resb 1024        ; reserve 1024 bytes

section .data
ibuf_start:    dd 1024          ; index 1024
ibuf_end:      dd 1024          ; index 1024
