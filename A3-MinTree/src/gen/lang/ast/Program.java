/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
/**
 * @ast node
 * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/Lang.ast:1
 * @astdecl Program : ASTNode ::= Node;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Node}</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/PrettyPrint.jadd:17
   */
  public void prettyPrint(PrintStream out, String ind) {
		getNode().prettyPrint(out, ind);
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
    name = {"Node"},
    type = {"Node"},
    kind = {"Child"}
  )
  public Program(Node p0) {
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
    nbrOfMinValues_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:31
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:36
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:41
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
   * @declaredat ASTNode:60
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
   * @declaredat ASTNode:70
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
   * @declaredat ASTNode:90
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
   * Replaces the Node child.
   * @param node The new node to replace the Node child.
   * @apilevel high-level
   */
  public Program setNode(Node node) {
    setChild(node, 0);
    return this;
  }
  /**
   * Retrieves the Node child.
   * @return The current node used as the Node child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Node")
  public Node getNode() {
    return (Node) getChild(0);
  }
  /**
   * Retrieves the Node child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Node child.
   * @apilevel low-level
   */
  public Node getNodeNoTransform() {
    return (Node) getChildNoTransform(0);
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
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:20
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="MinValue", declaredAt="/home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:20")
  public int nbrOfMinValues() {
    ASTState state = state();
    if (nbrOfMinValues_computed) {
      return nbrOfMinValues_value;
    }
    if (nbrOfMinValues_visited) {
      throw new RuntimeException("Circular definition of attribute Program.nbrOfMinValues().");
    }
    nbrOfMinValues_visited = true;
    state().enterLazyAttribute();
    nbrOfMinValues_value = getNode().nbrOfMinValues();
    nbrOfMinValues_computed = true;
    state().leaveLazyAttribute();
    nbrOfMinValues_visited = false;
    return nbrOfMinValues_value;
  }
  /**
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:13
   * @apilevel internal
   */
  public int Define_globalMin(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == getNodeNoTransform()) {
      // @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:14
      return getNode().localMin();
    }
    else {
      return getParent().Define_globalMin(this, _callerNode);
    }
  }
  /**
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A3-MinTree/src/jastadd/MinValue.jrag:13
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute globalMin
   */
  protected boolean canDefine_globalMin(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }

}
