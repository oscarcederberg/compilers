package lang.ast;

import java.io.PrintStream;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

/**
 * Visitor interface for Calc language. Each concrete node type must
 * have a visit method.
 * @ast interface
 * @aspect Visitor
 * @declaredat /mnt/d/coursework/edan65-compilers/assignments/A3-CalcComp/src/jastadd/Visitor.jrag:6
 */
public interface Visitor {

		 
		public Object visit(List node, Object data);

		 
		public Object visit(Opt node, Object data);

		 
		public Object visit(Program node, Object data);

		 
		public Object visit(Mul node, Object data);

		 
		public Object visit(Div node, Object data);

		 
		public Object visit(Numeral node, Object data);

		 
		public Object visit(IdDecl node, Object data);

		 
		public Object visit(IdUse node, Object data);

		 
		public Object visit(Let node, Object data);

		 
		public Object visit(Binding node, Object data);

		 
		public Object visit(Ask node, Object data);
}
