package lang;

import lang.ast.*;

/**
 * Traverses each node, passing the data to the children.
 * Returns the data unchanged.
 * Overriding methods may change the data passed and the data returned.
 */
public abstract class TraversingVisitor implements lang.ast.Visitor {

	protected Object visitChildren(ASTNode node, Object data) {
		for (int i = 0; i < node.getNumChild(); ++i) {
			node.getChild(i).accept(this, data);
		}
		return data;
	}

	public Object visit(List node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Opt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Program node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(FunctionDecl node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Block node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Stmt node, Object data) {
		return visitChildren(node, data);
	}
	public Object visit(Expr node, Object data) {
		return visitChildren(node, data);
	}
}
