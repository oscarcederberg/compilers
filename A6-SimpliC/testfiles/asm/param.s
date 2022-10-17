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
subq $0, %rsp
movq 16(%rbp), %rax
pushq %rax
movq 24(%rbp), %rax
movq %rax, %rbx
popq %rax
addq %rbx, %rax
push %rax
call print
addq $8, %rsp
movq $0, %rax
movq %rbp, %rsp
popq %rbp
ret

main:
pushq %rbp
movq %rsp, %rbp
subq $0, %rsp
movq $2, %rax
push %rax
movq $1, %rax
push %rax
call f
addq $16, %rsp
movq $0, %rax
movq %rbp, %rsp
popq %rbp
ret

movq $0, %rax
movq %rbp, %rsp
popq %rbp
ret

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

read:
pushq %rbp
movq %rsp, %rbp
### R9 = sign
movq $1, %r9 # sign <- 1
### R10 = sum
movq $0, %r10 # sum <- 0
skip_ws: # skip any leading whitespace
movq $0, %rdi
leaq buf(%rip), %rsi
movq $1, %rdx
movq $0, %rax
syscall # get one char: sys_read(0, buf, 1)
cmpq $0, %rax
jle atoi_done # nchar <= 0
movb (%rsi), %cl # c <- current char
cmp $32, %cl
je skip_ws # c == space
cmp $13, %cl
je skip_ws # c == CR
cmp $10, %cl
je skip_ws # c == NL
cmp $9, %cl
je skip_ws # c == tab
cmp $45, %cl # check if negative
jne atoi_loop
movq $-1, %r9 # sign <- -1
movq $0, %rdi
leaq buf(%rip), %rsi
movq $1, %rdx
movq $0, %rax
syscall # get one char: sys_read(0, buf, 1)
atoi_loop:
cmpq $0, %rax # while (nchar > 0)
jle atoi_done # leave loop if nchar <= 0
movzbq (%rsi), %rcx # move byte, zero extend to quad-word
cmpq $0x30, %rcx
jl atoi_done # character is not numeric
cmpq $0x39, %rcx
jg atoi_done # character is not numeric
imulq $10, %r10 # multiply sum by 10
subq $0x30, %rcx # value of character
addq %rcx, %r10 # add to sum
movq $0, %rdi
leaq buf(%rip), %rsi
movq $1, %rdx
movq $0, %rax
syscall # get one char: sys_read(0, buf, 1)
jmp atoi_loop # loop back
atoi_done:
imulq %r9, %r10 # sum *= sign
movq %r10, %rax # put result value in RAX
popq %rbp
ret

_exit:
movq %rax, %rdi   # exit code = 0
movq $60, %rax  # sys_exit
syscall
