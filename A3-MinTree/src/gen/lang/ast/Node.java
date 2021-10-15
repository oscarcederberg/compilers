/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/Lang.ast:3
 * @astdecl Node : ASTNode;
 * @production Node : {@link ASTNode};

 */
public abstract class Node extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Node() {
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
    localMin_reset();
    nbrOfMinValues_reset();
    globalMin_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:24
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:29
   */
  public Node clone() throws CloneNotSupportedException {
    Node node = (Node) super.clone();
    return node;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:40
   */
  @Deprecated
  public abstract Node fullCopy();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:48
   */
  public abstract Node treeCopyNoTransform();
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:56
   */
  public abstract Node treeCopy();
/** @apilevel internal */
protected boolean localMin_visited = false;
  /** @apilevel internal */
  private void localMin_reset() {
    localMin_computed = false;
    localMin_visited = false;
  }
  /** @apilevel internal */
  protected boolean localMin_computed = false;

  /** @apilevel internal */
  protected int localMin_value;

  /**
   * @attribute syn
   * @aspect MinValue
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:3
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:3")
  public int localMin() {
    ASTState state = state();
    if (localMin_computed) {
      return localMin_value;
    }
    if (localMin_visited) {
      throw new RuntimeException("Circular definition of attribute Node.localMin().");
    }
    localMin_visited = true;
    state().enterLazyAttribute();
    localMin_value = 0;
    localMin_computed = true;
    state().leaveLazyAttribute();
    localMin_visited = false;
    return localMin_value;
  }
/** @apilevel internal */
protected boolean nbrOfMinValues_visited = false;
  /** @apilevel internal */
  private void nbrOfMinValues_reset() {
    nbrOfMinValues_computed = false;
    nbrOfMinValues_visited = false;
  }
  /** @apilevel internal */
  protected boolean nbrOfMinValues_computed = false;

  /** @apilevel internal */
  protected int nbrOfMinValues_value;

  /**
   * @attribute syn
   * @aspect MinValue
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:21
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:21")
  public int nbrOfMinValues() {
    ASTState state = state();
    if (nbrOfMinValues_computed) {
      return nbrOfMinValues_value;
    }
    if (nbrOfMinValues_visited) {
      throw new RuntimeException("Circular definition of attribute Node.nbrOfMinValues().");
    }
    nbrOfMinValues_visited = true;
    state().enterLazyAttribute();
    nbrOfMinValues_value = 0;
    nbrOfMinValues_computed = true;
    state().leaveLazyAttribute();
    nbrOfMinValues_visited = false;
    return nbrOfMinValues_value;
  }
  /**
   * @attribute inh
   * @aspect MinValue
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:13
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:13")
  public int globalMin() {
    ASTState state = state();
    if (globalMin_computed) {
      return globalMin_value;
    }
    if (globalMin_visited) {
      throw new RuntimeException("Circular definition of attribute Node.globalMin().");
    }
    globalMin_visited = true;
    state().enterLazyAttribute();
    globalMin_value = getParent().Define_globalMin(this, null);
    globalMin_computed = true;
    state().leaveLazyAttribute();
    globalMin_visited = false;
    return globalMin_value;
  }
/** @apilevel internal */
protected boolean globalMin_visited = false;
  /** @apilevel internal */
  private void globalMin_reset() {
    globalMin_computed = false;
    globalMin_visited = false;
  }
  /** @apilevel internal */
  protected boolean globalMin_computed = false;

  /** @apilevel internal */
  protected int globalMin_value;


}
