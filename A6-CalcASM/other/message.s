.global _start
.data
    message: .ascii "Hello EDAN65!\n"
.text
_start:
    pushq $14       # message length
    pushq $message  # message to print

    call print_string
    addq $16, %rsp  # 2 parameters, 8 bytes each

    movq $0, %rdi   # exit code = 0
    movq $60, %rax  # sys_exit
    syscall

print_string:
    pushq %rbp
    movq %rsp, %rbp
    movq $1, %rdi
    movq 16(%rbp), %rsi
    movq 24(%rbp), %rdx
    movq $1, %rax
    syscall
    
    popq %rbp
    ret
