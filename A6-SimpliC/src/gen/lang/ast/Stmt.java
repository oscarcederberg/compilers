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
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/lang.ast:9
 * @astdecl Stmt : ASTNode;
 * @production Stmt : {@link ASTNode};

 */
public abstract class Stmt extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:77
   */
  public void genCode(PrintStream out) {
        throw new RuntimeException();
    }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:77
   */
  public void eval(ActivationRecord actrec) {
        throw new RuntimeException();
    }
  /**
   * @aspect Visitor
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Visitor.jrag:40
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Stmt() {
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
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:13
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:17
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    enclosedFunction_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:22
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public Stmt clone() throws CloneNotSupportedException {
    Stmt node = (Stmt) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:38
   */
  @Deprecated
  public abstract Stmt fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:46
   */
  public abstract Stmt treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:54
   */
  public abstract Stmt treeCopy();
  /**
   * @attribute inh
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:203
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Interpreter", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:203")
  public FunctionDecl enclosedFunction() {
    ASTState state = state();
    if (enclosedFunction_computed) {
      return enclosedFunction_value;
    }
    if (enclosedFunction_visited) {
      throw new RuntimeException("Circular definition of attribute Stmt.enclosedFunction().");
    }
    enclosedFunction_visited = true;
    state().enterLazyAttribute();
    enclosedFunction_value = getParent().Define_enclosedFunction(this, null);
    enclosedFunction_computed = true;
    state().leaveLazyAttribute();
    enclosedFunction_visited = false;
    return enclosedFunction_value;
  }
/** @apilevel internal */
protected boolean enclosedFunction_visited = false;
  /** @apilevel internal */
  private void enclosedFunction_reset() {
    enclosedFunction_computed = false;
    
    enclosedFunction_value = null;
    enclosedFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean enclosedFunction_computed = false;

  /** @apilevel internal */
  protected FunctionDecl enclosedFunction_value;


}
