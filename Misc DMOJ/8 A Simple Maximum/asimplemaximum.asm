; libc

default rel

global main

extern free                                             ; near
extern printf                                           ; near
extern __isoc99_scanf                                   ; near
extern malloc                                           ; near
extern _GLOBAL_OFFSET_TABLE_                            ; byte


SECTION .text   align=1                          ; section number 1, code

main:   ; Function begin
        push    rbp                                     ; 0000 _ 55
        mov     rbp, rsp                                ; 0001 _ 48: 89. E5
        sub     rsp, 32                                 ; 0004 _ 48: 83. EC, 20
        mov     edi, 4                                  ; 0008 _ BF, 00000004
        call    malloc                                  ; 000D _ E8, 00000000(PLT r)
        mov     qword [rbp-20H], rax                    ; 0012 _ 48: 89. 45, E0
        mov     edi, 4                                  ; 0016 _ BF, 00000004
        call    malloc                                  ; 001B _ E8, 00000000(PLT r)
        mov     qword [rbp-18H], rax                    ; 0020 _ 48: 89. 45, E8
        mov     edi, 4                                  ; 0024 _ BF, 00000004
        call    malloc                                  ; 0029 _ E8, 00000000(PLT r)
        mov     qword [rbp-10H], rax                    ; 002E _ 48: 89. 45, F0
        mov     edi, 4                                  ; 0032 _ BF, 00000004
        call    malloc                                  ; 0037 _ E8, 00000000(PLT r)
        mov     qword [rbp-8H], rax                     ; 003C _ 48: 89. 45, F8
        mov     rdx, qword [rbp-18H]                    ; 0040 _ 48: 8B. 55, E8
        mov     rax, qword [rbp-20H]                    ; 0044 _ 48: 8B. 45, E0
        mov     rsi, rax                                ; 0048 _ 48: 89. C6
        lea     rdi, [rel ?_005]                        ; 004B _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 0052 _ B8, 00000000
        call    __isoc99_scanf                          ; 0057 _ E8, 00000000(PLT r)
        jmp     ?_004                                   ; 005C _ EB, 5F

?_001:  mov     rax, qword [rbp-10H]                    ; 005E _ 48: 8B. 45, F0
        mov     rsi, rax                                ; 0062 _ 48: 89. C6
        lea     rdi, [rel ?_006]                        ; 0065 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 006C _ B8, 00000000
        call    __isoc99_scanf                          ; 0071 _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-10H]                    ; 0076 _ 48: 8B. 45, F0
        mov     edx, dword [rax]                        ; 007A _ 8B. 10
        mov     rax, qword [rbp-18H]                    ; 007C _ 48: 8B. 45, E8
        mov     eax, dword [rax]                        ; 0080 _ 8B. 00
        cmp     edx, eax                                ; 0082 _ 39. C2
        jle     ?_002                                   ; 0084 _ 7E, 0C
        mov     rax, qword [rbp-10H]                    ; 0086 _ 48: 8B. 45, F0
        mov     edx, dword [rax]                        ; 008A _ 8B. 10
        mov     rax, qword [rbp-18H]                    ; 008C _ 48: 8B. 45, E8
        mov     dword [rax], edx                        ; 0090 _ 89. 10
?_002:  mov     rax, qword [rbp-10H]                    ; 0092 _ 48: 8B. 45, F0
        mov     edx, dword [rax]                        ; 0096 _ 8B. 10
        mov     rax, qword [rbp-8H]                     ; 0098 _ 48: 8B. 45, F8
        mov     eax, dword [rax]                        ; 009C _ 8B. 00
        cmp     edx, eax                                ; 009E _ 39. C2
        jge     ?_003                                   ; 00A0 _ 7D, 0C
        mov     rax, qword [rbp-10H]                    ; 00A2 _ 48: 8B. 45, F0
        mov     edx, dword [rax]                        ; 00A6 _ 8B. 10
        mov     rax, qword [rbp-8H]                     ; 00A8 _ 48: 8B. 45, F8
        mov     dword [rax], edx                        ; 00AC _ 89. 10
?_003:  mov     rax, qword [rbp-20H]                    ; 00AE _ 48: 8B. 45, E0
        mov     eax, dword [rax]                        ; 00B2 _ 8B. 00
        lea     edx, [rax-1H]                           ; 00B4 _ 8D. 50, FF
        mov     rax, qword [rbp-20H]                    ; 00B7 _ 48: 8B. 45, E0
        mov     dword [rax], edx                        ; 00BB _ 89. 10
?_004:  mov     rax, qword [rbp-20H]                    ; 00BD _ 48: 8B. 45, E0
        mov     eax, dword [rax]                        ; 00C1 _ 8B. 00
        cmp     eax, 1                                  ; 00C3 _ 83. F8, 01
        jg      ?_001                                   ; 00C6 _ 7F, 96
        mov     rax, qword [rbp-18H]                    ; 00C8 _ 48: 8B. 45, E8
        mov     edx, dword [rax]                        ; 00CC _ 8B. 10
        mov     rax, qword [rbp-8H]                     ; 00CE _ 48: 8B. 45, F8
        mov     eax, dword [rax]                        ; 00D2 _ 8B. 00
        mov     esi, eax                                ; 00D4 _ 89. C6
        lea     rdi, [rel ?_007]                        ; 00D6 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 00DD _ B8, 00000000
        call    printf                                  ; 00E2 _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-20H]                    ; 00E7 _ 48: 8B. 45, E0
        mov     rdi, rax                                ; 00EB _ 48: 89. C7
        call    free                                    ; 00EE _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-18H]                    ; 00F3 _ 48: 8B. 45, E8
        mov     rdi, rax                                ; 00F7 _ 48: 89. C7
        call    free                                    ; 00FA _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-10H]                    ; 00FF _ 48: 8B. 45, F0
        mov     rdi, rax                                ; 0103 _ 48: 89. C7
        call    free                                    ; 0106 _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-8H]                     ; 010B _ 48: 8B. 45, F8
        mov     rdi, rax                                ; 010F _ 48: 89. C7
        call    free                                    ; 0112 _ E8, 00000000(PLT r)
        mov     eax, 0                                  ; 0117 _ B8, 00000000
        leave                                           ; 011C _ C9
        ret                                             ; 011D _ C3
; main End of function


SECTION .data   align=1                        ; section number 2, data


SECTION .bss    align=1                        ; section number 3, bss


SECTION .rodata align=1                        ; section number 4, const

?_005:                                                  ; byte
        db 25H, 69H, 0AH, 25H, 69H, 00H                 ; 0000 _ %i.%i.

?_006:                                                  ; byte
        db 20H, 25H, 69H, 00H                           ; 0006 _  %i.

?_007:                                                  ; byte
        db 25H, 69H, 20H, 25H, 69H, 0AH, 00H            ; 000A _ %i %i..


