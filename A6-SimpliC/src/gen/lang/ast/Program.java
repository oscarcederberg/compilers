/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= FunctionDecl*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link FunctionDecl}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:2
   */
  public void genCode(PrintStream out) {
        out.println(".global _start");
        out.println(".data");
        out.println("buf: .skip 1024");
        out.println(".text");
        out.println("_start:");
        // call main function
        out.println("call main");
        out.println("call _exit\n");
        for (FunctionDecl decl: getFunctionDeclList()) {
            decl.genCode(out);
        }
        // call sys_exit
        out.println("_exit:");
        out.println("movq %rax, %rdi   # exit code = 0");
        out.println("movq $60, %rax  # sys_exit");
        out.println("syscall");
        // print
        out.println("print:");
        out.println("pushq %rbp");
        out.println("movq %rsp, %rbp");
        out.println("### Convert integer to string (itoa).");
        out.println("movq 16(%rbp), %rax");
        out.println("leaq buf(%rip), %rsi # RSI = write pointer (starts at end of buffer)");
        out.println("addq $1023, %rsi");
        out.println("movb $0x0A, (%rsi) # insert newline");
        out.println("movq $1, %rcx # RCX = string length");
        out.println("cmpq $0, %rax");
        out.println("jge itoa_loop");
        out.println("negq %rax # negate to make RAX positive");
        out.println("itoa_loop: # do.. while (at least one iteration)");
        out.println("movq $10, %rdi");
        out.println("movq $0, %rdx");
        out.println("idivq %rdi # divide RDX:RAX by 10");
        out.println("addb $0x30, %dl");
        out.println("decq %rsi # move string pointer");
        out.println("movb %dl, (%rsi)");
        out.println("incq %rcx # increment string length");
        out.println("cmpq $0, %rax");
        out.println("jg itoa_loop # produce more digits");
        out.println("itoa_done:");
        out.println("movq 16(%rbp), %rax");
        out.println("cmpq $0, %rax");
        out.println("jge print_end");
        out.println("decq %rsi");
        out.println("incq %rcx");
        out.println("movb $0x2D, (%rsi)");
        out.println("print_end:");
        out.println("movq $1, %rdi");
        out.println("movq %rcx, %rdx");
        out.println("movq $1, %rax");
        out.println("syscall");
        out.println("popq %rbp");
        out.println("ret");
    }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:37
   */
  public void eval() {
        IdDecl main = unknownDecl();
		for(FunctionDecl func : getFunctionDecls()) {
			if(func.getIdDecl().getID().equals("main")){
				main = func.getIdDecl();
			}
		}

        if(main.isUnknown()) {
            throw new RuntimeException("main missing");
        }

        main.function().eval(new ActivationRecord());
    }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:197
   */
  static Scanner scanner = new Scanner(System.in);
  /**
   * @aspect Visitor
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Visitor.jrag:27
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/PrettyPrint.jrag:14
   */
  public void prettyPrint(PrintStream out, String ind) {
	    for (ASTNode child : astChildren()) {
		    child.prettyPrint(out, ind);
	    }
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"FunctionDecl"},
    type = {"List<FunctionDecl>"},
    kind = {"List"}
  )
  public Program(List<FunctionDecl> p0) {
    setChild(p0, 0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 1;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    predefinedFunctions_reset();
    unknownType_reset();
    intType_reset();
    boolType_reset();
    unknownDecl_reset();
    unknownFunction_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
    contributorMap_FunctionDecl_functionCalls = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:52
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
   * @declaredat ASTNode:71
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
   * @declaredat ASTNode:81
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
   * @declaredat ASTNode:101
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
   * Replaces the FunctionDecl list.
   * @param list The new list node to be used as the FunctionDecl list.
   * @apilevel high-level
   */
  public Program setFunctionDeclList(List<FunctionDecl> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the FunctionDecl list.
   * @return Number of children in the FunctionDecl list.
   * @apilevel high-level
   */
  public int getNumFunctionDecl() {
    return getFunctionDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the FunctionDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the FunctionDecl list.
   * @apilevel low-level
   */
  public int getNumFunctionDeclNoTransform() {
    return getFunctionDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the FunctionDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the FunctionDecl list.
   * @apilevel high-level
   */
  public FunctionDecl getFunctionDecl(int i) {
    return (FunctionDecl) getFunctionDeclList().getChild(i);
  }
  /**
   * Check whether the FunctionDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasFunctionDecl() {
    return getFunctionDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the FunctionDecl list.
   * @param node The element to append to the FunctionDecl list.
   * @apilevel high-level
   */
  public Program addFunctionDecl(FunctionDecl node) {
    List<FunctionDecl> list = (parent == null) ? getFunctionDeclListNoTransform() : getFunctionDeclList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Program addFunctionDeclNoTransform(FunctionDecl node) {
    List<FunctionDecl> list = getFunctionDeclListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the FunctionDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Program setFunctionDecl(FunctionDecl node, int i) {
    List<FunctionDecl> list = getFunctionDeclList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the FunctionDecl list.
   * @return The node representing the FunctionDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="FunctionDecl")
  public List<FunctionDecl> getFunctionDeclList() {
    List<FunctionDecl> list = (List<FunctionDecl>) getChild(0);
    return list;
  }
  /**
   * Retrieves the FunctionDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FunctionDecl list.
   * @apilevel low-level
   */
  public List<FunctionDecl> getFunctionDeclListNoTransform() {
    return (List<FunctionDecl>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the FunctionDecl list without
   * triggering rewrites.
   */
  public FunctionDecl getFunctionDeclNoTransform(int i) {
    return (FunctionDecl) getFunctionDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the FunctionDecl list.
   * @return The node representing the FunctionDecl list.
   * @apilevel high-level
   */
  public List<FunctionDecl> getFunctionDecls() {
    return getFunctionDeclList();
  }
  /**
   * Retrieves the FunctionDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the FunctionDecl list.
   * @apilevel low-level
   */
  public List<FunctionDecl> getFunctionDeclsNoTransform() {
    return getFunctionDeclListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Errors.jrag:26
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

  /**
   * @aspect <NoAspect>
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:202
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FunctionDecl_functionCalls = null;

  /** @apilevel internal */
  protected void survey_FunctionDecl_functionCalls() {
    if (contributorMap_FunctionDecl_functionCalls == null) {
      contributorMap_FunctionDecl_functionCalls = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_FunctionDecl_functionCalls(this, contributorMap_FunctionDecl_functionCalls);
    }
  }

/** @apilevel internal */
protected boolean predefinedFunctions_visited = false;
  /** @apilevel internal */
  private void predefinedFunctions_reset() {
    predefinedFunctions_computed = false;
    
    predefinedFunctions_value = null;
    predefinedFunctions_visited = false;
  }
  /** @apilevel internal */
  protected boolean predefinedFunctions_computed = false;

  /** @apilevel internal */
  protected List<FunctionDecl> predefinedFunctions_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:66
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:66")
  public List<FunctionDecl> predefinedFunctions() {
    ASTState state = state();
    if (predefinedFunctions_computed) {
      return predefinedFunctions_value;
    }
    if (predefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute Program.predefinedFunctions().");
    }
    predefinedFunctions_visited = true;
    state().enterLazyAttribute();
    predefinedFunctions_value = predefinedFunctions_compute();
    predefinedFunctions_value.setParent(this);
    predefinedFunctions_computed = true;
    state().leaveLazyAttribute();
    predefinedFunctions_visited = false;
    return predefinedFunctions_value;
  }
  /** @apilevel internal */
  private List<FunctionDecl> predefinedFunctions_compute() {
  		List<FunctionDecl> list = new List<FunctionDecl>();
  		list.add(new FunctionDecl(new IdDecl("print"), new List(new VariableDecl(new IdDecl("input"), new Opt())), new Block(new List())));
  		list.add(new FunctionDecl(new IdDecl("read"), new List(), new Block(new List())));
  		return list;
  	}
/** @apilevel internal */
protected boolean unknownType_visited = false;
  /** @apilevel internal */
  private void unknownType_reset() {
    unknownType_computed = false;
    
    unknownType_value = null;
    unknownType_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownType_computed = false;

  /** @apilevel internal */
  protected UnknownType unknownType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:2")
  public UnknownType unknownType() {
    ASTState state = state();
    if (unknownType_computed) {
      return unknownType_value;
    }
    if (unknownType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownType().");
    }
    unknownType_visited = true;
    state().enterLazyAttribute();
    unknownType_value = new UnknownType();
    unknownType_value.setParent(this);
    unknownType_computed = true;
    state().leaveLazyAttribute();
    unknownType_visited = false;
    return unknownType_value;
  }
/** @apilevel internal */
protected boolean intType_visited = false;
  /** @apilevel internal */
  private void intType_reset() {
    intType_computed = false;
    
    intType_value = null;
    intType_visited = false;
  }
  /** @apilevel internal */
  protected boolean intType_computed = false;

  /** @apilevel internal */
  protected IntType intType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:5")
  public IntType intType() {
    ASTState state = state();
    if (intType_computed) {
      return intType_value;
    }
    if (intType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.intType().");
    }
    intType_visited = true;
    state().enterLazyAttribute();
    intType_value = new IntType();
    intType_value.setParent(this);
    intType_computed = true;
    state().leaveLazyAttribute();
    intType_visited = false;
    return intType_value;
  }
/** @apilevel internal */
protected boolean boolType_visited = false;
  /** @apilevel internal */
  private void boolType_reset() {
    boolType_computed = false;
    
    boolType_value = null;
    boolType_visited = false;
  }
  /** @apilevel internal */
  protected boolean boolType_computed = false;

  /** @apilevel internal */
  protected BoolType boolType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:8
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:8")
  public BoolType boolType() {
    ASTState state = state();
    if (boolType_computed) {
      return boolType_value;
    }
    if (boolType_visited) {
      throw new RuntimeException("Circular definition of attribute Program.boolType().");
    }
    boolType_visited = true;
    state().enterLazyAttribute();
    boolType_value = new BoolType();
    boolType_value.setParent(this);
    boolType_computed = true;
    state().leaveLazyAttribute();
    boolType_visited = false;
    return boolType_value;
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
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:2")
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
/** @apilevel internal */
protected boolean unknownFunction_visited = false;
  /** @apilevel internal */
  private void unknownFunction_reset() {
    unknownFunction_computed = false;
    
    unknownFunction_value = null;
    unknownFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownFunction_computed = false;

  /** @apilevel internal */
  protected UnknownFunction unknownFunction_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:6
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:6")
  public UnknownFunction unknownFunction() {
    ASTState state = state();
    if (unknownFunction_computed) {
      return unknownFunction_value;
    }
    if (unknownFunction_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownFunction().");
    }
    unknownFunction_visited = true;
    state().enterLazyAttribute();
    unknownFunction_value = new UnknownFunction(unknownDecl(), new List(), new Block(new List()));
    unknownFunction_value.setParent(this);
    unknownFunction_computed = true;
    state().leaveLazyAttribute();
    unknownFunction_visited = false;
    return unknownFunction_value;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:17
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String s) {
    if (_callerNode == getFunctionDeclListNoTransform()) {
      // @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:31
      int index = _callerNode.getIndexOfChild(_childNode);
      {
      		//Has to be first for isMultideclared to work
      		for(FunctionDecl func : predefinedFunctions()){
      			if(func.getIdDecl().getID().equals(s)){
      				return func.getIdDecl();
      			}
      		}
      		for(VariableDecl decl : getFunctionDecl(index).getVariableDecls()){
      			if(decl.getIdDecl().getID().equals(s)){
      				return decl.getIdDecl();
      			}
      		}
      		for(FunctionDecl func : getFunctionDecls()) {
      			if(func.getIdDecl().getID().equals(s)){
      				return func.getIdDecl();
      			}
      		}
      		return unknownDecl();
      	}
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      return unknownDecl();
    }
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:17
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String s) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:208
   * @apilevel internal
   */
  public String Define_address(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return "";
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:208
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute address
   */
  protected boolean canDefine_address(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:3
   * @apilevel internal
   */
  public UnknownType Define_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownType();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:3
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownType
   */
  protected boolean canDefine_unknownType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:6
   * @apilevel internal
   */
  public IntType Define_intType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:6
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute intType
   */
  protected boolean canDefine_intType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:9
   * @apilevel internal
   */
  public BoolType Define_boolType(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return boolType();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:9
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute boolType
   */
  protected boolean canDefine_boolType(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:18
   * @apilevel internal
   */
  public Type Define_type(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:38
      return unknownType();
    }
    else {
      return getParent().Define_type(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:18
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute type
   */
  protected boolean canDefine_type(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:3
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:3
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:7
   * @apilevel internal
   */
  public UnknownFunction Define_unknownFunction(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownFunction();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:7
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownFunction
   */
  protected boolean canDefine_unknownFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:16
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:22
      return false;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:16
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:17
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:25
      return false;
    }
    else {
      return getParent().Define_isVariable(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:17
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:18
   * @apilevel internal
   */
  public FunctionDecl Define_function(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:28
      return unknownFunction();
    }
    else {
      return getParent().Define_function(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:18
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute function
   */
  protected boolean canDefine_function(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:206
   * @apilevel internal
   */
  public String Define_index(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    {
            return "";
        }
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:206
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute index
   */
  protected boolean canDefine_index(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Errors.jrag:28
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
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Errors.jrag:26")
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
    while (node != null && !(node instanceof Program)) {
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
