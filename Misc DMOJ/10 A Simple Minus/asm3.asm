; libc

default rel

global main

extern printf                                           ; near
extern __isoc99_scanf                                   ; near


SECTION .text                       ; section number 1, code

main:   ; Function begin
        push    rbp                                     ; 0000 _ 55
        mov     rbp, rsp                                ; 0001 _ 48: 89. E5
        sub     rsp, 80                                 ; 0004 _ 48: 83. EC, 50
        mov     dword [rbp-4H], 0                       ; 0008 _ C7. 45, FC, 00000000
        mov     edi, ?_008                              ; 000F _ BF, 00000000(d)
        xor     eax, eax                                ; 0014 _ 31. C0
        mov     cl, al                                  ; 0016 _ 88. C1
        lea     rsi, [rbp-8H]                           ; 0018 _ 48: 8D. 75, F8
        mov     al, cl                                  ; 001C _ 88. C8
        call    __isoc99_scanf                          ; 001E _ E8, 00000000(PLT r)
        mov     edx, dword [rbp-8H]                     ; 0023 _ 8B. 55, F8
        add     edx, -1                                 ; 0026 _ 83. C2, FF
        mov     dword [rbp-8H], edx                     ; 0029 _ 89. 55, F8
        mov     edx, dword [rbp-8H]                     ; 002C _ 8B. 55, F8
        mov     esi, edx                                ; 002F _ 89. D6
        mov     rdi, rsp                                ; 0031 _ 48: 89. E7
        mov     qword [rbp-10H], rdi                    ; 0034 _ 48: 89. 7D, F0
        lea     rdi, [rsi*4+0FH]                        ; 0038 _ 48: 8D. 3C B5, 0000000F
        and     rdi, 0FFFFFFFFFFFFFFF0H                 ; 0040 _ 48: 83. E7, F0
        mov     r8, rsp                                 ; 0044 _ 49: 89. E0
        sub     r8, rdi                                 ; 0047 _ 49: 29. F8
        mov     rsp, r8                                 ; 004A _ 4C: 89. C4
        mov     qword [rbp-18H], rsi                    ; 004D _ 48: 89. 75, E8
        mov     rdi, qword ?_009                        ; 0051 _ 48: BF, 0000000000000000(d)
        lea     rsi, [rbp-20H]                          ; 005B _ 48: 8D. 75, E0
        mov     dword [rbp-2CH], eax                    ; 005F _ 89. 45, D4
        mov     al, 0                                   ; 0062 _ B0, 00
        mov     qword [rbp-38H], r8                     ; 0064 _ 4C: 89. 45, C8
        call    __isoc99_scanf                          ; 0068 _ E8, 00000000(PLT r)
        mov     dword [rbp-24H], 0                      ; 006D _ C7. 45, DC, 00000000
        mov     dword [rbp-3CH], eax                    ; 0074 _ 89. 45, C4
?_001:  mov     eax, dword [rbp-24H]                    ; 0077 _ 8B. 45, DC
        cmp     eax, dword [rbp-8H]                     ; 007A _ 3B. 45, F8
; Note: Immediate operand could be made smaller by sign extension
        jge     ?_002                                   ; 007D _ 0F 8D, 0000003D
        mov     eax, dword [rbp-20H]                    ; 0083 _ 8B. 45, E0
        mov     dword [rbp-1CH], eax                    ; 0086 _ 89. 45, E4
        mov     rdi, qword ?_009                        ; 0089 _ 48: BF, 0000000000000000(d)
        lea     rsi, [rbp-20H]                          ; 0093 _ 48: 8D. 75, E0
        mov     al, 0                                   ; 0097 _ B0, 00
        call    __isoc99_scanf                          ; 0099 _ E8, 00000000(PLT r)
        mov     ecx, dword [rbp-1CH]                    ; 009E _ 8B. 4D, E4
        xor     ecx, dword [rbp-20H]                    ; 00A1 _ 33. 4D, E0
        movsxd  rsi, dword [rbp-24H]                    ; 00A4 _ 48: 63. 75, DC
        mov     rdi, qword [rbp-38H]                    ; 00A8 _ 48: 8B. 7D, C8
        mov     dword [rdi+rsi*4], ecx                  ; 00AC _ 89. 0C B7
        mov     dword [rbp-40H], eax                    ; 00AF _ 89. 45, C0
        mov     eax, dword [rbp-24H]                    ; 00B2 _ 8B. 45, DC
        add     eax, 1                                  ; 00B5 _ 83. C0, 01
        mov     dword [rbp-24H], eax                    ; 00B8 _ 89. 45, DC
; Note: Immediate operand could be made smaller by sign extension
        jmp     ?_001                                   ; 00BB _ E9, FFFFFFB7
; main End of function

?_002:  ; Local function
        mov     dword [rbp-1CH], 214748364              ; 00C0 _ C7. 45, E4, 0CCCCCCC
        mov     dword [rbp-20H], -214748364             ; 00C7 _ C7. 45, E0, F3333334
        mov     dword [rbp-28H], 0                      ; 00CE _ C7. 45, D8, 00000000
?_003:  mov     eax, dword [rbp-28H]                    ; 00D5 _ 8B. 45, D8
        cmp     eax, dword [rbp-8H]                     ; 00D8 _ 3B. 45, F8
; Note: Immediate operand could be made smaller by sign extension
        jge     ?_007                                   ; 00DB _ 0F 8D, 00000057
        movsxd  rax, dword [rbp-28H]                    ; 00E1 _ 48: 63. 45, D8
        mov     rcx, qword [rbp-38H]                    ; 00E5 _ 48: 8B. 4D, C8
        mov     edx, dword [rcx+rax*4]                  ; 00E9 _ 8B. 14 81
        cmp     edx, dword [rbp-1CH]                    ; 00EC _ 3B. 55, E4
; Note: Immediate operand could be made smaller by sign extension
        jge     ?_004                                   ; 00EF _ 0F 8D, 0000000E
        movsxd  rax, dword [rbp-28H]                    ; 00F5 _ 48: 63. 45, D8
        mov     rcx, qword [rbp-38H]                    ; 00F9 _ 48: 8B. 4D, C8
        mov     edx, dword [rcx+rax*4]                  ; 00FD _ 8B. 14 81
        mov     dword [rbp-1CH], edx                    ; 0100 _ 89. 55, E4
?_004:  movsxd  rax, dword [rbp-28H]                    ; 0103 _ 48: 63. 45, D8
        mov     rcx, qword [rbp-38H]                    ; 0107 _ 48: 8B. 4D, C8
        mov     edx, dword [rcx+rax*4]                  ; 010B _ 8B. 14 81
        cmp     edx, dword [rbp-20H]                    ; 010E _ 3B. 55, E0
; Note: Immediate operand could be made smaller by sign extension
        jle     ?_005                                   ; 0111 _ 0F 8E, 0000000E
        movsxd  rax, dword [rbp-28H]                    ; 0117 _ 48: 63. 45, D8
        mov     rcx, qword [rbp-38H]                    ; 011B _ 48: 8B. 4D, C8
        mov     edx, dword [rcx+rax*4]                  ; 011F _ 8B. 14 81
        mov     dword [rbp-20H], edx                    ; 0122 _ 89. 55, E0
?_005:
; Note: Immediate operand could be made smaller by sign extension
        jmp     ?_006                                   ; 0125 _ E9, 00000000

?_006:  mov     eax, dword [rbp-28H]                    ; 012A _ 8B. 45, D8
        add     eax, 1                                  ; 012D _ 83. C0, 01
        mov     dword [rbp-28H], eax                    ; 0130 _ 89. 45, D8
; Note: Immediate operand could be made smaller by sign extension
        jmp     ?_003                                   ; 0133 _ E9, FFFFFF9D

?_007:  ; Local function
        mov     eax, dword [rbp-20H]                    ; 0138 _ 8B. 45, E0
        sub     eax, dword [rbp-1CH]                    ; 013B _ 2B. 45, E4
        mov     rdi, qword ?_008                        ; 013E _ 48: BF, 0000000000000000(d)
        mov     esi, eax                                ; 0148 _ 89. C6
        mov     al, 0                                   ; 014A _ B0, 00
        call    printf                                  ; 014C _ E8, 00000000(PLT r)
        mov     dword [rbp-4H], 0                       ; 0151 _ C7. 45, FC, 00000000
        mov     rdi, qword [rbp-10H]                    ; 0158 _ 48: 8B. 7D, F0
        mov     rsp, rdi                                ; 015C _ 48: 89. FC
        mov     esi, dword [rbp-4H]                     ; 015F _ 8B. 75, FC
        mov     dword [rbp-44H], eax                    ; 0162 _ 89. 45, BC
        mov     eax, esi                                ; 0165 _ 89. F0
        mov     rsp, rbp                                ; 0167 _ 48: 89. EC
        pop     rbp                                     ; 016A _ 5D
        ret                                             ; 016B _ C3


SECTION .rodata.str1.1                ; section number 2, const

?_008:                                                  ; byte
        db 25H, 69H, 0AH, 00H                           ; 0000 _ %i..

?_009:                                                  ; byte
        db 25H, 69H, 00H                                ; 0004 _ %i.


SECTION .eh_frame                     ; section number 3, const

        db 14H, 00H, 00H, 00H, 00H, 00H, 00H, 00H       ; 0000 _ ........
        db 01H, 7AH, 52H, 00H, 01H, 78H, 10H, 01H       ; 0008 _ .zR..x..
        db 1BH, 0CH, 07H, 08H, 90H, 01H, 00H, 00H       ; 0010 _ ........
        db 1CH, 00H, 00H, 00H, 1CH, 00H, 00H, 00H       ; 0018 _ ........
        dd main-$-20H                                   ; 0020 _ 00000000 (rel)
        dd 0000016CH, 100E4100H                         ; 0024 _ 364 269369600 
        dd 0D430286H, 01670306H                         ; 002C _ 222495366 23528198 
        dd 0008070CH                                    ; 0034 _ 526092 