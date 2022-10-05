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
 * @ast class
 * @aspect Interpreter
 * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:5
 */
public class ActivationRecord extends java.lang.Object {
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:6
   */
  
        private HashMap<String, Integer> variables = new HashMap<String, Integer>();
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:7
   */
  
        private boolean returned = false;
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:8
   */
  
        private int result = 0;
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:10
   */
  

        public void put(String id, int value) {
            this.variables.put(id, value);
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:14
   */
  

        public boolean contains(String id) {
            return this.variables.containsKey(id);
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:18
   */
  

        public int get(String id) {
            return this.variables.get(id);
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:22
   */
  

        public boolean returned() {
            return returned;
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:26
   */
  

        public void finish(int value) {
            returned = true;
            result = value;
        }
  /**
   * @aspect Interpreter
   * @declaredat /home/knos/repos/education/p021-oscar-kasper/A5-SimpliC/src/jastadd/Interpreter.jrag:31
   */
  

        public int result() {
            return result;
        }

}
