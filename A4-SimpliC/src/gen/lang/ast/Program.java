/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.5 */
package lang.ast;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast node
 * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/lang.ast:1
 * @astdecl Program : ASTNode ::= FunctionDecl*;
 * @production Program : {@link ASTNode} ::= <span class="component">{@link FunctionDecl}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/PrettyPrint.jrag:14
   */
  public void prettyPrint(PrintStream out, String ind) {
	    for (ASTNode child : astChildren()) {
		    child.prettyPrint(out, ind);
	    }
	}
  /**
   * @aspect Visitor
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/Visitor.jrag:26
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
    predefinedFunctions_reset();
    unknownDecl_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:33
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    Program_errors_visited = false;
    Program_errors_computed = false;
    
    Program_errors_value = null;
    contributorMap_Program_errors = null;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:42
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:47
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
   * @declaredat ASTNode:66
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
   * @declaredat ASTNode:76
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
   * @declaredat ASTNode:96
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
  /**
   * @aspect <NoAspect>
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/Errors.jrag:26
   */
  /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_Program_errors = null;

  /** @apilevel internal */
  protected void survey_Program_errors() {
    if (contributorMap_Program_errors == null) {
      contributorMap_Program_errors = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
      collect_contributors_Program_errors(this, contributorMap_Program_errors);
    }
  }

/** @apilevel internal */
protected boolean predefinedFunctions_visited = false;
  /** @apilevel internal */
  private void predefinedFunctions_reset() {
    predefinedFunctions_computed = false;
    
    predefinedFunctions_value = null;
    predefinedFunctions_visited = false;
  }
  /** @apilevel internal */
  protected boolean predefinedFunctions_computed = false;

  /** @apilevel internal */
  protected List<FunctionDecl> predefinedFunctions_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/NameAnalysis.jrag:67
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/NameAnalysis.jrag:67")
  public List<FunctionDecl> predefinedFunctions() {
    ASTState state = state();
    if (predefinedFunctions_computed) {
      return predefinedFunctions_value;
    }
    if (predefinedFunctions_visited) {
      throw new RuntimeException("Circular definition of attribute Program.predefinedFunctions().");
    }
    predefinedFunctions_visited = true;
    state().enterLazyAttribute();
    predefinedFunctions_value = predefinedFunctions_compute();
    predefinedFunctions_value.setParent(this);
    predefinedFunctions_computed = true;
    state().leaveLazyAttribute();
    predefinedFunctions_visited = false;
    return predefinedFunctions_value;
  }
  /** @apilevel internal */
  private List<FunctionDecl> predefinedFunctions_compute() {
  		List<FunctionDecl> list = new List<FunctionDecl>();
  		list.add(new FunctionDecl(new IdDecl("print"), new List(), new Block(new List())));
  		list.add(new FunctionDecl(new IdDecl("read"), new List(), new Block(new List())));
  		return list;
  	}
/** @apilevel internal */
protected boolean unknownDecl_visited = false;
  /** @apilevel internal */
  private void unknownDecl_reset() {
    unknownDecl_computed = false;
    
    unknownDecl_value = null;
    unknownDecl_visited = false;
  }
  /** @apilevel internal */
  protected boolean unknownDecl_computed = false;

  /** @apilevel internal */
  protected UnknownDecl unknownDecl_value;

  /**
   * @attribute syn
   * @aspect UnknownDecl
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:2
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:2")
  public UnknownDecl unknownDecl() {
    ASTState state = state();
    if (unknownDecl_computed) {
      return unknownDecl_value;
    }
    if (unknownDecl_visited) {
      throw new RuntimeException("Circular definition of attribute Program.unknownDecl().");
    }
    unknownDecl_visited = true;
    state().enterLazyAttribute();
    unknownDecl_value = new UnknownDecl("<unknown>");
    unknownDecl_value.setParent(this);
    unknownDecl_computed = true;
    state().leaveLazyAttribute();
    unknownDecl_visited = false;
    return unknownDecl_value;
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/Errors.jrag:28
   * @apilevel internal
   */
  public Program Define_program(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return this;
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/Errors.jrag:28
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute program
   */
  protected boolean canDefine_program(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/NameAnalysis.jrag:18
   * @apilevel internal
   */
  public IdDecl Define_lookup(ASTNode _callerNode, ASTNode _childNode, String s) {
    if (_callerNode == getFunctionDeclListNoTransform()) {
      // @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/NameAnalysis.jrag:32
      int index = _callerNode.getIndexOfChild(_childNode);
      {
      		for(VariableDecl decl : getFunctionDecl(index).getVariableDecls()){
      			if(decl.getIdDecl().getID().equals(s)){
      				return decl.getIdDecl();
      			}
      		}
      		for(FunctionDecl func : getFunctionDecls()) {
      			if(func.getIdDecl().getID().equals(s)){
      				return func.getIdDecl();
      			}
      		}
      		for(FunctionDecl func : predefinedFunctions()){
      			if(func.getIdDecl().getID().equals(s)){
      				return func.getIdDecl();
      			}
      		}
      		return unknownDecl();
      	}
    }
    else {
      int childIndex = this.getIndexOfChild(_callerNode);
      return unknownDecl();
    }
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/NameAnalysis.jrag:18
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute lookup
   */
  protected boolean canDefine_lookup(ASTNode _callerNode, ASTNode _childNode, String s) {
    return true;
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:3
   * @apilevel internal
   */
  public UnknownDecl Define_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    int childIndex = this.getIndexOfChild(_callerNode);
    return unknownDecl();
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:3
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute unknownDecl
   */
  protected boolean canDefine_unknownDecl(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:9
   * @apilevel internal
   */
  public boolean Define_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:14
      return false;
    }
    else {
      return getParent().Define_isFunction(this, _callerNode);
    }
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:9
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isFunction
   */
  protected boolean canDefine_isFunction(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:10
   * @apilevel internal
   */
  public boolean Define_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    if (_callerNode == unknownDecl_value) {
      // @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:17
      return false;
    }
    else {
      return getParent().Define_isVariable(this, _callerNode);
    }
  }
  /**
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/UnknownDecl.jrag:10
   * @apilevel internal
   * @return {@code true} if this node has an equation for the inherited attribute isVariable
   */
  protected boolean canDefine_isVariable(ASTNode _callerNode, ASTNode _childNode) {
    return true;
  }
/** @apilevel internal */
protected boolean Program_errors_visited = false;
  /**
   * @attribute coll
   * @aspect Errors
   * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/Errors.jrag:26
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
  @ASTNodeAnnotation.Source(aspect="Errors", declaredAt="/mnt/d/coursework/edan65-compilers/assignments/A4-SimpliC/src/jastadd/Errors.jrag:26")
  public Set<ErrorMessage> errors() {
    ASTState state = state();
    if (Program_errors_computed) {
      return Program_errors_value;
    }
    if (Program_errors_visited) {
      throw new RuntimeException("Circular definition of attribute Program.errors().");
    }
    Program_errors_visited = true;
    state().enterLazyAttribute();
    Program_errors_value = errors_compute();
    Program_errors_computed = true;
    state().leaveLazyAttribute();
    Program_errors_visited = false;
    return Program_errors_value;
  }
  /** @apilevel internal */
  private Set<ErrorMessage> errors_compute() {
    ASTNode node = this;
    while (node != null && !(node instanceof Program)) {
      node = node.getParent();
    }
    Program root = (Program) node;
    root.survey_Program_errors();
    Set<ErrorMessage> _computedValue = new TreeSet<ErrorMessage>();
    if (root.contributorMap_Program_errors.containsKey(this)) {
      for (ASTNode contributor : (java.util.Set<ASTNode>) root.contributorMap_Program_errors.get(this)) {
        contributor.contributeTo_Program_errors(_computedValue);
      }
    }
    return _computedValue;
  }
  /** @apilevel internal */
  protected boolean Program_errors_computed = false;

  /** @apilevel internal */
  protected Set<ErrorMessage> Program_errors_value;


}
