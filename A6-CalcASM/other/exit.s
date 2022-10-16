.global _start
.text
_start:
    movq $0, %rdi # exit code
    movq $60, %rax # sys_exit
    syscall
 