.global _start
.data
buf: .skip 1024
.text
_start:
call main
call _exit

main:
pushq %rbp
movq %rsp, %rbp
