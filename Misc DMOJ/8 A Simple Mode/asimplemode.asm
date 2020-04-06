; libc

default rel

global main

extern __stack_chk_fail                                 ; near
extern printf                                           ; near
extern free                                             ; near
extern __isoc99_scanf                                   ; near
extern malloc                                           ; near
extern _GLOBAL_OFFSET_TABLE_                            ; byte


SECTION .text   align=1                          ; section number 1, code

main:   ; Function begin
        push    rbp                                     ; 0000 _ 55
        mov     rbp, rsp                                ; 0001 _ 48: 89. E5
        sub     rsp, 848                                ; 0004 _ 48: 81. EC, 00000350
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        mov     rax, qword [fs:abs 28H]                 ; 000B _ 64 48: 8B. 04 25, 00000028
        mov     qword [rbp-8H], rax                     ; 0014 _ 48: 89. 45, F8
        xor     eax, eax                                ; 0018 _ 31. C0
        mov     edi, 4                                  ; 001A _ BF, 00000004
        call    malloc                                  ; 001F _ E8, 00000000(PLT r)
        mov     qword [rbp-340H], rax                   ; 0024 _ 48: 89. 85, FFFFFCC0
        mov     edi, 4                                  ; 002B _ BF, 00000004
        call    malloc                                  ; 0030 _ E8, 00000000(PLT r)
        mov     qword [rbp-338H], rax                   ; 0035 _ 48: 89. 85, FFFFFCC8
        mov     rdx, qword [rbp-338H]                   ; 003C _ 48: 8B. 95, FFFFFCC8
        mov     rax, qword [rbp-340H]                   ; 0043 _ 48: 8B. 85, FFFFFCC0
        mov     rsi, rax                                ; 004A _ 48: 89. C6
        lea     rdi, [rel ?_013]                        ; 004D _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 0054 _ B8, 00000000
        call    __isoc99_scanf                          ; 0059 _ E8, 00000000(PLT r)
        mov     dword [rbp-350H], 0                     ; 005E _ C7. 85, FFFFFCB0, 00000000
        jmp     ?_002                                   ; 0068 _ EB, 1A

?_001:  mov     eax, dword [rbp-350H]                   ; 006A _ 8B. 85, FFFFFCB0
        cdqe                                            ; 0070 _ 48: 98
        mov     dword [rbp+rax*4-330H], 0               ; 0072 _ C7. 84 85, FFFFFCD0, 00000000
        add     dword [rbp-350H], 1                     ; 007D _ 83. 85, FFFFFCB0, 01
?_002:  cmp     dword [rbp-350H], 200                   ; 0084 _ 81. BD, FFFFFCB0, 000000C8
        jle     ?_001                                   ; 008E _ 7E, DA
        mov     rax, qword [rbp-338H]                   ; 0090 _ 48: 8B. 85, FFFFFCC8
        mov     eax, dword [rax]                        ; 0097 _ 8B. 00
        add     eax, 100                                ; 0099 _ 83. C0, 64
        movsxd  rdx, eax                                ; 009C _ 48: 63. D0
        mov     edx, dword [rbp+rdx*4-330H]             ; 009F _ 8B. 94 95, FFFFFCD0
        add     edx, 1                                  ; 00A6 _ 83. C2, 01
        cdqe                                            ; 00A9 _ 48: 98
        mov     dword [rbp+rax*4-330H], edx             ; 00AB _ 89. 94 85, FFFFFCD0
        jmp     ?_004                                   ; 00B2 _ EB, 52

?_003:  mov     rax, qword [rbp-338H]                   ; 00B4 _ 48: 8B. 85, FFFFFCC8
        mov     rsi, rax                                ; 00BB _ 48: 89. C6
        lea     rdi, [rel ?_014]                        ; 00BE _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 00C5 _ B8, 00000000
        call    __isoc99_scanf                          ; 00CA _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-338H]                   ; 00CF _ 48: 8B. 85, FFFFFCC8
        mov     eax, dword [rax]                        ; 00D6 _ 8B. 00
        add     eax, 100                                ; 00D8 _ 83. C0, 64
        movsxd  rdx, eax                                ; 00DB _ 48: 63. D0
        mov     edx, dword [rbp+rdx*4-330H]             ; 00DE _ 8B. 94 95, FFFFFCD0
        add     edx, 1                                  ; 00E5 _ 83. C2, 01
        cdqe                                            ; 00E8 _ 48: 98
        mov     dword [rbp+rax*4-330H], edx             ; 00EA _ 89. 94 85, FFFFFCD0
        mov     rax, qword [rbp-340H]                   ; 00F1 _ 48: 8B. 85, FFFFFCC0
        mov     eax, dword [rax]                        ; 00F8 _ 8B. 00
        lea     edx, [rax-1H]                           ; 00FA _ 8D. 50, FF
        mov     rax, qword [rbp-340H]                   ; 00FD _ 48: 8B. 85, FFFFFCC0
        mov     dword [rax], edx                        ; 0104 _ 89. 10
?_004:  mov     rax, qword [rbp-340H]                   ; 0106 _ 48: 8B. 85, FFFFFCC0
        mov     eax, dword [rax]                        ; 010D _ 8B. 00
        cmp     eax, 1                                  ; 010F _ 83. F8, 01
        jg      ?_003                                   ; 0112 _ 7F, A0
        mov     rax, qword [rbp-340H]                   ; 0114 _ 48: 8B. 85, FFFFFCC0
        mov     rdi, rax                                ; 011B _ 48: 89. C7
        call    free                                    ; 011E _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-338H]                   ; 0123 _ 48: 8B. 85, FFFFFCC8
        mov     rdi, rax                                ; 012A _ 48: 89. C7
        call    free                                    ; 012D _ E8, 00000000(PLT r)
        mov     dword [rbp-34CH], 0                     ; 0132 _ C7. 85, FFFFFCB4, 00000000
        mov     dword [rbp-348H], 0                     ; 013C _ C7. 85, FFFFFCB8, 00000000
        jmp     ?_007                                   ; 0146 _ EB, 33

?_005:  mov     eax, dword [rbp-348H]                   ; 0148 _ 8B. 85, FFFFFCB8
        cdqe                                            ; 014E _ 48: 98
        mov     eax, dword [rbp+rax*4-330H]             ; 0150 _ 8B. 84 85, FFFFFCD0
        cmp     dword [rbp-34CH], eax                   ; 0157 _ 39. 85, FFFFFCB4
        jge     ?_006                                   ; 015D _ 7D, 15
        mov     eax, dword [rbp-348H]                   ; 015F _ 8B. 85, FFFFFCB8
        cdqe                                            ; 0165 _ 48: 98
        mov     eax, dword [rbp+rax*4-330H]             ; 0167 _ 8B. 84 85, FFFFFCD0
        mov     dword [rbp-34CH], eax                   ; 016E _ 89. 85, FFFFFCB4
?_006:  add     dword [rbp-348H], 1                     ; 0174 _ 83. 85, FFFFFCB8, 01
?_007:  cmp     dword [rbp-348H], 200                   ; 017B _ 81. BD, FFFFFCB8, 000000C8
        jle     ?_005                                   ; 0185 _ 7E, C1
        mov     dword [rbp-344H], 0                     ; 0187 _ C7. 85, FFFFFCBC, 00000000
        jmp     ?_010                                   ; 0191 _ EB, 41

?_008:  mov     eax, dword [rbp-344H]                   ; 0193 _ 8B. 85, FFFFFCBC
        cdqe                                            ; 0199 _ 48: 98
        mov     eax, dword [rbp+rax*4-330H]             ; 019B _ 8B. 84 85, FFFFFCD0
        cmp     dword [rbp-34CH], eax                   ; 01A2 _ 39. 85, FFFFFCB4
        jnz     ?_009                                   ; 01A8 _ 75, 23
        mov     eax, dword [rbp-344H]                   ; 01AA _ 8B. 85, FFFFFCBC
        sub     eax, 100                                ; 01B0 _ 83. E8, 64
        mov     esi, eax                                ; 01B3 _ 89. C6
        lea     rdi, [rel ?_015]                        ; 01B5 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 01BC _ B8, 00000000
        call    printf                                  ; 01C1 _ E8, 00000000(PLT r)
        mov     eax, 0                                  ; 01C6 _ B8, 00000000
        jmp     ?_011                                   ; 01CB _ EB, 18

?_009:  add     dword [rbp-344H], 1                     ; 01CD _ 83. 85, FFFFFCBC, 01
?_010:  cmp     dword [rbp-344H], 200                   ; 01D4 _ 81. BD, FFFFFCBC, 000000C8
        jle     ?_008                                   ; 01DE _ 7E, B3
        mov     eax, 0                                  ; 01E0 _ B8, 00000000
?_011:  mov     rcx, qword [rbp-8H]                     ; 01E5 _ 48: 8B. 4D, F8
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        xor     rcx, qword [fs:abs 28H]                 ; 01E9 _ 64 48: 33. 0C 25, 00000028
        jz      ?_012                                   ; 01F2 _ 74, 05
        call    __stack_chk_fail                        ; 01F4 _ E8, 00000000(PLT r)
?_012:  leave                                           ; 01F9 _ C9
        ret                                             ; 01FA _ C3
; main End of function


SECTION .data   align=1                        ; section number 2, data


SECTION .bss    align=1                        ; section number 3, bss


SECTION .rodata align=1                        ; section number 4, const

?_013:                                                  ; byte
        db 25H, 69H, 0AH, 25H, 69H, 00H                 ; 0000 _ %i.%i.

?_014:                                                  ; byte
        db 20H, 25H, 69H, 00H                           ; 0006 _  %i.

?_015:                                                  ; byte
        db 25H, 69H, 0AH, 00H                           ; 000A _ %i..


