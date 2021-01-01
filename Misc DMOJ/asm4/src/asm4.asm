; libc

default rel

global mul_mod
global qpow
global main

extern __stack_chk_fail                                 ; near
extern printf                                           ; near
extern __isoc99_scanf                                   ; near
extern _GLOBAL_OFFSET_TABLE_                            ; byte


SECTION .text                                           ; section number 1, code

mul_mod:; Function begin
        push    rbp                                     ; 0000 _ 55
        mov     rbp, rsp                                ; 0001 _ 48: 89. E5
        mov     dword [rbp-14H], edi                    ; 0004 _ 89. 7D, EC
        mov     dword [rbp-18H], esi                    ; 0007 _ 89. 75, E8
        mov     dword [rbp-1CH], edx                    ; 000A _ 89. 55, E4
        cmp     dword [rbp-1CH], 0                      ; 000D _ 83. 7D, E4, 00
        jnz     ?_001                                   ; 0011 _ 75, 09
        mov     eax, dword [rbp-14H]                    ; 0013 _ 8B. 45, EC
        imul    eax, dword [rbp-18H]                    ; 0016 _ 0F AF. 45, E8
        jmp     ?_005                                   ; 001A _ EB, 4C

?_001:  mov     dword [rbp-4H], 0                       ; 001C _ C7. 45, FC, 00000000
        jmp     ?_004                                   ; 0023 _ EB, 3A

?_002:  mov     eax, dword [rbp-14H]                    ; 0025 _ 8B. 45, EC
        and     eax, 01H                                ; 0028 _ 83. E0, 01
        test    eax, eax                                ; 002B _ 85. C0
        jz      ?_003                                   ; 002D _ 74, 18
        mov     eax, dword [rbp-18H]                    ; 002F _ 8B. 45, E8
        add     dword [rbp-4H], eax                     ; 0032 _ 01. 45, FC
        mov     eax, dword [rbp-4H]                     ; 0035 _ 8B. 45, FC
        cmp     eax, dword [rbp-1CH]                    ; 0038 _ 3B. 45, E4
        jle     ?_003                                   ; 003B _ 7E, 0A
        mov     eax, dword [rbp-4H]                     ; 003D _ 8B. 45, FC
        cdq                                             ; 0040 _ 99
        idiv    dword [rbp-1CH]                         ; 0041 _ F7. 7D, E4
        mov     dword [rbp-4H], edx                     ; 0044 _ 89. 55, FC
?_003:  sar     dword [rbp-14H], 1                      ; 0047 _ D1. 7D, EC
        shl     dword [rbp-18H], 1                      ; 004A _ D1. 65, E8
        mov     eax, dword [rbp-18H]                    ; 004D _ 8B. 45, E8
        cmp     eax, dword [rbp-1CH]                    ; 0050 _ 3B. 45, E4
        jle     ?_004                                   ; 0053 _ 7E, 0A
        mov     eax, dword [rbp-18H]                    ; 0055 _ 8B. 45, E8
        cdq                                             ; 0058 _ 99
        idiv    dword [rbp-1CH]                         ; 0059 _ F7. 7D, E4
        mov     dword [rbp-18H], edx                    ; 005C _ 89. 55, E8
?_004:  cmp     dword [rbp-14H], 0                      ; 005F _ 83. 7D, EC, 00
        jg      ?_002                                   ; 0063 _ 7F, C0
        mov     eax, dword [rbp-4H]                     ; 0065 _ 8B. 45, FC
?_005:  pop     rbp                                     ; 0068 _ 5D
        ret                                             ; 0069 _ C3
; mul_mod End of function

qpow:   ; Function begin
        push    rbp                                     ; 006A _ 55
        mov     rbp, rsp                                ; 006B _ 48: 89. E5
        sub     rsp, 32                                 ; 006E _ 48: 83. EC, 20
        mov     dword [rbp-14H], edi                    ; 0072 _ 89. 7D, EC
        mov     dword [rbp-18H], esi                    ; 0075 _ 89. 75, E8
        mov     dword [rbp-1CH], edx                    ; 0078 _ 89. 55, E4
        mov     dword [rbp-4H], 1                       ; 007B _ C7. 45, FC, 00000001
        jmp     ?_008                                   ; 0082 _ EB, 37

?_006:  mov     eax, dword [rbp-18H]                    ; 0084 _ 8B. 45, E8
        and     eax, 01H                                ; 0087 _ 83. E0, 01
        test    eax, eax                                ; 008A _ 85. C0
        jz      ?_007                                   ; 008C _ 74, 15
        mov     edx, dword [rbp-1CH]                    ; 008E _ 8B. 55, E4
        mov     ecx, dword [rbp-14H]                    ; 0091 _ 8B. 4D, EC
        mov     eax, dword [rbp-4H]                     ; 0094 _ 8B. 45, FC
        mov     esi, ecx                                ; 0097 _ 89. CE
        mov     edi, eax                                ; 0099 _ 89. C7
        call    mul_mod                                 ; 009B _ E8, 00000000(rel)
        mov     dword [rbp-4H], eax                     ; 00A0 _ 89. 45, FC
?_007:  mov     edx, dword [rbp-1CH]                    ; 00A3 _ 8B. 55, E4
        mov     ecx, dword [rbp-14H]                    ; 00A6 _ 8B. 4D, EC
        mov     eax, dword [rbp-14H]                    ; 00A9 _ 8B. 45, EC
        mov     esi, ecx                                ; 00AC _ 89. CE
        mov     edi, eax                                ; 00AE _ 89. C7
        call    mul_mod                                 ; 00B0 _ E8, 00000000(rel)
        mov     dword [rbp-14H], eax                    ; 00B5 _ 89. 45, EC
        sar     dword [rbp-18H], 1                      ; 00B8 _ D1. 7D, E8
?_008:  cmp     dword [rbp-18H], 0                      ; 00BB _ 83. 7D, E8, 00
        jg      ?_006                                   ; 00BF _ 7F, C3
        mov     eax, dword [rbp-4H]                     ; 00C1 _ 8B. 45, FC
        leave                                           ; 00C4 _ C9
        ret                                             ; 00C5 _ C3
; qpow End of function

main:   ; Function begin
        push    rbp                                     ; 00C6 _ 55
        mov     rbp, rsp                                ; 00C7 _ 48: 89. E5
        sub     rsp, 32                                 ; 00CA _ 48: 83. EC, 20
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        mov     rax, qword [fs:abs 28H]                 ; 00CE _ 64 48: 8B. 04 25, 00000028
        mov     qword [rbp-8H], rax                     ; 00D7 _ 48: 89. 45, F8
        xor     eax, eax                                ; 00DB _ 31. C0
        lea     rcx, [rbp-0CH]                          ; 00DD _ 48: 8D. 4D, F4
        lea     rdx, [rbp-10H]                          ; 00E1 _ 48: 8D. 55, F0
        lea     rax, [rbp-14H]                          ; 00E5 _ 48: 8D. 45, EC
        mov     rsi, rax                                ; 00E9 _ 48: 89. C6
        lea     rdi, [rel ?_010]                        ; 00EC _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 00F3 _ B8, 00000000
        call    __isoc99_scanf                          ; 00F8 _ E8, 00000000(PLT r)
        mov     edx, dword [rbp-0CH]                    ; 00FD _ 8B. 55, F4
        mov     ecx, dword [rbp-10H]                    ; 0100 _ 8B. 4D, F0
        mov     eax, dword [rbp-14H]                    ; 0103 _ 8B. 45, EC
        mov     esi, ecx                                ; 0106 _ 89. CE
        mov     edi, eax                                ; 0108 _ 89. C7
        call    qpow                                    ; 010A _ E8, 00000000(rel)
        mov     esi, eax                                ; 010F _ 89. C6
        lea     rdi, [rel ?_011]                        ; 0111 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 0118 _ B8, 00000000
        call    printf                                  ; 011D _ E8, 00000000(PLT r)
        mov     eax, 0                                  ; 0122 _ B8, 00000000
        mov     rsi, qword [rbp-8H]                     ; 0127 _ 48: 8B. 75, F8
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        xor     rsi, qword [fs:abs 28H]                 ; 012B _ 64 48: 33. 34 25, 00000028
        jz      ?_009                                   ; 0134 _ 74, 05
        call    __stack_chk_fail                        ; 0136 _ E8, 00000000(PLT r)
?_009:  leave                                           ; 013B _ C9
        ret                                             ; 013C _ C3
; main End of function


SECTION .rodata                                         ; section number 4, const

?_010:                                                  ; byte
        db 25H, 69H, 25H, 69H, 25H, 69H, 00H            ; 0000 _ %i%i%i.

?_011:                                                  ; byte
        db 25H, 69H, 0AH, 00H                           ; 0007 _ %i..


