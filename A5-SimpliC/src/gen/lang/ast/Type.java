/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.HashMap;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/lang.ast:40
 * @astdecl Type : ASTNode;
 * @production Type : {@link ASTNode};

 */
public abstract class Type extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Type() {
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
    isUnknown_reset();
    compatibleWith_Type_reset();
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
  public Type clone() throws CloneNotSupportedException {
    Type node = (Type) super.clone();
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
  public abstract Type fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:47
   */
  public abstract Type treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:55
   */
  public abstract Type treeCopy();
/** @apilevel internal */
protected boolean isUnknown_visited = false;
  /** @apilevel internal */
  private void isUnknown_reset() {
    isUnknown_computed = false;
    isUnknown_visited = false;
  }
  /** @apilevel internal */
  protected boolean isUnknown_computed = false;

  /** @apilevel internal */
  protected boolean isUnknown_value;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:12
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:12")
  public boolean isUnknown() {
    ASTState state = state();
    if (isUnknown_computed) {
      return isUnknown_value;
    }
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute Type.isUnknown().");
    }
    isUnknown_visited = true;
    state().enterLazyAttribute();
    isUnknown_value = false;
    isUnknown_computed = true;
    state().leaveLazyAttribute();
    isUnknown_visited = false;
    return isUnknown_value;
  }
/** @apilevel internal */
protected java.util.Set compatibleWith_Type_visited;
  /** @apilevel internal */
  private void compatibleWith_Type_reset() {
    compatibleWith_Type_values = null;
    compatibleWith_Type_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map compatibleWith_Type_values;

  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:15
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/TypeAnalysis.jrag:15")
  public boolean compatibleWith(Type t) {
    Object _parameters = t;
    if (compatibleWith_Type_visited == null) compatibleWith_Type_visited = new java.util.HashSet(4);
    if (compatibleWith_Type_values == null) compatibleWith_Type_values = new java.util.HashMap(4);
    ASTState state = state();
    if (compatibleWith_Type_values.containsKey(_parameters)) {
      return (Boolean) compatibleWith_Type_values.get(_parameters);
    }
    if (compatibleWith_Type_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute Type.compatibleWith(Type).");
    }
    compatibleWith_Type_visited.add(_parameters);
    state().enterLazyAttribute();
    boolean compatibleWith_Type_value = this.isUnknown() || t.isUnknown() || this.equals(t);
    compatibleWith_Type_values.put(_parameters, compatibleWith_Type_value);
    state().leaveLazyAttribute();
    compatibleWith_Type_visited.remove(_parameters);
    return compatibleWith_Type_value;
  }

}
