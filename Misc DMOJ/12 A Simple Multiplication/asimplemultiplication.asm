; libc

default rel

global main
global binConvert

extern malloc                                           ; near
extern __stack_chk_fail                                 ; near
extern free                                             ; near
extern printf                                           ; near
extern strlen                                           ; near
extern __isoc99_scanf                                   ; near
extern _GLOBAL_OFFSET_TABLE_                            ; byte


SECTION .text                         ; section number 1, code

main:   ; Function begin
        push    rbp                                     ; 0000 _ 55
        mov     rbp, rsp                                ; 0001 _ 48: 89. E5
        sub     rsp, 48                                 ; 0004 _ 48: 83. EC, 30
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        mov     rax, qword [fs:abs 28H]                 ; 0008 _ 64 48: 8B. 04 25, 00000028
        mov     qword [rbp-8H], rax                     ; 0011 _ 48: 89. 45, F8
        xor     eax, eax                                ; 0015 _ 31. C0
        lea     rcx, [rbp-24H]                          ; 0017 _ 48: 8D. 4D, DC
        lea     rdx, [rbp-28H]                          ; 001B _ 48: 8D. 55, D8
        lea     rax, [rbp-2CH]                          ; 001F _ 48: 8D. 45, D4
        mov     rsi, rax                                ; 0023 _ 48: 89. C6
        lea     rdi, [rel ?_011]                        ; 0026 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 002D _ B8, 00000000
        call    __isoc99_scanf                          ; 0032 _ E8, 00000000(PLT r)
        mov     eax, dword [rbp-28H]                    ; 0037 _ 8B. 45, D8
        mov     edi, eax                                ; 003A _ 89. C7
        call    binConvert                              ; 003C _ E8, 00000000(rel)
        mov     qword [rbp-10H], rax                    ; 0041 _ 48: 89. 45, F0
        mov     rax, qword [rbp-10H]                    ; 0045 _ 48: 8B. 45, F0
        mov     rdi, rax                                ; 0049 _ 48: 89. C7
        call    strlen                                  ; 004C _ E8, 00000000(PLT r)
        mov     dword [rbp-14H], eax                    ; 0051 _ 89. 45, EC
        mov     eax, dword [rbp-2CH]                    ; 0054 _ 8B. 45, D4
        mov     dword [rbp-20H], eax                    ; 0057 _ 89. 45, E0
        mov     dword [rbp-1CH], 1                      ; 005A _ C7. 45, E4, 00000001
        mov     rax, qword [rbp-10H]                    ; 0061 _ 48: 8B. 45, F0
        movzx   eax, byte [rax]                         ; 0065 _ 0F B6. 00
        cmp     al, 48                                  ; 0068 _ 3C, 30
        jz      ?_001                                   ; 006A _ 74, 06
        mov     eax, dword [rbp-20H]                    ; 006C _ 8B. 45, E0
        mov     dword [rbp-1CH], eax                    ; 006F _ 89. 45, E4
?_001:  mov     dword [rbp-18H], 1                      ; 0072 _ C7. 45, E8, 00000001
        jmp     ?_004                                   ; 0079 _ EB, 58

?_002:  mov     eax, dword [rbp-20H]                    ; 007B _ 8B. 45, E0
        movsxd  rdx, eax                                ; 007E _ 48: 63. D0
        mov     eax, dword [rbp-20H]                    ; 0081 _ 8B. 45, E0
        cdqe                                            ; 0084 _ 48: 98
        imul    rax, rdx                                ; 0086 _ 48: 0F AF. C2
        mov     edx, dword [rbp-24H]                    ; 008A _ 8B. 55, DC
        movsxd  rcx, edx                                ; 008D _ 48: 63. CA
        cqo                                             ; 0090 _ 48: 99
        idiv    rcx                                     ; 0092 _ 48: F7. F9
        mov     rax, rdx                                ; 0095 _ 48: 89. D0
        mov     dword [rbp-20H], eax                    ; 0098 _ 89. 45, E0
        mov     eax, dword [rbp-18H]                    ; 009B _ 8B. 45, E8
        movsxd  rdx, eax                                ; 009E _ 48: 63. D0
        mov     rax, qword [rbp-10H]                    ; 00A1 _ 48: 8B. 45, F0
        add     rax, rdx                                ; 00A5 _ 48: 01. D0
        movzx   eax, byte [rax]                         ; 00A8 _ 0F B6. 00
        cmp     al, 48                                  ; 00AB _ 3C, 30
        jz      ?_003                                   ; 00AD _ 74, 20
        mov     eax, dword [rbp-1CH]                    ; 00AF _ 8B. 45, E4
        movsxd  rdx, eax                                ; 00B2 _ 48: 63. D0
        mov     eax, dword [rbp-20H]                    ; 00B5 _ 8B. 45, E0
        cdqe                                            ; 00B8 _ 48: 98
        imul    rax, rdx                                ; 00BA _ 48: 0F AF. C2
        mov     edx, dword [rbp-24H]                    ; 00BE _ 8B. 55, DC
        movsxd  rcx, edx                                ; 00C1 _ 48: 63. CA
        cqo                                             ; 00C4 _ 48: 99
        idiv    rcx                                     ; 00C6 _ 48: F7. F9
        mov     rax, rdx                                ; 00C9 _ 48: 89. D0
        mov     dword [rbp-1CH], eax                    ; 00CC _ 89. 45, E4
?_003:  add     dword [rbp-18H], 1                      ; 00CF _ 83. 45, E8, 01
?_004:  mov     eax, dword [rbp-18H]                    ; 00D3 _ 8B. 45, E8
        cmp     eax, dword [rbp-14H]                    ; 00D6 _ 3B. 45, EC
        jl      ?_002                                   ; 00D9 _ 7C, A0
        cmp     dword [rbp-1CH], 0                      ; 00DB _ 83. 7D, E4, 00
        jns     ?_005                                   ; 00DF _ 79, 06
        mov     eax, dword [rbp-24H]                    ; 00E1 _ 8B. 45, DC
        add     dword [rbp-1CH], eax                    ; 00E4 _ 01. 45, E4
?_005:  mov     eax, dword [rbp-1CH]                    ; 00E7 _ 8B. 45, E4
        mov     esi, eax                                ; 00EA _ 89. C6
        lea     rdi, [rel ?_012]                        ; 00EC _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 00F3 _ B8, 00000000
        call    printf                                  ; 00F8 _ E8, 00000000(PLT r)
        mov     rax, qword [rbp-10H]                    ; 00FD _ 48: 8B. 45, F0
        mov     rdi, rax                                ; 0101 _ 48: 89. C7
        call    free                                    ; 0104 _ E8, 00000000(PLT r)
        mov     eax, 0                                  ; 0109 _ B8, 00000000
        mov     rsi, qword [rbp-8H]                     ; 010E _ 48: 8B. 75, F8
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        xor     rsi, qword [fs:abs 28H]                 ; 0112 _ 64 48: 33. 34 25, 00000028
        jz      ?_006                                   ; 011B _ 74, 05
        call    __stack_chk_fail                        ; 011D _ E8, 00000000(PLT r)
?_006:  leave                                           ; 0122 _ C9
        ret                                             ; 0123 _ C3
; main End of function

binConvert:; Function begin
        push    rbp                                     ; 0124 _ 55
        mov     rbp, rsp                                ; 0125 _ 48: 89. E5
        sub     rsp, 32                                 ; 0128 _ 48: 83. EC, 20
        mov     dword [rbp-14H], edi                    ; 012C _ 89. 7D, EC
        mov     eax, dword [rbp-14H]                    ; 012F _ 8B. 45, EC
        mov     dword [rbp-10H], eax                    ; 0132 _ 89. 45, F0
        mov     dword [rbp-0CH], 0                      ; 0135 _ C7. 45, F4, 00000000
        jmp     ?_008                                   ; 013C _ EB, 04

?_007:  add     dword [rbp-0CH], 1                      ; 013E _ 83. 45, F4, 01
?_008:  sar     dword [rbp-10H], 1                      ; 0142 _ D1. 7D, F0
        cmp     dword [rbp-10H], 0                      ; 0145 _ 83. 7D, F0, 00
        jnz     ?_007                                   ; 0149 _ 75, F3
        add     dword [rbp-0CH], 1                      ; 014B _ 83. 45, F4, 01
        mov     eax, dword [rbp-0CH]                    ; 014F _ 8B. 45, F4
        add     eax, 1                                  ; 0152 _ 83. C0, 01
        cdqe                                            ; 0155 _ 48: 98
        mov     rdi, rax                                ; 0157 _ 48: 89. C7
        call    malloc                                  ; 015A _ E8, 00000000(PLT r)
        mov     qword [rbp-8H], rax                     ; 015F _ 48: 89. 45, F8
        mov     dword [rbp-10H], 0                      ; 0163 _ C7. 45, F0, 00000000
        jmp     ?_010                                   ; 016A _ EB, 35

?_009:  mov     eax, dword [rbp-14H]                    ; 016C _ 8B. 45, EC
        cdq                                             ; 016F _ 99
        shr     edx, 31                                 ; 0170 _ C1. EA, 1F
        add     eax, edx                                ; 0173 _ 01. D0
        and     eax, 01H                                ; 0175 _ 83. E0, 01
        sub     eax, edx                                ; 0178 _ 29. D0
        lea     ecx, [rax+30H]                          ; 017A _ 8D. 48, 30
        mov     eax, dword [rbp-10H]                    ; 017D _ 8B. 45, F0
        movsxd  rdx, eax                                ; 0180 _ 48: 63. D0
        mov     rax, qword [rbp-8H]                     ; 0183 _ 48: 8B. 45, F8
        add     rax, rdx                                ; 0187 _ 48: 01. D0
        mov     edx, ecx                                ; 018A _ 89. CA
        mov     byte [rax], dl                          ; 018C _ 88. 10
        mov     eax, dword [rbp-14H]                    ; 018E _ 8B. 45, EC
        mov     edx, eax                                ; 0191 _ 89. C2
        shr     edx, 31                                 ; 0193 _ C1. EA, 1F
        add     eax, edx                                ; 0196 _ 01. D0
        sar     eax, 1                                  ; 0198 _ D1. F8
        mov     dword [rbp-14H], eax                    ; 019A _ 89. 45, EC
        add     dword [rbp-10H], 1                      ; 019D _ 83. 45, F0, 01
?_010:  mov     eax, dword [rbp-10H]                    ; 01A1 _ 8B. 45, F0
        cmp     eax, dword [rbp-0CH]                    ; 01A4 _ 3B. 45, F4
        jl      ?_009                                   ; 01A7 _ 7C, C3
        mov     rax, qword [rbp-8H]                     ; 01A9 _ 48: 8B. 45, F8
        leave                                           ; 01AD _ C9
        ret                                             ; 01AE _ C3
; binConvert End of function


SECTION .rodata                       ; section number 4, const

?_011:                                                  ; byte
        db 25H, 69H, 20H, 25H, 69H, 20H, 25H, 69H       ; 0000 _ %i %i %i
        db 00H                                          ; 0008 _ .

?_012:                                                  ; byte
        db 25H, 69H, 0AH, 00H                           ; 0009 _ %i..


