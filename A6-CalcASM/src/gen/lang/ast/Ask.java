/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
/**
 * @ast node
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/calc.ast:19
 * @astdecl Ask : Expr;
 * @production Ask : {@link Expr};

 */
public class Ask extends Expr implements Cloneable {
  /**
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/CodeGen.jrag:196
   */
  public void genEval(PrintStream out) {
    out.println("        pushq ask_msg_len");
    out.println("        leaq ask_message(%rip), %rax");
    out.println("        pushq %rax");
    out.println("        call print_string");
    out.println("        addq $16, %rsp");
    out.println("        call read");
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-CalcASM/src/jastadd/PrettyPrint.jrag:59
   */
  public void prettyPrint(PrintStream out, String ind) {
    out.print("ask user");
  }
  /**
   * @declaredat ASTNode:1
   */
  public Ask() {
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
  public Ask clone() throws CloneNotSupportedException {
    Ask node = (Ask) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:32
   */
  public Ask copy() {
    try {
      Ask node = (Ask) clone();
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
   * @declaredat ASTNode:51
   */
  @Deprecated
  public Ask fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:61
   */
  public Ask treeCopyNoTransform() {
    Ask tree = (Ask) copy();
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
   * @declaredat ASTNode:81
   */
  public Ask treeCopy() {
    Ask tree = (Ask) copy();
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

}
