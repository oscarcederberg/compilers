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
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/lang.ast:10
 * @astdecl Expr : ASTNode;
 * @production Expr : {@link ASTNode};

 */
public abstract class Expr extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:194
   */
  public void genCode(PrintStream out) {
        throw new RuntimeException();
    }
  /**
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:248
   */
  public void genConditionalJump(PrintStream out, String label) {
        throw new RuntimeException();
    }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:124
   */
  public int eval(ActivationRecord actrec) {
        throw new RuntimeException();
    }
  /**
   * @aspect Visitor
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Visitor.jrag:43
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Expr() {
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
    expectedType_reset();
    type_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:23
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public Expr clone() throws CloneNotSupportedException {
    Expr node = (Expr) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:39
   */
  @Deprecated
  public abstract Expr fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:47
   */
  public abstract Expr treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:55
   */
  public abstract Expr treeCopy();
/** @apilevel internal */
protected boolean expectedType_visited = false;
  /** @apilevel internal */
  private void expectedType_reset() {
    expectedType_computed = false;
    
    expectedType_value = null;
    expectedType_visited = false;
  }
  /** @apilevel internal */
  protected boolean expectedType_computed = false;

  /** @apilevel internal */
  protected Type expectedType_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:27
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:27")
  public Type expectedType() {
    ASTState state = state();
    if (expectedType_computed) {
      return expectedType_value;
    }
    if (expectedType_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.expectedType().");
    }
    expectedType_visited = true;
    state().enterLazyAttribute();
    expectedType_value = intType();
    expectedType_computed = true;
    state().leaveLazyAttribute();
    expectedType_visited = false;
    return expectedType_value;
  }
  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:18
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:18")
  public Type type() {
    ASTState state = state();
    if (type_computed) {
      return type_value;
    }
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute Expr.type().");
    }
    type_visited = true;
    state().enterLazyAttribute();
    type_value = getParent().Define_type(this, null);
    type_computed = true;
    state().leaveLazyAttribute();
    type_visited = false;
    return type_value;
  }
/** @apilevel internal */
protected boolean type_visited = false;
  /** @apilevel internal */
  private void type_reset() {
    type_computed = false;
    
    type_value = null;
    type_visited = false;
  }
  /** @apilevel internal */
  protected boolean type_computed = false;

  /** @apilevel internal */
  protected Type type_value;

  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:18
   * @apilevel internal
   */
  public Type Define_type(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return intType();
  }
  /**
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:18
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute type
   */
  protected boolean canDefine_type(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Errors.jrag:82
    if (expectedType() != type()) {
      {
        Program target = (Program) (program());
        java.util.Set<ASTNode> contributors = _map.get(target);
        if (contributors == null) {
          contributors = new java.util.LinkedHashSet<ASTNode>();
          _map.put((ASTNode) target, contributors);
        }
        contributors.add(this);
      }
    }
    super.collect_contributors_Program_errors(_root, _map);
  }
  /** @apilevel internal */
  protected void contributeTo_Program_errors(Set<ErrorMessage> collection) {
    super.contributeTo_Program_errors(collection);
    if (expectedType() != type()) {
      collection.add(error("does not match expected type"));
    }
  }

}
