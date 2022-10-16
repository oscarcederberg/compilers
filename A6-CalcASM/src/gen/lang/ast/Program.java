/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/calc.ast:1
 * @astdecl Program : ASTNode ::= Expr;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Expr}</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/CodeGen.jrag:7
   */
  public void genCode(PrintStream out) {
    out.println(".global _start");
    out.println(".data");
    out.println("ask_message: .ascii \"Please enter a number: \"");
    out.println("ask_msg_len: .quad 23");
    out.println("buf: .skip 1024");
    out.println();
    out.println(".text");
    out.println("_start:");

    // Allocate space for local variables (bindings):
    out.println("        pushq %rbp");
    out.println("        movq %rsp, %rbp");
    out.println("        subq $" + (getExpr().numLocals()*8) + ", %rsp");

    getExpr().genEval(out);// stores result in RAX


    // Print result:
    out.println("        pushq %rax");
    out.println("        call print");
    out.println("        addq $8, %rsp");

    // De-allocate local variables:
    out.println("        movq %rbp, %rsp");
    out.println("        popq %rbp");

    // Call sys_exit:
    out.println("        movq $0, %rdi");
    out.println("        movq $60, %rax");
    out.println("        syscall"); // Done!

    // Helper procedures for input/output:
    out.println("# Procedure to print number to stdout.");
    out.println("# C signature: void print(long int)");
    out.println("print:");
    out.println("        pushq %rbp");
    out.println("        movq %rsp, %rbp");
    out.println("        ### Convert integer to string (itoa).");
    out.println("        movq 16(%rbp), %rax");
    out.println("        leaq buf(%rip), %rsi    # RSI = write pointer (starts at end of buffer)");
    out.println("        addq $1023, %rsi");
    out.println("        movb $0x0A, (%rsi)      # insert newline");
    out.println("        movq $1, %rcx           # RCX = string length");
    out.println("        cmpq $0, %rax");
    out.println("        jge itoa_loop");
    out.println("        negq %rax               # negate to make RAX positive");
    out.println("itoa_loop:                      # do.. while (at least one iteration)");
    out.println("        movq $10, %rdi");
    out.println("        movq $0, %rdx");
    out.println("        idivq %rdi              # divide RDX:RAX by 10");
    out.println("        addb $0x30, %dl         # remainder + '0'");
    out.println("        decq %rsi               # move string pointer");
    out.println("        movb %dl, (%rsi)");
    out.println("        incq %rcx               # increment string length");
    out.println("        cmpq $0, %rax");
    out.println("        jg itoa_loop            # produce more digits");
    out.println("itoa_done:");
    out.println("        movq 16(%rbp), %rax");
    out.println("        cmpq $0, %rax");
    out.println("        jge print_end");
    out.println("        decq %rsi");
    out.println("        incq %rcx");
    out.println("        movb $0x2D, (%rsi)");
    out.println("print_end:");
    out.println("        movq $1, %rdi");
    out.println("        movq %rcx, %rdx");
    out.println("        movq $1, %rax");
    out.println("        syscall");
    out.println("        popq %rbp");
    out.println("        ret");
    out.println("");
    out.println("# Procedure to read number from stdin.");
    out.println("# C signature: long long int read(void)");
    out.println("read:");
    out.println("        pushq %rbp");
    out.println("        movq %rsp, %rbp");
    out.println("        ### R9  = sign");
    out.println("        movq $1, %r9            # sign <- 1");
    out.println("        ### R10 = sum");
    out.println("        movq $0, %r10           # sum <- 0");
    out.println("skip_ws: # skip any leading whitespace");
    out.println("        movq $0, %rdi");
    out.println("        leaq buf(%rip), %rsi");
    out.println("        movq $1, %rdx");
    out.println("        movq $0, %rax");
    out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
    out.println("        cmpq $0, %rax");
    out.println("        jle atoi_done           # nchar <= 0");
    out.println("        movb (%rsi), %cl        # c <- current char");
    out.println("        cmp $32, %cl");
    out.println("        je skip_ws              # c == space");
    out.println("        cmp $13, %cl");
    out.println("        je skip_ws              # c == CR");
    out.println("        cmp $10, %cl");
    out.println("        je skip_ws              # c == NL");
    out.println("        cmp $9, %cl");
    out.println("        je skip_ws              # c == tab");
    out.println("        cmp $45, %cl            # check if negative");
    out.println("        jne atoi_loop");
    out.println("        movq $-1, %r9           # sign <- -1");
    out.println("        movq $0, %rdi");
    out.println("        leaq buf(%rip), %rsi");
    out.println("        movq $1, %rdx");
    out.println("        movq $0, %rax");
    out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
    out.println("atoi_loop:");
    out.println("        cmpq $0, %rax           # while (nchar > 0)");
    out.println("        jle atoi_done           # leave loop if nchar <= 0");
    out.println("        movzbq (%rsi), %rcx     # move byte, zero extend to quad-word");
    out.println("        cmpq $0x30, %rcx        # test if < '0'");
    out.println("        jl atoi_done            # character is not numeric");
    out.println("        cmpq $0x39, %rcx        # test if > '9'");
    out.println("        jg atoi_done            # character is not numeric");
    out.println("        imulq $10, %r10         # multiply sum by 10");
    out.println("        subq $0x30, %rcx        # value of character");
    out.println("        addq %rcx, %r10         # add to sum");
    out.println("        movq $0, %rdi");
    out.println("        leaq buf(%rip), %rsi");
    out.println("        movq $1, %rdx");
    out.println("        movq $0, %rax");
    out.println("        syscall                 # get one char: sys_read(0, buf, 1)");
    out.println("        jmp atoi_loop           # loop back");
    out.println("atoi_done:");
    out.println("        imulq %r9, %r10         # sum *= sign");
    out.println("        movq %r10, %rax         # put result value in RAX");
    out.println("        popq %rbp");
    out.println("        ret");
    out.println();
    out.println("print_string:");
    out.println("        pushq %rbp");
    out.println("        movq %rsp, %rbp");
    out.println("        movq $1, %rdi");
    out.println("        movq 16(%rbp), %rsi");
    out.println("        movq 24(%rbp), %rdx");
    out.println("        movq $1, %rax");
    out.println("        syscall");
    out.println("        popq %rbp");
    out.println("        ret");
  }
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Expr"},
    type = {"Expr"},
    kind = {"Child"}
  )
  public Program(Expr p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:26
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    localIndex_reset();
    unknownDecl_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:46
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
      node.parent = null;
      if (children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:65
   */
  @Deprecated
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:75
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if (child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:95
   */
  public Program treeCopy() {
    Program tree = (Program) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) getChild(i);
        if (child != null) {
          child = child.treeCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public Program setExpr(Expr node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Expr")
  public Expr getExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(0);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/Errors.jrag:26
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  /** @apilevel internal */
  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

/** @apilevel internal */
protected boolean localIndex_visited = false;
  /** @apilevel internal */
  private void localIndex_reset() {
    localIndex_computed = false;
    localIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean localIndex_computed = false;

  /** @apilevel internal */
  protected int localIndex_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/CodeGen.jrag:224
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/CodeGen.jrag:223")
  public int localIndex() {
    ASTState state = state();
    if (localIndex_computed) {
      return localIndex_value;
    }
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    state().enterLazyAttribute();
    localIndex_value = 0;
    localIndex_computed = true;
    state().leaveLazyAttribute();
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTState state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = new UnknownDecl("<unknown>");
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/NameAnalysis.jrag:26
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/NameAnalysis.jrag:26
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String name) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/NameAnalysis.jrag:34
   * @apilevel internal
   */
  public boolean Define_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return false;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/NameAnalysis.jrag:34
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute inExprOf
   */
  protected boolean canDefine_inExprOf(ASTNode _callerNode, ASTNode _childNode, IdDecl decl) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/UnknownDecl.jrag:4
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/Errors.jrag:28
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTState state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node.getParent() != null) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : (java.util.Set<ASTNode>) root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;


}
