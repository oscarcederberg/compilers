# Stack Management
```asm
pushq param2
pushq param1
call myproc
```

`CALL` will push the return address to onto the stack.

```asm
myproc:
  pushq %rbp
  movq %rsp, %rbp
```

Pushes the base pointer onto the stack, then replaces it with the stack pointer.

We can push local variables onto the stack and use `RBP` to address those. The first local variable would be `-8(%rbp)`, and so on. To get `param1` and `param2` we can use `16(%rbp)` and `24(%rbp)` respectively.

```asm
  movq %rbp, %rsp
  popq %rbp
  ret
  # ...
  # At caller:
  addq $16, %rsp # 2 parameters, 8 bytes each
```

When we're done we restore the caller's `RBP`, and then return with `RET` which will pop the return adress off the top of the stack and jumpts to that address. After returning to the caller, it must remove the parameters of the stack. Now `RBP` and `RSP` are in their original state. Any return value should be stored in the `RAX` register, and not on the stack.

**How would you compute the location of the return address in the stack?**\
`8(%rbp)`

# Calling Procedures
```asm
# Procedure to print a message
print_string:
  pushq %rbp
  movq %rsp, %rbp
  # Push base pointer, replace it with stack pointer
  movq $1, %rdi       # stdout
  movq 16(%rbp), %rsi # param1
  movq 24(%rbp), %rdx # param2
  movq $1, %rax       # sys_write 
  syscall
  popq %rbp           # pop base pointer
  ret                 # pop and return
```

# Loops and Conditionals
```asm
### while ( %rax < %rdx )
loop_start:
  cmpq %rdx, %rax
  jge loop_end # leave loop if %rax >= %rdx
  # loop body
  jmp loop_start # jump to start, test condition again
loop_end:
  # done

### if ( %rax >= 10 )
cmpq $10, %rax
jl else_lbl           # go to else_lbl if %rax < 10
then_lbl:
  # then body
  jmp fi
else_lbl:
  # else body
fi:
# done
``

**How would `break`-, and `continue`-statemenets look in generated assembly?**\
it would be `JMP`-statements that either point to a label outside the loop or at the top of the loop.
