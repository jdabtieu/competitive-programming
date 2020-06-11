; libc

default rel

global main
global binConvert

extern malloc                                           ; near
extern __stack_chk_fail                                 ; near
extern printf                                           ; near
extern strlen                                           ; near
extern __isoc99_scanf                                   ; near
extern _GLOBAL_OFFSET_TABLE_                            ; byte


SECTION .text                         ; section number 1, code

main:   ; Function begin
        push    rbp                                     ; 0000 _ 55
        mov     rbp, rsp                                ; 0001 _ 48: 89. E5
        push    r15                                     ; 0004 _ 41: 57
        push    r14                                     ; 0006 _ 41: 56
        push    r13                                     ; 0008 _ 41: 55
        push    r12                                     ; 000A _ 41: 54
        push    rbx                                     ; 000C _ 53
        sub     rsp, 72                                 ; 000D _ 48: 83. EC, 48
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        mov     rax, qword [fs:abs 28H]                 ; 0011 _ 64 48: 8B. 04 25, 00000028
        mov     qword [rbp-38H], rax                    ; 001A _ 48: 89. 45, C8
        xor     eax, eax                                ; 001E _ 31. C0
        mov     rax, rsp                                ; 0020 _ 48: 89. E0
        mov     rbx, rax                                ; 0023 _ 48: 89. C3
        lea     rcx, [rbp-64H]                          ; 0026 _ 48: 8D. 4D, 9C
        lea     rdx, [rbp-68H]                          ; 002A _ 48: 8D. 55, 98
        lea     rax, [rbp-6CH]                          ; 002E _ 48: 8D. 45, 94
        mov     rsi, rax                                ; 0032 _ 48: 89. C6
        lea     rdi, [rel ?_012]                        ; 0035 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 003C _ B8, 00000000
        call    __isoc99_scanf                          ; 0041 _ E8, 00000000(PLT r)
        mov     eax, dword [rbp-68H]                    ; 0046 _ 8B. 45, 98
        mov     edi, eax                                ; 0049 _ 89. C7
        call    binConvert                              ; 004B _ E8, 00000000(rel)
        mov     qword [rbp-50H], rax                    ; 0050 _ 48: 89. 45, B0
        mov     rax, qword [rbp-50H]                    ; 0054 _ 48: 8B. 45, B0
        mov     rdi, rax                                ; 0058 _ 48: 89. C7
        call    strlen                                  ; 005B _ E8, 00000000(PLT r)
        mov     dword [rbp-54H], eax                    ; 0060 _ 89. 45, AC
        mov     eax, dword [rbp-54H]                    ; 0063 _ 8B. 45, AC
        movsxd  rdx, eax                                ; 0066 _ 48: 63. D0
        sub     rdx, 1                                  ; 0069 _ 48: 83. EA, 01
        mov     qword [rbp-48H], rdx                    ; 006D _ 48: 89. 55, B8
        movsxd  rdx, eax                                ; 0071 _ 48: 63. D0
        mov     r14, rdx                                ; 0074 _ 49: 89. D6
        mov     r15d, 0                                 ; 0077 _ 41: BF, 00000000
        movsxd  rdx, eax                                ; 007D _ 48: 63. D0
        mov     r12, rdx                                ; 0080 _ 49: 89. D4
        mov     r13d, 0                                 ; 0083 _ 41: BD, 00000000
        cdqe                                            ; 0089 _ 48: 98
        shl     rax, 2                                  ; 008B _ 48: C1. E0, 02
        lea     rdx, [rax+3H]                           ; 008F _ 48: 8D. 50, 03
        mov     eax, 16                                 ; 0093 _ B8, 00000010
        sub     rax, 1                                  ; 0098 _ 48: 83. E8, 01
        add     rax, rdx                                ; 009C _ 48: 01. D0
        mov     esi, 16                                 ; 009F _ BE, 00000010
        mov     edx, 0                                  ; 00A4 _ BA, 00000000
        div     rsi                                     ; 00A9 _ 48: F7. F6
        imul    rax, rax, 16                            ; 00AC _ 48: 6B. C0, 10
        sub     rsp, rax                                ; 00B0 _ 48: 29. C4
        mov     rax, rsp                                ; 00B3 _ 48: 89. E0
        add     rax, 3                                  ; 00B6 _ 48: 83. C0, 03
        shr     rax, 2                                  ; 00BA _ 48: C1. E8, 02
        shl     rax, 2                                  ; 00BE _ 48: C1. E0, 02
        mov     qword [rbp-40H], rax                    ; 00C2 _ 48: 89. 45, C0
        mov     edx, dword [rbp-6CH]                    ; 00C6 _ 8B. 55, 94
        mov     rax, qword [rbp-40H]                    ; 00C9 _ 48: 8B. 45, C0
        mov     dword [rax], edx                        ; 00CD _ 89. 10
        mov     dword [rbp-58H], 1                      ; 00CF _ C7. 45, A8, 00000001
        jmp     ?_002                                   ; 00D6 _ EB, 4A

?_001:  mov     eax, dword [rbp-58H]                    ; 00D8 _ 8B. 45, A8
        lea     edx, [rax-1H]                           ; 00DB _ 8D. 50, FF
        mov     rax, qword [rbp-40H]                    ; 00DE _ 48: 8B. 45, C0
        movsxd  rdx, edx                                ; 00E2 _ 48: 63. D2
        mov     eax, dword [rax+rdx*4]                  ; 00E5 _ 8B. 04 90
        movsxd  rcx, eax                                ; 00E8 _ 48: 63. C8
        mov     eax, dword [rbp-58H]                    ; 00EB _ 8B. 45, A8
        lea     edx, [rax-1H]                           ; 00EE _ 8D. 50, FF
        mov     rax, qword [rbp-40H]                    ; 00F1 _ 48: 8B. 45, C0
        movsxd  rdx, edx                                ; 00F5 _ 48: 63. D2
        mov     eax, dword [rax+rdx*4]                  ; 00F8 _ 8B. 04 90
        cdqe                                            ; 00FB _ 48: 98
        imul    rax, rcx                                ; 00FD _ 48: 0F AF. C1
        mov     edx, dword [rbp-64H]                    ; 0101 _ 8B. 55, 9C
        movsxd  rcx, edx                                ; 0104 _ 48: 63. CA
        cqo                                             ; 0107 _ 48: 99
        idiv    rcx                                     ; 0109 _ 48: F7. F9
        mov     rax, rdx                                ; 010C _ 48: 89. D0
        mov     ecx, eax                                ; 010F _ 89. C1
        mov     rax, qword [rbp-40H]                    ; 0111 _ 48: 8B. 45, C0
        mov     edx, dword [rbp-58H]                    ; 0115 _ 8B. 55, A8
        movsxd  rdx, edx                                ; 0118 _ 48: 63. D2
        mov     dword [rax+rdx*4], ecx                  ; 011B _ 89. 0C 90
        add     dword [rbp-58H], 1                      ; 011E _ 83. 45, A8, 01
?_002:  mov     eax, dword [rbp-58H]                    ; 0122 _ 8B. 45, A8
        cmp     eax, dword [rbp-54H]                    ; 0125 _ 3B. 45, AC
        jl      ?_001                                   ; 0128 _ 7C, AE
        mov     dword [rbp-5CH], 1                      ; 012A _ C7. 45, A4, 00000001
        mov     dword [rbp-60H], 0                      ; 0131 _ C7. 45, A0, 00000000
        jmp     ?_005                                   ; 0138 _ EB, 42

?_003:  mov     eax, dword [rbp-60H]                    ; 013A _ 8B. 45, A0
        movsxd  rdx, eax                                ; 013D _ 48: 63. D0
        mov     rax, qword [rbp-50H]                    ; 0140 _ 48: 8B. 45, B0
        add     rax, rdx                                ; 0144 _ 48: 01. D0
        movzx   eax, byte [rax]                         ; 0147 _ 0F B6. 00
        cmp     al, 48                                  ; 014A _ 3C, 30
        jz      ?_004                                   ; 014C _ 74, 2A
        mov     eax, dword [rbp-5CH]                    ; 014E _ 8B. 45, A4
        movsxd  rcx, eax                                ; 0151 _ 48: 63. C8
        mov     rax, qword [rbp-40H]                    ; 0154 _ 48: 8B. 45, C0
        mov     edx, dword [rbp-60H]                    ; 0158 _ 8B. 55, A0
        movsxd  rdx, edx                                ; 015B _ 48: 63. D2
        mov     eax, dword [rax+rdx*4]                  ; 015E _ 8B. 04 90
        cdqe                                            ; 0161 _ 48: 98
        imul    rax, rcx                                ; 0163 _ 48: 0F AF. C1
        mov     edx, dword [rbp-64H]                    ; 0167 _ 8B. 55, 9C
        movsxd  rcx, edx                                ; 016A _ 48: 63. CA
        cqo                                             ; 016D _ 48: 99
        idiv    rcx                                     ; 016F _ 48: F7. F9
        mov     rax, rdx                                ; 0172 _ 48: 89. D0
        mov     dword [rbp-5CH], eax                    ; 0175 _ 89. 45, A4
?_004:  add     dword [rbp-60H], 1                      ; 0178 _ 83. 45, A0, 01
?_005:  mov     eax, dword [rbp-60H]                    ; 017C _ 8B. 45, A0
        cmp     eax, dword [rbp-54H]                    ; 017F _ 3B. 45, AC
        jl      ?_003                                   ; 0182 _ 7C, B6
        cmp     dword [rbp-5CH], 0                      ; 0184 _ 83. 7D, A4, 00
        jns     ?_006                                   ; 0188 _ 79, 06
        mov     eax, dword [rbp-64H]                    ; 018A _ 8B. 45, 9C
        add     dword [rbp-5CH], eax                    ; 018D _ 01. 45, A4
?_006:  mov     eax, dword [rbp-5CH]                    ; 0190 _ 8B. 45, A4
        mov     esi, eax                                ; 0193 _ 89. C6
        lea     rdi, [rel ?_013]                        ; 0195 _ 48: 8D. 3D, 00000000(rel)
        mov     eax, 0                                  ; 019C _ B8, 00000000
        call    printf                                  ; 01A1 _ E8, 00000000(PLT r)
        mov     rsp, rbx                                ; 01A6 _ 48: 89. DC
        mov     eax, 0                                  ; 01A9 _ B8, 00000000
        mov     rsi, qword [rbp-38H]                    ; 01AE _ 48: 8B. 75, C8
; Note: Address is not rip-relative
; Note: Absolute memory address without relocation
        xor     rsi, qword [fs:abs 28H]                 ; 01B2 _ 64 48: 33. 34 25, 00000028
        jz      ?_007                                   ; 01BB _ 74, 05
        call    __stack_chk_fail                        ; 01BD _ E8, 00000000(PLT r)
?_007:  lea     rsp, [rbp-28H]                          ; 01C2 _ 48: 8D. 65, D8
        pop     rbx                                     ; 01C6 _ 5B
        pop     r12                                     ; 01C7 _ 41: 5C
        pop     r13                                     ; 01C9 _ 41: 5D
        pop     r14                                     ; 01CB _ 41: 5E
        pop     r15                                     ; 01CD _ 41: 5F
        pop     rbp                                     ; 01CF _ 5D
        ret                                             ; 01D0 _ C3
; main End of function

binConvert:; Function begin
        push    rbp                                     ; 01D1 _ 55
        mov     rbp, rsp                                ; 01D2 _ 48: 89. E5
        sub     rsp, 32                                 ; 01D5 _ 48: 83. EC, 20
        mov     dword [rbp-14H], edi                    ; 01D9 _ 89. 7D, EC
        mov     eax, dword [rbp-14H]                    ; 01DC _ 8B. 45, EC
        mov     dword [rbp-10H], eax                    ; 01DF _ 89. 45, F0
        mov     dword [rbp-0CH], 0                      ; 01E2 _ C7. 45, F4, 00000000
        jmp     ?_009                                   ; 01E9 _ EB, 04

?_008:  add     dword [rbp-0CH], 1                      ; 01EB _ 83. 45, F4, 01
?_009:  sar     dword [rbp-10H], 1                      ; 01EF _ D1. 7D, F0
        cmp     dword [rbp-10H], 0                      ; 01F2 _ 83. 7D, F0, 00
        jnz     ?_008                                   ; 01F6 _ 75, F3
        add     dword [rbp-0CH], 1                      ; 01F8 _ 83. 45, F4, 01
        mov     eax, dword [rbp-0CH]                    ; 01FC _ 8B. 45, F4
        add     eax, 1                                  ; 01FF _ 83. C0, 01
        cdqe                                            ; 0202 _ 48: 98
        mov     rdi, rax                                ; 0204 _ 48: 89. C7
        call    malloc                                  ; 0207 _ E8, 00000000(PLT r)
        mov     qword [rbp-8H], rax                     ; 020C _ 48: 89. 45, F8
        mov     dword [rbp-10H], 0                      ; 0210 _ C7. 45, F0, 00000000
        jmp     ?_011                                   ; 0217 _ EB, 35

?_010:  mov     eax, dword [rbp-14H]                    ; 0219 _ 8B. 45, EC
        cdq                                             ; 021C _ 99
        shr     edx, 31                                 ; 021D _ C1. EA, 1F
        add     eax, edx                                ; 0220 _ 01. D0
        and     eax, 01H                                ; 0222 _ 83. E0, 01
        sub     eax, edx                                ; 0225 _ 29. D0
        lea     ecx, [rax+30H]                          ; 0227 _ 8D. 48, 30
        mov     eax, dword [rbp-10H]                    ; 022A _ 8B. 45, F0
        movsxd  rdx, eax                                ; 022D _ 48: 63. D0
        mov     rax, qword [rbp-8H]                     ; 0230 _ 48: 8B. 45, F8
        add     rax, rdx                                ; 0234 _ 48: 01. D0
        mov     edx, ecx                                ; 0237 _ 89. CA
        mov     byte [rax], dl                          ; 0239 _ 88. 10
        mov     eax, dword [rbp-14H]                    ; 023B _ 8B. 45, EC
        mov     edx, eax                                ; 023E _ 89. C2
        shr     edx, 31                                 ; 0240 _ C1. EA, 1F
        add     eax, edx                                ; 0243 _ 01. D0
        sar     eax, 1                                  ; 0245 _ D1. F8
        mov     dword [rbp-14H], eax                    ; 0247 _ 89. 45, EC
        add     dword [rbp-10H], 1                      ; 024A _ 83. 45, F0, 01
?_011:  mov     eax, dword [rbp-10H]                    ; 024E _ 8B. 45, F0
        cmp     eax, dword [rbp-0CH]                    ; 0251 _ 3B. 45, F4
        jl      ?_010                                   ; 0254 _ 7C, C3
        mov     rax, qword [rbp-8H]                     ; 0256 _ 48: 8B. 45, F8
        leave                                           ; 025A _ C9
        ret                                             ; 025B _ C3
; binConvert End of function


SECTION .data                       ; section number 2, data


SECTION .bss                       ; section number 3, bss


SECTION .rodata                       ; section number 4, const

?_012:                                                  ; byte
        db 25H, 69H, 20H, 25H, 69H, 20H, 25H, 69H       ; 0000 _ %i %i %i
        db 00H                                          ; 0008 _ .

?_013:                                                  ; byte
        db 25H, 69H, 0AH, 00H                           ; 0009 _ %i..