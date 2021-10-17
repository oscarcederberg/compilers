package lang.ast;

import java.io.PrintStream;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast class
 * @aspect NameAnalysis
 * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:5
 */
public class SymbolTable extends java.lang.Object {
  /**
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:6
   */
  
		private static final SymbolTable BOTTOM = new SymbolTable() {
			@Override
			public boolean declare(String name) {
				throw new UnsupportedOperationException(
						"cannot add name to bottom of name stack");
			}
			@Override
			public boolean lookup(String name) {
				return false;
			}
		};
  /**
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:18
   */
  

		private final SymbolTable tail;
  /**
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:19
   */
  
		private final Set<String> names = new HashSet<String>();
  /**
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:21
   */
   //Make this a HashMap

		public SymbolTable() {
			tail = BOTTOM;
		}
  /**
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:25
   */
  

		public SymbolTable(SymbolTable tail) {
			this.tail = tail;
		}
  /**
   * Attempt to add a new name to the symbol table.
   * @return true if name was not already declared
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:33
   */
  

		/**
		 * Attempt to add a new name to the symbol table.
		 * @return true if name was not already declared
		 */
		public boolean declare(String name) {
			boolean temp = names.add(name);
			//if(!temp) System.exit(1);
			return temp;
		}
  /**
   * @return true if name has been declared
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:42
   */
  

		/**
		 * @return true if name has been declared
		 */
		public boolean lookup(String name) {
			boolean temp = names.contains(name) || tail.lookup(name);
			//if (!temp) System.exit(1);
			return temp;
		}
  /**
   * Push a new table on the stack.
   * @return the new top of the stack
   * @aspect NameAnalysis
   * @declaredat /home/knos/repos/work/p021-oscar-kasper/A4-SimpliC/src/jastadd/NameAnalysis.jrag:52
   */
  

		/**
		 * Push a new table on the stack.
		 * @return the new top of the stack
		 */
		public SymbolTable push() {
			return new SymbolTable(this);
		}

}
