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
        sub     rsp, 32                                 ; 0004 _ 48: 83. EC, 20
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        mov     rax, qword [fs:abs 28H]                 ; 0008 _ 64 48: 8B. 04 25, 00000028
        mov     qword [rbp-8H], rax                     ; 0011 _ 48: 89. 45, F8
        xor     eax, eax                                ; 0015 _ 31. C0
        lea     rcx, [rbp-0CH]                          ; 0017 _ 48: 8D. 4D, F4
        lea     rdx, [rbp-10H]                          ; 001B _ 48: 8D. 55, F0
        lea     rax, [rbp-14H]                          ; 001F _ 48: 8D. 45, EC
        mov     rsi, rax                                ; 0023 _ 48: 89. C6
        lea     rdi, [rel ?_002]                        ; 0026 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 002D _ B8, 00000000
        call    __isoc99_scanf                          ; 0032 _ E8, 00000000(PLT r)
        mov     edx, dword [rbp-14H]                    ; 0037 _ 8B. 55, EC
        mov     eax, dword [rbp-10H]                    ; 003A _ 8B. 45, F0
        add     edx, eax                                ; 003D _ 01. C2
        mov     eax, dword [rbp-0CH]                    ; 003F _ 8B. 45, F4
        lea     ecx, [rdx+rax]                          ; 0042 _ 8D. 0C 02
        mov     edx, 1431655766                         ; 0045 _ BA, 55555556
        mov     eax, ecx                                ; 004A _ 89. C8
        imul    edx                                     ; 004C _ F7. EA
        mov     eax, ecx                                ; 004E _ 89. C8
        sar     eax, 31                                 ; 0050 _ C1. F8, 1F
        sub     edx, eax                                ; 0053 _ 29. C2
        mov     eax, edx                                ; 0055 _ 89. D0
        mov     esi, eax                                ; 0057 _ 89. C6
        lea     rdi, [rel ?_003]                        ; 0059 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 0060 _ B8, 00000000
        call    printf                                  ; 0065 _ E8, 00000000(PLT r)
        mov     eax, 0                                  ; 006A _ B8, 00000000
        mov     rsi, qword [rbp-8H]                     ; 006F _ 48: 8B. 75, F8
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        xor     rsi, qword [fs:abs 28H]                 ; 0073 _ 64 48: 33. 34 25, 00000028
        jz      ?_001                                   ; 007C _ 74, 05
        call    __stack_chk_fail                        ; 007E _ E8, 00000000(PLT r)
?_001:  leave                                           ; 0083 _ C9
        ret                                             ; 0084 _ C3
; main End of function


SECTION .rodata                       ; section number 4, const

?_002:                                                  ; byte
        db 25H, 69H, 20H, 25H, 69H, 20H, 25H, 69H       ; 0000 _ %i %i %i
        db 00H                                          ; 0008 _ .

?_003:                                                  ; byte
        db 25H, 69H, 0AH, 00H                           ; 0009 _ %i..