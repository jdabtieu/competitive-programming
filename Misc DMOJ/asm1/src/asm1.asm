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
        lea     rdx, [rbp-14H]                          ; 0017 _ 48: 8D. 55, EC
        lea     rax, [rbp-18H]                          ; 001B _ 48: 8D. 45, E8
        mov     rsi, rax                                ; 001F _ 48: 89. C6
        lea     rdi, [rel ?_006]                        ; 0022 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 0029 _ B8, 00000000
        call    __isoc99_scanf                          ; 002E _ E8, 00000000(PLT r)
        jmp     ?_004                                   ; 0033 _ EB, 3F

?_001:  lea     rax, [rbp-10H]                          ; 0035 _ 48: 8D. 45, F0
        mov     rsi, rax                                ; 0039 _ 48: 89. C6
        lea     rdi, [rel ?_007]                        ; 003C _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 0043 _ B8, 00000000
        call    __isoc99_scanf                          ; 0048 _ E8, 00000000(PLT r)
        mov     edx, dword [rbp-10H]                    ; 004D _ 8B. 55, F0
        mov     eax, dword [rbp-14H]                    ; 0050 _ 8B. 45, EC
        cmp     edx, eax                                ; 0053 _ 39. C2
        jle     ?_002                                   ; 0055 _ 7E, 06
        mov     eax, dword [rbp-10H]                    ; 0057 _ 8B. 45, F0
        mov     dword [rbp-14H], eax                    ; 005A _ 89. 45, EC
?_002:  mov     eax, dword [rbp-10H]                    ; 005D _ 8B. 45, F0
        cmp     dword [rbp-0CH], eax                    ; 0060 _ 39. 45, F4
        jle     ?_003                                   ; 0063 _ 7E, 06
        mov     eax, dword [rbp-10H]                    ; 0065 _ 8B. 45, F0
        mov     dword [rbp-0CH], eax                    ; 0068 _ 89. 45, F4
?_003:  mov     eax, dword [rbp-18H]                    ; 006B _ 8B. 45, E8
        sub     eax, 1                                  ; 006E _ 83. E8, 01
        mov     dword [rbp-18H], eax                    ; 0071 _ 89. 45, E8
?_004:  mov     eax, dword [rbp-18H]                    ; 0074 _ 8B. 45, E8
        cmp     eax, 1                                  ; 0077 _ 83. F8, 01
        jg      ?_001                                   ; 007A _ 7F, B9
        mov     edx, dword [rbp-14H]                    ; 007C _ 8B. 55, EC
        mov     eax, dword [rbp-0CH]                    ; 007F _ 8B. 45, F4
        mov     esi, eax                                ; 0082 _ 89. C6
        lea     rdi, [rel ?_008]                        ; 0084 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 008B _ B8, 00000000
        call    printf                                  ; 0090 _ E8, 00000000(PLT r)
        mov     eax, 0                                  ; 0095 _ B8, 00000000
        mov     rcx, qword [rbp-8H]                     ; 009A _ 48: 8B. 4D, F8
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        xor     rcx, qword [fs:abs 28H]                 ; 009E _ 64 48: 33. 0C 25, 00000028
        jz      ?_005                                   ; 00A7 _ 74, 05
        call    __stack_chk_fail                        ; 00A9 _ E8, 00000000(PLT r)
?_005:  leave                                           ; 00AE _ C9
        ret                                             ; 00AF _ C3
; main End of function


SECTION .rodata                       ; section number 4, const

?_006:                                                  ; byte
        db 25H, 69H, 0AH, 25H, 69H, 00H                 ; 0000 _ %i.%i.

?_007:                                                  ; byte
        db 25H, 69H, 00H                                ; 0006 _ %i.

?_008:                                                  ; byte
        db 25H, 69H, 20H, 25H, 69H, 0AH, 00H            ; 0009 _ %i %i..