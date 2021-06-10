section .text
global _start

_start:
    push rbp                    ; save base pointer
    mov rbp, rsp                ; place base pointer on stack
    
    ; change 16 bytes to however many bytes you need to allocate
    sub rsp, 16                 ; align stack to keep 16 bytes for buffering
    
    xor r12d, r12d ;ibuf_start
    xor r14d, r14d ;ibuf_end
    xor ebx, ebx   ;obuf_start
    
    ; your code here
    xor r15d, r15d  ; bool a = false;
    xor r13d, r13d  ; char c = 0;
; first char
    call _read_buf  ; c = getchar()
    mov r13d, eax
    cmp r13d, 65    ;     a = c == 'A'
    sete r15b
    mov edi, eax
    call putchar
    call _read_buf  ; c = getchar()
    cmp eax, 64    ; if (c < 64)
    jl end          ;    exit()
loop:
    mov r13d, eax
    cmp r13d, 65
    sete al         ; al = c == 'A'
    mov cl, al      ; cl = c == 'A'
    xor al, r15b    ; al = a ^ al
    test al, al     ; if (both vowel || both consonant)
    jz bad          ;     goto bad
    mov r15b, cl    ; a = c == 'A'
    jmp loop_c
bad:
    call printspace
loop_c:
    mov edi, r13d
    call putchar    ; putchar(c)
    call _read_buf  ; c = getchar()
    cmp eax, 64     ; if (c > 64)
    jg loop         ;    goto loop
end:
    mov eax, 1
    mov edi, 1
    lea rsi, [rel output_buf]
    mov edx, ebx
    syscall
    mov eax, 60                 ; rax = 60 for sys_exit
    xor edi, edi                ; exit code = 0
    syscall


printspace:
    mov dil, 32
    jmp putchar
_read_buf:
    cmp r12d, r14d
    je _read_buf_extra
_read_buf_done:
    lea rcx, [rel input_buf]
    add rcx, r12
    xor eax, eax
    mov al, byte [rcx]
    inc r12d
    ret
_read_buf_extra:
    xor eax, eax
    xor edi, edi
    lea rsi, [rel input_buf]
    mov rdx, 100002
    syscall
    xor r12d, r12d
    mov r14d, eax
    jmp _read_buf_done
putchar:
    lea rax, [rel output_buf]
    add rax, rbx
    mov byte [rax], dil
    inc ebx
    ret


section .bss
input_buf:     resb 100002
output_buf:    resb 200002
