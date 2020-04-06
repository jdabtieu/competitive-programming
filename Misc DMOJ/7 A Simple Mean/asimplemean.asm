; libc

default rel

global main

extern free                                             ; near
extern __printf_chk                                     ; near
extern __isoc99_scanf                                   ; near
extern malloc                                           ; near
extern _GLOBAL_OFFSET_TABLE_                            ; byte


SECTION .text   align=1                          ; section number 1, code


SECTION .data   align=1                        ; section number 2, data


SECTION .bss    align=1                        ; section number 3, bss


SECTION .rodata.str1.1 align=1                 ; section number 4, const

.LC0:                                                   ; byte
        db 25H, 69H, 20H, 25H, 69H, 20H, 25H, 69H       ; 0000 _ %i %i %i
        db 00H                                          ; 0008 _ .

.LC1:                                                   ; byte
        db 25H, 69H, 0AH, 00H                           ; 0009 _ %i..


SECTION .text.startup align=16                   ; section number 5, code

main:   ; Function begin
        push    r12                                     ; 0000 _ 41: 54
        push    rbp                                     ; 0002 _ 55
        mov     edi, 4                                  ; 0003 _ BF, 00000004
        push    rbx                                     ; 0008 _ 53
        call    malloc                                  ; 0009 _ E8, 00000000(PLT r)
        mov     edi, 4                                  ; 000E _ BF, 00000004
        mov     r12, rax                                ; 0013 _ 49: 89. C4
        call    malloc                                  ; 0016 _ E8, 00000000(PLT r)
        mov     edi, 4                                  ; 001B _ BF, 00000004
        mov     rbp, rax                                ; 0020 _ 48: 89. C5
        call    malloc                                  ; 0023 _ E8, 00000000(PLT r)
        lea     rdi, [rel .LC0]                         ; 0028 _ 48: 8D. 3D, 00000000(rel)
        mov     rbx, rax                                ; 002F _ 48: 89. C3
        mov     rcx, rax                                ; 0032 _ 48: 89. C1
        mov     rdx, rbp                                ; 0035 _ 48: 89. EA
        mov     rsi, r12                                ; 0038 _ 4C: 89. E6
        xor     eax, eax                                ; 003B _ 31. C0
        call    __isoc99_scanf                          ; 003D _ E8, 00000000(PLT r)
        mov     ecx, dword [rbp]                        ; 0042 _ 8B. 4D, 00
        add     ecx, dword [r12]                        ; 0045 _ 41: 03. 0C 24
        mov     edx, 1431655766                         ; 0049 _ BA, 55555556
        add     ecx, dword [rbx]                        ; 004E _ 03. 0B
        lea     rsi, [rel .LC1]                         ; 0050 _ 48: 8D. 35, 00000000(rel)
        mov     edi, 1                                  ; 0057 _ BF, 00000001
        mov     eax, ecx                                ; 005C _ 89. C8
        sar     ecx, 31                                 ; 005E _ C1. F9, 1F
        imul    edx                                     ; 0061 _ F7. EA
        xor     eax, eax                                ; 0063 _ 31. C0
        sub     edx, ecx                                ; 0065 _ 29. CA
        call    __printf_chk                            ; 0067 _ E8, 00000000(PLT r)
        mov     rdi, r12                                ; 006C _ 4C: 89. E7
        call    free                                    ; 006F _ E8, 00000000(PLT r)
        mov     rdi, rbp                                ; 0074 _ 48: 89. EF
        call    free                                    ; 0077 _ E8, 00000000(PLT r)
        mov     rdi, rbx                                ; 007C _ 48: 89. DF
        call    free                                    ; 007F _ E8, 00000000(PLT r)
        pop     rbx                                     ; 0084 _ 5B
        xor     eax, eax                                ; 0085 _ 31. C0
        pop     rbp                                     ; 0087 _ 5D
        pop     r12                                     ; 0088 _ 41: 5C
        ret                                             ; 008A _ C3
; main End of function


