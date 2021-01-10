section .text
global  _start

_start:
    ; print msg
    mov     rax, 1
    mov     rdi, 1
    mov     rsi, msg
    mov     rdx, len
    syscall
    ; exit
    mov     rax, 60
    xor     rdi, rdi
    syscall

section .data
       msg     db      "Hello, World!", 0xA
       len     equ     $ - msg
