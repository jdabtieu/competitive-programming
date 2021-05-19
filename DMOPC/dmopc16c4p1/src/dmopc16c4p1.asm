section .text
global _start

; int readint()
; byte _read_buf()

; void printint(int num) --> edi
; void newline()
; void printspace()
; void write_out(char *buf, int count) --> rdi, esi
; void _write_buf(char *buf, int count) --> rdi, esi
; void putchar(char c) --> dil
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
    mov r12d, eax
    mov r13d, 84
loop:
    call readint
    popcnt rax, rax
    mov edi, 70
    cmp rax, 1
    cmove edi, r13d
    call putchar
    call newline
    dec r12d
lc:
    cmp r12d, 0
    jg loop
end:
    call flush_obuf             ; flush output buffer very important
    mov eax, 60                 ; rax = 60 for sys_exit
    xor edi, edi                ; exit code = 0
    syscall


readint:
    push rbx
    push rbp
    mov rbp, rsp
    sub rsp, 16
    mov byte [rsp+4], 0
_readint_init:
    call _read_buf
    xor ebx, ebx
    sub al, 48
    cmp al, 9
    ja _readint_init
    mov ebx, eax
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
    lea rbx, [rbx+4*rbx]
    shl rbx, 1
    add rbx, rcx
    jmp _readint_loop
_readint_done:
    mov rax, rbx
    mov rsp, rbp
    pop rbp
    pop rbx
    ret
newline:
    mov dil, 10
    jmp putchar
_read_buf:
    push rbp
    mov rbp, rsp
    sub rsp, 8
    mov ecx, dword [rel ibuf_start]
    mov eax, dword [rel ibuf_end]
    cmp ecx, eax
    je _read_buf_extra
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
_read_buf_extra:
    xor eax, eax
    xor edi, edi
    lea rsi, [rel input_buf]
    mov rdx, 32768
    syscall
    mov dword [rel ibuf_start], 0
    mov dword [rel ibuf_end], eax
    jmp _read_buf_done
putchar:
    cmp dword [rel obuf_start], 32768
    jl _putchar_put
    push rdi
    call flush_obuf
    pop rdi
_putchar_put:
    lea rax, [rel output_buf]
    mov ecx, dword [rel obuf_start]
    add rax, rcx
    mov byte [rax], dil
    add dword [rel obuf_start], 1
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
input_buf:     resb 32768
output_buf:    resb 32768

section .data
ibuf_start:    dd 32768
ibuf_end:      dd 32768
obuf_start:    dd 0
