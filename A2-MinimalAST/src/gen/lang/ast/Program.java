/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A2-MinimalAST/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= FunctionDecl*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link FunctionDecl}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @param err where to write error messages
   * @aspect NameAnalysis
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A2-MinimalAST/src/jastadd/NameAnalysis.jrag:60
   */
  public void checkNames(PrintStream err) {
		SymbolTable vars = new SymbolTable();
		SymbolTable funcs = new SymbolTable();
		
		funcs.declare("print");
		funcs.declare("read");
		
		super.checkNames(err,vars,funcs);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A2-MinimalAST/src/jastadd/PrettyPrint.jrag:14
   */
  public void prettyPrint(PrintStream out, String ind) {
	    for (ASTNode child : astChildren()) {
		    child.prettyPrint(out, ind);
	    }
	}
  /**
   * @aspect Visitor
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A2-MinimalAST/src/jastadd/Visitor.jrag:26
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
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

  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:37
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
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
   * @declaredat ASTNode:61
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
   * @declaredat ASTNode:71
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
   * @declaredat ASTNode:91
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

}
