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
    xor eax, eax
    xor edi, edi
    lea rsi, [rel input_buf]
    mov rdx, 32
    syscall
    mov dword [rel ibuf_start], 0
    xor ebx, ebx
    xor r12d, r12d
.loop:
    call _read_buf
    and eax, 1
    add r12d, eax
.lc:
    call _read_buf
    inc ebx
    cmp ebx, 6
    jl .loop
    neg r12d
    lea rdi, [r12d+8]
    shr edi, 1
    cmp edi, 4
    je .inv
    add edi, 48
    call putchar
    call newline
    jmp end
    ; your code here
.inv:
    mov edi, 45
    call putchar
    mov edi, 49
    call putchar
    mov edi, 32
    call putchar
    call newline
end:
    mov eax, 1
    mov edi, 1
    lea esi, [rel output_buf]
    mov edx, dword [rel obuf_start]
    syscall
    mov eax, 60                 ; rax = 60 for sys_exit
    xor edi, edi                ; exit code = 0
    syscall

align 16
newline:
    mov edi, 10
    jmp putchar

align 16
_read_buf:
    lea rcx, [rel input_buf]
    mov r11d, dword [rel ibuf_start]
    add rcx, r11
    xor eax, eax
    mov al, byte [rcx]
    inc dword [rel ibuf_start]
    ret

align 16
putchar:
    lea rax, [rel output_buf]
    mov ecx, dword [rel obuf_start]
    add rax, rcx
    mov byte [rax], dil
    inc dword [rel obuf_start]
    ret

section .bss
input_buf:     resb 1024
output_buf:    resb 1024

section .data
ibuf_start:    dd 0
obuf_start:    dd 0
