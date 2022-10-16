.global _start
.data
buf: .skip 1024
.text
_start:
call main
call _exit

f:
pushq %rbp
movq %rsp, %rbp
movq $0, %rax
movq %rbp, %rsp
popq %rbp
ret

main:
pushq %rbp
movq %rsp, %rbp
call f
addq $0, %rsp
movq $0, %rax
movq %rbp, %rsp
popq %rbp
ret

movq $0, %rax
popq %rbp
ret

_exit:
movq %rax, %rdi   # exit code = 0
movq $60, %rax  # sys_exit
syscall
print:
pushq %rbp
movq %rsp, %rbp
### Convert integer to string (itoa).
movq 16(%rbp), %rax
leaq buf(%rip), %rsi # RSI = write pointer (starts at end of buffer)
addq $1023, %rsi
movb $0x0A, (%rsi) # insert newline
movq $1, %rcx # RCX = string length
cmpq $0, %rax
jge itoa_loop
negq %rax # negate to make RAX positive
itoa_loop: # do.. while (at least one iteration)
movq $10, %rdi
movq $0, %rdx
idivq %rdi # divide RDX:RAX by 10
addb $0x30, %dl
decq %rsi # move string pointer
movb %dl, (%rsi)
incq %rcx # increment string length
cmpq $0, %rax
jg itoa_loop # produce more digits
itoa_done:
movq 16(%rbp), %rax
cmpq $0, %rax
jge print_end
decq %rsi
incq %rcx
movb $0x2D, (%rsi)
print_end:
movq $1, %rdi
movq %rcx, %rdx
movq $1, %rax
syscall
popq %rbp
ret
