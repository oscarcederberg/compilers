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
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/lang.ast:3
 * @astdecl Params : ASTNode ::= VariableDecl*;
 * @production Params : {@link ASTNode} ::= <span class="component">{@link VariableDecl}*</span>;

 */
public class Params extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Params() {
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
    name = {"VariableDecl"},
    type = {"List<VariableDecl>"},
    kind = {"List"}
  )
  public Params(List<VariableDecl> p0) {
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
  public Params clone() throws CloneNotSupportedException {
    Params node = (Params) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Params copy() {
    try {
      Params node = (Params) clone();
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
  public Params fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:71
   */
  public Params treeCopyNoTransform() {
    Params tree = (Params) copy();
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
  public Params treeCopy() {
    Params tree = (Params) copy();
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
   * Replaces the VariableDecl list.
   * @param list The new list node to be used as the VariableDecl list.
   * @apilevel high-level
   */
  public Params setVariableDeclList(List<VariableDecl> list) {
    setChild(list, 0);
    return this;
  }
  /**
   * Retrieves the number of children in the VariableDecl list.
   * @return Number of children in the VariableDecl list.
   * @apilevel high-level
   */
  public int getNumVariableDecl() {
    return getVariableDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the VariableDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the VariableDecl list.
   * @apilevel low-level
   */
  public int getNumVariableDeclNoTransform() {
    return getVariableDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the VariableDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the VariableDecl list.
   * @apilevel high-level
   */
  public VariableDecl getVariableDecl(int i) {
    return (VariableDecl) getVariableDeclList().getChild(i);
  }
  /**
   * Check whether the VariableDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasVariableDecl() {
    return getVariableDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the VariableDecl list.
   * @param node The element to append to the VariableDecl list.
   * @apilevel high-level
   */
  public Params addVariableDecl(VariableDecl node) {
    List<VariableDecl> list = (parent == null) ? getVariableDeclListNoTransform() : getVariableDeclList();
    list.addChild(node);
    return this;
  }
  /** @apilevel low-level 
   */
  public Params addVariableDeclNoTransform(VariableDecl node) {
    List<VariableDecl> list = getVariableDeclListNoTransform();
    list.addChild(node);
    return this;
  }
  /**
   * Replaces the VariableDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public Params setVariableDecl(VariableDecl node, int i) {
    List<VariableDecl> list = getVariableDeclList();
    list.setChild(node, i);
    return this;
  }
  /**
   * Retrieves the VariableDecl list.
   * @return The node representing the VariableDecl list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="VariableDecl")
  public List<VariableDecl> getVariableDeclList() {
    List<VariableDecl> list = (List<VariableDecl>) getChild(0);
    return list;
  }
  /**
   * Retrieves the VariableDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the VariableDecl list.
   * @apilevel low-level
   */
  public List<VariableDecl> getVariableDeclListNoTransform() {
    return (List<VariableDecl>) getChildNoTransform(0);
  }
  /**
   * @return the element at index {@code i} in the VariableDecl list without
   * triggering rewrites.
   */
  public VariableDecl getVariableDeclNoTransform(int i) {
    return (VariableDecl) getVariableDeclListNoTransform().getChildNoTransform(i);
  }
  /**
   * Retrieves the VariableDecl list.
   * @return The node representing the VariableDecl list.
   * @apilevel high-level
   */
  public List<VariableDecl> getVariableDecls() {
    return getVariableDeclList();
  }
  /**
   * Retrieves the VariableDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the VariableDecl list.
   * @apilevel low-level
   */
  public List<VariableDecl> getVariableDeclsNoTransform() {
    return getVariableDeclListNoTransform();
  }

}
