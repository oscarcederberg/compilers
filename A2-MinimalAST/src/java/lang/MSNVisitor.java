package lang;

import lang.ast.*;

/**
 * Checks if there are any 'ask user' statements in a Calc program.
 */
public class MSNVisitor extends TraversingVisitor {
	public static int result(ASTNode n) {
		MSNVisitor v = new MSNVisitor();	
        return (int) n.accept(v, 0);
	}


	protected Object visitChildren(ASTNode node, Object data) {
		int maxDepth = 0;
		for (int i = 0; i < node.getNumChild(); ++i) {
            int depth = (int) node.getChild(i).accept(this, data);
			maxDepth = Math.max(maxDepth, depth);
		}
		return data;
	}

	public Object visit(Block node, Object data) { 
		return visitChildren(node, (int) data + 1); 
	}
}