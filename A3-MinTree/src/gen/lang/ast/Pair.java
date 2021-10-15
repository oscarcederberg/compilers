/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/Lang.ast:4
 * @astdecl Pair : Node ::= Left:Node Right:Node;
 * @production Pair : {@link Node} ::= <span class="component">Left:{@link Node}</span> <span class="component">Right:{@link Node}</span>;

 */
public class Pair extends Node implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/PrettyPrint.jadd:21
   */
  public void prettyPrint(PrintStream out, String ind) {
		out.print(ind);
		out.println("Pair");
		getLeft().prettyPrint(out, ind + INDENTATION);
		getRight().prettyPrint(out, ind + INDENTATION);
	}
  /**
   * @declaredat ASTNode:1
   */
  public Pair() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  @ASTNodeAnnotation.Constructor(
    name = {"Left", "Right"},
    type = {"Node", "Node"},
    kind = {"Child", "Child"}
  )
  public Pair(Node p0, Node p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:27
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    localMin_reset();
    nbrOfMinValues_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:38
   */
  public Pair clone() throws CloneNotSupportedException {
    Pair node = (Pair) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:43
   */
  public Pair copy() {
    try {
      Pair node = (Pair) clone();
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
   * @declaredat ASTNode:62
   */
  @Deprecated
  public Pair fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:72
   */
  public Pair treeCopyNoTransform() {
    Pair tree = (Pair) copy();
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
   * @declaredat ASTNode:92
   */
  public Pair treeCopy() {
    Pair tree = (Pair) copy();
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
   * Replaces the Left child.
   * @param node The new node to replace the Left child.
   * @apilevel high-level
   */
  public Pair setLeft(Node node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Left child.
   * @return The current node used as the Left child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Left")
  public Node getLeft() {
    return (Node) getChild(0);
  }
  /**
   * Retrieves the Left child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Left child.
   * @apilevel low-level
   */
  public Node getLeftNoTransform() {
    return (Node) getChildNoTransform(0);
  }
  /**
   * Replaces the Right child.
   * @param node The new node to replace the Right child.
   * @apilevel high-level
   */
  public Pair setRight(Node node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Right child.
   * @return The current node used as the Right child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Right")
  public Node getRight() {
    return (Node) getChild(1);
  }
  /**
   * Retrieves the Right child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Right child.
   * @apilevel low-level
   */
  public Node getRightNoTransform() {
    return (Node) getChildNoTransform(1);
  }
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
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:5
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
    localMin_value = localMin_compute();
    localMin_computed = true;
    state().leaveLazyAttribute();
    localMin_visited = false;
    return localMin_value;
  }
  /** @apilevel internal */
  private int localMin_compute() {
  		int left = getLeft().localMin();
  		int right = getRight().localMin();
  		return left < right ? left : right;
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
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:22
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
    nbrOfMinValues_value = getLeft().nbrOfMinValues() + getRight().nbrOfMinValues();
    nbrOfMinValues_computed = true;
    state().leaveLazyAttribute();
    nbrOfMinValues_visited = false;
    return nbrOfMinValues_value;
  }

}
