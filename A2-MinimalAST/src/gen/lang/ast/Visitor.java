package lang.ast;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Visitor interface for MinimalC language. Each concrete node type must
 * have a visit method.
 * @ast interface
 * @aspect Visitor
 * @declaredat /home/knos/repos/work/p021-oscar-kasper/A2-MinimalAST/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(FunctionDecl node, Object data);

		 
		public Object visit(Block node, Object data);

		 
		public Object visit(Stmt node, Object data);

		 
		public Object visit(Expr node, Object data);
}
