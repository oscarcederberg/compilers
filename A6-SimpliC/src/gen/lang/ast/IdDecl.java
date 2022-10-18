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
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/lang.ast:4
 * @astdecl IdDecl : ASTNode ::= <ID:String>;
 * @production IdDecl : {@link ASTNode} ::= <span class="component">&lt;ID:{@link String}&gt;</span>;

 */
public class IdDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Visitor
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Visitor.jrag:31
   */
  public Object accept(Visitor visitor, Object data) {
		return visitor.visit(this, data);
	}
  /**
   * @aspect PrettyPrint
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/PrettyPrint.jrag:28
   */
  public void prettyPrint(PrintStream out, String ind) {
       out.print("int ");
       out.print(getID());    
    }
  /**
   * @declaredat ASTNode:1
   */
  public IdDecl() {
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
  /**
   * @declaredat ASTNode:12
   */
  @ASTNodeAnnotation.Constructor(
    name = {"ID"},
    type = {"String"},
    kind = {"Token"}
  )
  public IdDecl(String p0) {
    setID(p0);
  }
  /**
   * @declaredat ASTNode:20
   */
  public IdDecl(beaver.Symbol p0) {
    setID(p0);
  }
  /** @apilevel low-level 
   * @declaredat ASTNode:24
   */
  protected int numChildren() {
    return 0;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:28
   */
  public void flushAttrCache() {
    super.flushAttrCache();
    isMultiDeclared_reset();
    localIndex_reset();
    address_reset();
    isUnknown_reset();
    uniqueName_reset();
    lookup_String_reset();
    parameterIndex_reset();
    type_reset();
    isFunction_reset();
    isVariable_reset();
    function_reset();
    index_reset();
  }
  /** @apilevel internal 
   * @declaredat ASTNode:44
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();

  }
  /** @apilevel internal 
   * @declaredat ASTNode:49
   */
  public IdDecl clone() throws CloneNotSupportedException {
    IdDecl node = (IdDecl) super.clone();
    return node;
  }
  /** @apilevel internal 
   * @declaredat ASTNode:54
   */
  public IdDecl copy() {
    try {
      IdDecl node = (IdDecl) clone();
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
   * @declaredat ASTNode:73
   */
  @Deprecated
  public IdDecl fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:83
   */
  public IdDecl treeCopyNoTransform() {
    IdDecl tree = (IdDecl) copy();
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
   * @declaredat ASTNode:103
   */
  public IdDecl treeCopy() {
    IdDecl tree = (IdDecl) copy();
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
  public IdDecl setID(String value) {
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
  public IdDecl setID(beaver.Symbol symbol) {
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
/** @apilevel internal */
protected boolean isMultiDeclared_visited = false;
  /** @apilevel internal */
  private void isMultiDeclared_reset() {
    isMultiDeclared_computed = false;
    isMultiDeclared_visited = false;
  }
  /** @apilevel internal */
  protected boolean isMultiDeclared_computed = false;

  /** @apilevel internal */
  protected boolean isMultiDeclared_value;

  /**
   * @attribute syn
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:64
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:64")
  public boolean isMultiDeclared() {
    ASTState state = state();
    if (isMultiDeclared_computed) {
      return isMultiDeclared_value;
    }
    if (isMultiDeclared_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isMultiDeclared().");
    }
    isMultiDeclared_visited = true;
    state().enterLazyAttribute();
    isMultiDeclared_value = lookup(getID()) != this;
    isMultiDeclared_computed = true;
    state().leaveLazyAttribute();
    isMultiDeclared_visited = false;
    return isMultiDeclared_value;
  }
/** @apilevel internal */
protected boolean localIndex_visited = false;
  /** @apilevel internal */
  private void localIndex_reset() {
    localIndex_computed = false;
    localIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean localIndex_computed = false;

  /** @apilevel internal */
  protected int localIndex_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:288
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:286")
  public int localIndex() {
    ASTState state = state();
    if (localIndex_computed) {
      return localIndex_value;
    }
    if (localIndex_visited) {
      throw new RuntimeException("Circular definition of attribute ASTNode.localIndex().");
    }
    localIndex_visited = true;
    state().enterLazyAttribute();
    localIndex_value = parameterIndex() == -1 && !isFunction() ? prevNode().localIndex() + 1 : 0;
    localIndex_computed = true;
    state().leaveLazyAttribute();
    localIndex_visited = false;
    return localIndex_value;
  }
/** @apilevel internal */
protected boolean address_visited = false;
  /** @apilevel internal */
  private void address_reset() {
    address_computed = false;
    
    address_value = null;
    address_visited = false;
  }
  /** @apilevel internal */
  protected boolean address_computed = false;

  /** @apilevel internal */
  protected String address_value;

  /**
   * @attribute syn
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:299
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:299")
  public String address() {
    ASTState state = state();
    if (address_computed) {
      return address_value;
    }
    if (address_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.address().");
    }
    address_visited = true;
    state().enterLazyAttribute();
    address_value = address_compute();
    address_computed = true;
    state().leaveLazyAttribute();
    address_visited = false;
    return address_value;
  }
  /** @apilevel internal */
  private String address_compute() {
          if (parameterIndex() != -1) 
              return (16 + 8 * parameterIndex()) + "(%rbp)";
          else
              return "-" + (8 * localIndex()) + "(%rbp)";
      }
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
   * @aspect UnknownDecl
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:10
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:10")
  public boolean isUnknown() {
    ASTState state = state();
    if (isUnknown_computed) {
      return isUnknown_value;
    }
    if (isUnknown_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isUnknown().");
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
protected boolean uniqueName_visited = false;
  /** @apilevel internal */
  private void uniqueName_reset() {
    uniqueName_computed = false;
    
    uniqueName_value = null;
    uniqueName_visited = false;
  }
  /** @apilevel internal */
  protected boolean uniqueName_computed = false;

  /** @apilevel internal */
  protected String uniqueName_value;

  /**
   * @attribute syn
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:184
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
  @ASTNodeAnnotation.Source(aspect="Interpreter", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:184")
  public String uniqueName() {
    ASTState state = state();
    if (uniqueName_computed) {
      return uniqueName_value;
    }
    if (uniqueName_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.uniqueName().");
    }
    uniqueName_visited = true;
    state().enterLazyAttribute();
    uniqueName_value = uniqueName_compute();
    uniqueName_computed = true;
    state().leaveLazyAttribute();
    uniqueName_visited = false;
    return uniqueName_value;
  }
  /** @apilevel internal */
  private String uniqueName_compute() {
          //System.out.print(index() + getID() + "\n");
          return  index() + getID();
      }
  /**
   * @attribute inh
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:5
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="NameAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/NameAnalysis.jrag:5")
  public IdDecl lookup(String s) {
    Object _parameters = s;
    if (lookup_String_visited == null) lookup_String_visited = new java.util.HashSet(4);
    if (lookup_String_values == null) lookup_String_values = new java.util.HashMap(4);
    ASTState state = state();
    if (lookup_String_values.containsKey(_parameters)) {
      return (IdDecl) lookup_String_values.get(_parameters);
    }
    if (lookup_String_visited.contains(_parameters)) {
      throw new RuntimeException("Circular definition of attribute IdDecl.lookup(String).");
    }
    lookup_String_visited.add(_parameters);
    state().enterLazyAttribute();
    IdDecl lookup_String_value = getParent().Define_lookup(this, null, s);
    lookup_String_values.put(_parameters, lookup_String_value);
    state().leaveLazyAttribute();
    lookup_String_visited.remove(_parameters);
    return lookup_String_value;
  }
/** @apilevel internal */
protected java.util.Set lookup_String_visited;
  /** @apilevel internal */
  private void lookup_String_reset() {
    lookup_String_values = null;
    lookup_String_visited = null;
  }
  /** @apilevel internal */
  protected java.util.Map lookup_String_values;

  /**
   * @attribute inh
   * @aspect CodeGen
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:295
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="CodeGen", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/CodeGen.jrag:295")
  public int parameterIndex() {
    ASTState state = state();
    if (parameterIndex_computed) {
      return parameterIndex_value;
    }
    if (parameterIndex_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.parameterIndex().");
    }
    parameterIndex_visited = true;
    state().enterLazyAttribute();
    parameterIndex_value = getParent().Define_parameterIndex(this, null);
    parameterIndex_computed = true;
    state().leaveLazyAttribute();
    parameterIndex_visited = false;
    return parameterIndex_value;
  }
/** @apilevel internal */
protected boolean parameterIndex_visited = false;
  /** @apilevel internal */
  private void parameterIndex_reset() {
    parameterIndex_computed = false;
    parameterIndex_visited = false;
  }
  /** @apilevel internal */
  protected boolean parameterIndex_computed = false;

  /** @apilevel internal */
  protected int parameterIndex_value;

  /**
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:35
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="TypeAnalysis", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/TypeAnalysis.jrag:35")
  public Type type() {
    ASTState state = state();
    if (type_computed) {
      return type_value;
    }
    if (type_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.type().");
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
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:16
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:16")
  public boolean isFunction() {
    ASTState state = state();
    if (isFunction_computed) {
      return isFunction_value;
    }
    if (isFunction_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isFunction().");
    }
    isFunction_visited = true;
    state().enterLazyAttribute();
    isFunction_value = getParent().Define_isFunction(this, null);
    isFunction_computed = true;
    state().leaveLazyAttribute();
    isFunction_visited = false;
    return isFunction_value;
  }
/** @apilevel internal */
protected boolean isFunction_visited = false;
  /** @apilevel internal */
  private void isFunction_reset() {
    isFunction_computed = false;
    isFunction_visited = false;
  }
  /** @apilevel internal */
  protected boolean isFunction_computed = false;

  /** @apilevel internal */
  protected boolean isFunction_value;

  /**
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:17
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:17")
  public boolean isVariable() {
    ASTState state = state();
    if (isVariable_computed) {
      return isVariable_value;
    }
    if (isVariable_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.isVariable().");
    }
    isVariable_visited = true;
    state().enterLazyAttribute();
    isVariable_value = getParent().Define_isVariable(this, null);
    isVariable_computed = true;
    state().leaveLazyAttribute();
    isVariable_visited = false;
    return isVariable_value;
  }
/** @apilevel internal */
protected boolean isVariable_visited = false;
  /** @apilevel internal */
  private void isVariable_reset() {
    isVariable_computed = false;
    isVariable_visited = false;
  }
  /** @apilevel internal */
  protected boolean isVariable_computed = false;

  /** @apilevel internal */
  protected boolean isVariable_value;

  /**
   * @attribute inh
   * @aspect UnknownDecl
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:18
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="UnknownDecl", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/UnknownDecl.jrag:18")
  public FunctionDecl function() {
    ASTState state = state();
    if (function_computed) {
      return function_value;
    }
    if (function_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.function().");
    }
    function_visited = true;
    state().enterLazyAttribute();
    function_value = getParent().Define_function(this, null);
    function_computed = true;
    state().leaveLazyAttribute();
    function_visited = false;
    return function_value;
  }
/** @apilevel internal */
protected boolean function_visited = false;
  /** @apilevel internal */
  private void function_reset() {
    function_computed = false;
    
    function_value = null;
    function_visited = false;
  }
  /** @apilevel internal */
  protected boolean function_computed = false;

  /** @apilevel internal */
  protected FunctionDecl function_value;

  /**
   * @attribute inh
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:188
   */
  @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
  @ASTNodeAnnotation.Source(aspect="Interpreter", declaredAt="/home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Interpreter.jrag:188")
  public String index() {
    ASTState state = state();
    if (index_computed) {
      return index_value;
    }
    if (index_visited) {
      throw new RuntimeException("Circular definition of attribute IdDecl.index().");
    }
    index_visited = true;
    state().enterLazyAttribute();
    index_value = getParent().Define_index(this, null);
    index_computed = true;
    state().leaveLazyAttribute();
    index_visited = false;
    return index_value;
  }
/** @apilevel internal */
protected boolean index_visited = false;
  /** @apilevel internal */
  private void index_reset() {
    index_computed = false;
    
    index_value = null;
    index_visited = false;
  }
  /** @apilevel internal */
  protected boolean index_computed = false;

  /** @apilevel internal */
  protected String index_value;

  /** @apilevel internal */
  protected void collect_contributors_Program_errors(Program _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
    // @declaredat /home/knos/repos/education/p021-oscar-kasper/A6-SimpliC/src/jastadd/Errors.jrag:74
    if (isMultiDeclared()) {
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
    if (isMultiDeclared()) {
      collection.add(error("symbol '" + getID() + "' is already declared!"));
    }
  }

}
