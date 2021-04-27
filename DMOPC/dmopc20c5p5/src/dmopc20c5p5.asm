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
    
    ; change 16 bytes to however many bytes you need to allocate
    sub rsp, 16                 ; align stack to keep 16 bytes for buffering
    
    ; your code here
    call readint
    mov r12, rax
    call readint
    mov r13, rax
    
    xor r14d, r14d
l1:
    xor r15d, r15d
l2:
    mov byte [rsp], "Y"
    mov edi, r14d
    add edi, r15d
    popcnt eax, edi
    and eax, 1
    test eax, eax
    jnz l2p
    mov byte [rsp], "B"
l2p:
    lea rdi, [rsp]
    mov esi, 1
    call _write_buf
    inc r15d
    cmp r15d, r13d
    jl l2
l2d:
    call newline
    inc r14d
    cmp r14d, r12d
    jl l1
l1d:
    
end:
    call flush_obuf             ; flush output buffer very important
    mov rax, 60                 ; rax = 60 for sys_exit
    xor rdi, rdi                ; exit code = 0
    syscall


readint:
    push rbp
    mov rbp, rsp
    sub rsp, 16
    mov byte [rsp+4], 0
    mov dword [rsp+8], 0
_readint_init:
    call _read_buf
    cmp al, 45
    je _readint_neg
    cmp al, 48
    jl _readint_init
    cmp al, 57
    jg _readint_init
    sub al, 48
    mov dword [rsp+8], eax
    jmp _readint_loop_init
_readint_neg:
    mov byte [rsp+4], 1
_readint_loop_init:
    lea rsi, [rsp+12]
    xor edi, edi
_readint_loop:
    call _read_buf
    xor ecx, ecx
    mov cl, al
    cmp cl, 48
    jl _readint_done
    sub cl, 48
    mov edx, dword [rsp+8]
    mov eax, edx
    shl eax, 3
    add eax, edx
    add eax, edx
    add eax, ecx
    mov dword [rsp+8], eax
    jmp _readint_loop
_readint_done:
    cmp byte [rsp+4], 0
    je _readint_exit
    neg dword [rsp+8]
_readint_exit:
    mov eax, dword [rsp+8]
    mov rsp, rbp
    pop rbp
    ret
printint:
    push rbp
    mov rbp, rsp
    sub rsp, 20
    cmp edi, 0
    je _printint_zero
    mov qword [rsp+8], 0
    mov dword [rsp+16], 0
    mov r8, rsp
    add r8, 20
    xor r11, r11
    cmp edi, 0
    jg _printint_loop_cond
    inc r11
    neg edi
    jmp _printint_loop_cond
_printint_loop:
    mov edx, edi
    movsxd rax, edx
    imul rax, rax, 1717986919
    shr rax, 34
    mov ecx, edx
    shr ecx, 31
    sub eax, ecx
    mov edi, eax
    shl eax, 2
    add eax, edi
    add eax, eax
    sub edx, eax
    add dl, 48
    mov byte [r8], dl
    dec r8
_printint_loop_cond:
    cmp edi, 0
    jne _printint_loop
_printint_done:
    cmp r11, 0
    je _printint_pos
    mov byte [r8], 45
    dec r8
_printint_pos:
    lea rsi, [rsp+20]
    lea rdi, [r8+1]
    sub rsi, r8
    call _write_buf
    mov rsp, rbp
    pop rbp
    ret
_printint_zero:
    mov byte [rsp+2], 48
    mov rsi, 1
    lea rdi, [rsp+2]
    call _write_buf
    mov rsp, rbp
    pop rbp
    ret
newline:
    push rbp
    mov rbp, rsp
    sub rsp, 4
    mov byte [rsp], 10
    mov esi, 1
    lea rdi, [rsp]
    call _write_buf
    mov rsp, rbp
    pop rbp
    ret
printspace:
    push rbp
    mov rbp, rsp
    sub rsp, 4
    mov byte [rsp], 32
    mov esi, 1
    lea rdi, [rsp]
    call _write_buf
    mov rsp, rbp
    pop rbp
    ret
_read_buf:
    push rbp
    mov rbp, rsp
    sub rsp, 8
    mov ecx, dword [rel ibuf_start]
    mov eax, dword [rel ibuf_end]
    cmp ecx, eax
    jne _read_buf_done
    xor eax, eax
    xor edi, edi
    lea rsi, [rel input_buf]
    mov rdx, 8192
    syscall
    mov dword [rel ibuf_start], 0
    mov dword [rel ibuf_end], eax
_read_buf_done:
    lea rcx, [rel input_buf]
    xor r11d, r11d
    mov r11d, dword [rel ibuf_start]
    add rcx, r11
    xor eax, eax
    mov al, byte [rcx]
    inc dword [rel ibuf_start]
    mov rsp, rbp
    pop rbp
    ret
write_out:
    push rbp
    mov rbp, rsp
    sub rsp, 8
    cmp esi, 8192
    jge _write_out_large
    call _write_buf
    jmp _write_out_done
_write_out_large:
    call flush_obuf
    mov rax, 1
    xor edx, edx
    mov edx, esi
    mov rsi, rdi
    mov rdi, 1
    syscall
_write_out_done:
    mov rsp, rbp
    pop rbp
    ret
_write_buf:
    push rbp
    mov rbp, rsp
    sub rsp, 8
    mov ecx, dword [rel obuf_start]
    add ecx, esi
    mov r8, rdi
    xor r9d, r9d
    mov r9d, esi
    cmp ecx, 8192
    jl _write_buf_l2_init
    call flush_obuf
_write_buf_l2_init:
    xor ecx, ecx
    lea rax, [rel output_buf]
    xor r11d, r11d
    mov r11d, dword [rel obuf_start]
    add rax, r11
    jmp _write_buf_l2_cond
_write_buf_l2:
    mov r11b, byte [r8]
    mov byte [rax], r11b
    inc ecx
    inc rax
    inc r8
_write_buf_l2_cond:
    cmp ecx, r9d
    jne _write_buf_l2
_write_buf_done:
    add dword [obuf_start], r9d
    mov rsp, rbp
    pop rbp
    ret
flush_obuf:
    mov rax, 1
    mov rdi, 1
    lea rsi, [rel output_buf]
    xor edx, edx
    mov edx, dword [rel obuf_start]
    syscall
    mov dword [rel obuf_start], 0
    ret


section .bss
input_buf:     resb 8192
output_buf:    resb 8192

section .data
ibuf_start:    dd 8192
ibuf_end:      dd 8192
obuf_start:    dd 0
