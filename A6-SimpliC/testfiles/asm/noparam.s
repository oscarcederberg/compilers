.global _start
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
