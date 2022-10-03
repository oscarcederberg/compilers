package lang.ast;

import java.io.PrintStream;
import java.util.Set;
import java.util.HashMap;
import java.util.TreeSet;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
/**
 * @ast class
 * @aspect Interpreter
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:4
 */
public class ActivationRecord extends java.lang.Object {
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:5
   */
  
        private HashMap<String, Integer> variables = new HashMap<String, Integer>();
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:6
   */
  
        private boolean returned = false;
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:7
   */
  
        private int result = 0;
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:9
   */
  

        public void put(String id, int value) {
            this.variables.put(id, value);
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:13
   */
  

        public boolean contains(String id) {
            return this.variables.containsKey(id);
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:17
   */
  

        public int get(String id) {
            return this.variables.get(id);
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:21
   */
  

        public boolean returned() {
            return returned;
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:25
   */
  

        public void finish(int value) {
            returned = true;
            result = value;
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:30
   */
  

        public int result() {
            return result;
        }

}
