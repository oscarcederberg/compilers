/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A2-MinimalAST/src/jastadd/lang.ast:4
 * @astdecl FunctionDecl : ASTNode ::= <ID:String> IdDecl* Block;
 * @production FunctionDecl : {@link ASTNode} ::= <span class="component">&lt;ID:{@link String}&gt;</span> <span class="component">{@link IdDecl}*</span> <span class="component">{@link Block}</span>;

 */
public class FunctionDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A2-MinimalAST/src/jastadd/Visitor.jrag:30
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @declaredat ASTNode:1
   */
  public FunctionDecl() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  @ASTNodeAnnotation.Constructor(
    name = {"ID", "IdDecl", "Block"},
    type = {"String", "List<IdDecl>", "Block"},
    kind = {"Token", "List", "Child"}
  )
  public FunctionDecl(String p0, List<IdDecl> p1, Block p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:24
   */
  public FunctionDecl(beaver.Symbol p0, List<IdDecl> p1, Block p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:30
   */
  protected int numChildren() {
    return 2;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:34
   */
  public void flushAttrCache() {
    super.flushAttrCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:39
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public FunctionDecl clone() throws CloneNotSupportedException {
    FunctionDecl node = (FunctionDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:49
   */
  public FunctionDecl copy() {
    try {
      FunctionDecl node = (FunctionDecl) clone();
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
   * @declaredat ASTNode:68
   */
  @Deprecated
  public FunctionDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:78
   */
  public FunctionDecl treeCopyNoTransform() {
    FunctionDecl tree = (FunctionDecl) copy();
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
   * @declaredat ASTNode:98
   */
  public FunctionDecl treeCopy() {
    FunctionDecl tree = (FunctionDecl) copy();
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
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public FunctionDecl setID(String value) {
    tokenString_ID = value;
    return this;
  }
  /** @apilevel internal 
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public FunctionDecl setID(beaver.Symbol symbol) {
    if (symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
    return this;
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ID")
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
  /**
   * Replaces the IdDecl list.
   * @param list The new list node to be used as the IdDecl list.
   * @apilevel high-level
   */
  public FunctionDecl setIdDeclList(List<IdDecl> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the IdDecl list.
   * @return Number of children in the IdDecl list.
   * @apilevel high-level
   */
  public int getNumIdDecl() {
    return getIdDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the IdDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the IdDecl list.
   * @apilevel low-level
   */
  public int getNumIdDeclNoTransform() {
    return getIdDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the IdDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the IdDecl list.
   * @apilevel high-level
   */
  public IdDecl getIdDecl(int i) {
    return (IdDecl) getIdDeclList().getChild(i);
  }
  /**
   * Check whether the IdDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasIdDecl() {
    return getIdDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the IdDecl list.
   * @param node The element to append to the IdDecl list.
   * @apilevel high-level
   */
  public FunctionDecl addIdDecl(IdDecl node) {
    List<IdDecl> list = (parent == null) ? getIdDeclListNoTransform() : getIdDeclList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public FunctionDecl addIdDeclNoTransform(IdDecl node) {
    List<IdDecl> list = getIdDeclListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the IdDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public FunctionDecl setIdDecl(IdDecl node, int i) {
    List<IdDecl> list = getIdDeclList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the IdDecl list.
   * @return The node representing the IdDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="IdDecl")
  public List<IdDecl> getIdDeclList() {
    List<IdDecl> list = (List<IdDecl>) getChild(0);
    return list;
  }
  /**
   * Retrieves the IdDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdDecl list.
   * @apilevel low-level
   */
  public List<IdDecl> getIdDeclListNoTransform() {
    return (List<IdDecl>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the IdDecl list without
   * triggering rewrites.
   */
  public IdDecl getIdDeclNoTransform(int i) {
    return (IdDecl) getIdDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the IdDecl list.
   * @return The node representing the IdDecl list.
   * @apilevel high-level
   */
  public List<IdDecl> getIdDecls() {
    return getIdDeclList();
  }
  /**
   * Retrieves the IdDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the IdDecl list.
   * @apilevel low-level
   */
  public List<IdDecl> getIdDeclsNoTransform() {
    return getIdDeclListNoTransform();
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public FunctionDecl setBlock(Block node) {
    setChild(node, 1);
    return this;
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Block")
  public Block getBlock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(1);
  }

}
