; libc

default rel

global main

extern __stack_chk_fail                                 ; near
extern printf                                           ; near
extern __isoc99_scanf                                   ; near
extern _GLOBAL_OFFSET_TABLE_                            ; byte


SECTION .text                         ; section number 1, code

main:   ; Function begin
        push    rbp                                     ; 0000 _ 55
        mov     rbp, rsp                                ; 0001 _ 48: 89. E5
        sub     rsp, 848                                ; 0004 _ 48: 81. EC, 00000350
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        mov     rax, qword [fs:abs 28H]                 ; 000B _ 64 48: 8B. 04 25, 00000028
        mov     qword [rbp-8H], rax                     ; 0014 _ 48: 89. 45, F8
        xor     eax, eax                                ; 0018 _ 31. C0
        lea     rdx, [rbp-344H]                         ; 001A _ 48: 8D. 95, FFFFFCBC
        lea     rax, [rbp-348H]                         ; 0021 _ 48: 8D. 85, FFFFFCB8
        mov     rsi, rax                                ; 0028 _ 48: 89. C6
        lea     rdi, [rel ?_013]                        ; 002B _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 0032 _ B8, 00000000
        call    __isoc99_scanf                          ; 0037 _ E8, 00000000(PLT r)
        mov     dword [rbp-340H], 0                     ; 003C _ C7. 85, FFFFFCC0, 00000000
        jmp     ?_002                                   ; 0046 _ EB, 1A

?_001:  mov     eax, dword [rbp-340H]                   ; 0048 _ 8B. 85, FFFFFCC0
        cdqe                                            ; 004E _ 48: 98
        mov     dword [rbp+rax*4-330H], 0               ; 0050 _ C7. 84 85, FFFFFCD0, 00000000
        add     dword [rbp-340H], 1                     ; 005B _ 83. 85, FFFFFCC0, 01
?_002:  cmp     dword [rbp-340H], 200                   ; 0062 _ 81. BD, FFFFFCC0, 000000C8
        jle     ?_001                                   ; 006C _ 7E, DA
        mov     eax, dword [rbp-344H]                   ; 006E _ 8B. 85, FFFFFCBC
        add     eax, 100                                ; 0074 _ 83. C0, 64
        movsxd  rdx, eax                                ; 0077 _ 48: 63. D0
        mov     edx, dword [rbp+rdx*4-330H]             ; 007A _ 8B. 94 95, FFFFFCD0
        add     edx, 1                                  ; 0081 _ 83. C2, 01
        cdqe                                            ; 0084 _ 48: 98
        mov     dword [rbp+rax*4-330H], edx             ; 0086 _ 89. 94 85, FFFFFCD0
        jmp     ?_004                                   ; 008D _ EB, 49

?_003:  lea     rax, [rbp-344H]                         ; 008F _ 48: 8D. 85, FFFFFCBC
        mov     rsi, rax                                ; 0096 _ 48: 89. C6
        lea     rdi, [rel ?_014]                        ; 0099 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 00A0 _ B8, 00000000
        call    __isoc99_scanf                          ; 00A5 _ E8, 00000000(PLT r)
        mov     eax, dword [rbp-344H]                   ; 00AA _ 8B. 85, FFFFFCBC
        add     eax, 100                                ; 00B0 _ 83. C0, 64
        movsxd  rdx, eax                                ; 00B3 _ 48: 63. D0
        mov     edx, dword [rbp+rdx*4-330H]             ; 00B6 _ 8B. 94 95, FFFFFCD0
        add     edx, 1                                  ; 00BD _ 83. C2, 01
        cdqe                                            ; 00C0 _ 48: 98
        mov     dword [rbp+rax*4-330H], edx             ; 00C2 _ 89. 94 85, FFFFFCD0
        mov     eax, dword [rbp-348H]                   ; 00C9 _ 8B. 85, FFFFFCB8
        sub     eax, 1                                  ; 00CF _ 83. E8, 01
        mov     dword [rbp-348H], eax                   ; 00D2 _ 89. 85, FFFFFCB8
?_004:  mov     eax, dword [rbp-348H]                   ; 00D8 _ 8B. 85, FFFFFCB8
        cmp     eax, 1                                  ; 00DE _ 83. F8, 01
        jg      ?_003                                   ; 00E1 _ 7F, AC
        mov     dword [rbp-33CH], 0                     ; 00E3 _ C7. 85, FFFFFCC4, 00000000
        mov     dword [rbp-338H], 0                     ; 00ED _ C7. 85, FFFFFCC8, 00000000
        jmp     ?_007                                   ; 00F7 _ EB, 33

?_005:  mov     eax, dword [rbp-338H]                   ; 00F9 _ 8B. 85, FFFFFCC8
        cdqe                                            ; 00FF _ 48: 98
        mov     eax, dword [rbp+rax*4-330H]             ; 0101 _ 8B. 84 85, FFFFFCD0
        cmp     dword [rbp-33CH], eax                   ; 0108 _ 39. 85, FFFFFCC4
        jge     ?_006                                   ; 010E _ 7D, 15
        mov     eax, dword [rbp-338H]                   ; 0110 _ 8B. 85, FFFFFCC8
        cdqe                                            ; 0116 _ 48: 98
        mov     eax, dword [rbp+rax*4-330H]             ; 0118 _ 8B. 84 85, FFFFFCD0
        mov     dword [rbp-33CH], eax                   ; 011F _ 89. 85, FFFFFCC4
?_006:  add     dword [rbp-338H], 1                     ; 0125 _ 83. 85, FFFFFCC8, 01
?_007:  cmp     dword [rbp-338H], 200                   ; 012C _ 81. BD, FFFFFCC8, 000000C8
        jle     ?_005                                   ; 0136 _ 7E, C1
        mov     dword [rbp-334H], 0                     ; 0138 _ C7. 85, FFFFFCCC, 00000000
        jmp     ?_010                                   ; 0142 _ EB, 41

?_008:  mov     eax, dword [rbp-334H]                   ; 0144 _ 8B. 85, FFFFFCCC
        cdqe                                            ; 014A _ 48: 98
        mov     eax, dword [rbp+rax*4-330H]             ; 014C _ 8B. 84 85, FFFFFCD0
        cmp     dword [rbp-33CH], eax                   ; 0153 _ 39. 85, FFFFFCC4
        jnz     ?_009                                   ; 0159 _ 75, 23
        mov     eax, dword [rbp-334H]                   ; 015B _ 8B. 85, FFFFFCCC
        sub     eax, 100                                ; 0161 _ 83. E8, 64
        mov     esi, eax                                ; 0164 _ 89. C6
        lea     rdi, [rel ?_015]                        ; 0166 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 016D _ B8, 00000000
        call    printf                                  ; 0172 _ E8, 00000000(PLT r)
        mov     eax, 0                                  ; 0177 _ B8, 00000000
        jmp     ?_011                                   ; 017C _ EB, 18

?_009:  add     dword [rbp-334H], 1                     ; 017E _ 83. 85, FFFFFCCC, 01
?_010:  cmp     dword [rbp-334H], 200                   ; 0185 _ 81. BD, FFFFFCCC, 000000C8
        jle     ?_008                                   ; 018F _ 7E, B3
        mov     eax, 0                                  ; 0191 _ B8, 00000000
?_011:  mov     rcx, qword [rbp-8H]                     ; 0196 _ 48: 8B. 4D, F8
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        xor     rcx, qword [fs:abs 28H]                 ; 019A _ 64 48: 33. 0C 25, 00000028
        jz      ?_012                                   ; 01A3 _ 74, 05
        call    __stack_chk_fail                        ; 01A5 _ E8, 00000000(PLT r)
?_012:  leave                                           ; 01AA _ C9
        ret                                             ; 01AB _ C3
; main End of function


SECTION .rodata                       ; section number 4, const

?_013:                                                  ; byte
        db 25H, 69H, 0AH, 25H, 69H, 00H                 ; 0000 _ %i.%i.

?_014:                                                  ; byte
        db 25H, 69H, 00H                                ; 0006 _ %i.

?_015:                                                  ; byte
        db 25H, 69H, 0AH, 00H                           ; 0009 _ %i..