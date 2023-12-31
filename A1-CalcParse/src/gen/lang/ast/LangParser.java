package lang.ast;
import beaver.*;
import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.zip.DeflaterOutputStream;

// This is a parser generated by NeoBeaver.
public class LangParser extends beaver.Parser {
  
	static public class SyntaxError extends RuntimeException { public SyntaxError(String msg) {super(msg);}}
	// Disable syntax error recovery
	protected void recoverFromError(Symbol token, TokenStream in) {
		throw new SyntaxError("Cannot recover from the syntax error");
	}

  public static class Terminals {
    public static final short EOF = 0;
    public static final short MUL = 1;
    public static final short IN = 2;
    public static final short END = 3;
    public static final short ID = 4;
    public static final short LET = 5;
    public static final short NUMERAL = 6;
    public static final short ASSIGN = 7;

    public static final String[] NAMES = {
        "EOF",
        "MUL",
        "IN",
        "END",
        "ID",
        "LET",
        "NUMERAL",
        "ASSIGN",
    };
  }

  private final Action[] actions = {
    Action.RETURN, // [0] factor =  let (default action: return symbol 1)
    Action.RETURN, // [1] id =  ID (default action: return symbol 1)
    Action.RETURN, // [2] numeral =  NUMERAL (default action: return symbol 1)
    Action.RETURN, // [3] exp =  factor (default action: return symbol 1)
    Action.RETURN, // [4] program =  exp (default action: return symbol 1)
    new Action() { // [5] GOAL =  program EOF
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol program = _symbols[offset + 1];
        final Symbol sym2 = _symbols[offset + 2];
        return program;
      }
    },
    RETURN3, // [6] exp =  exp MUL factor (default action: return symbol 3)
    RETURN7, // [7] let =  LET id ASSIGN exp IN exp END (default action: return symbol 7)
  };

      static final Action RETURN3 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 3];
        }
      };
      static final Action RETURN7 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 7];
        }
      };
  static final ParsingTables PARSING_TABLES = new ParsingTables(
    "U9oDaxzkma0CnhyZAO5mG6apC38oeauTGUe3CB3q3JfqPq4g6oj3tvKM0jVluilrmfy8Mp#" +
    "T77zdENO2u1iHKZoWYpPwQA1fdC6PEOcN4JfK9bQ95cApCqTnhp#$dulx#03jApnUwjbFcN" +
    "qgz7jKJVhzjturRNx5R#er1hNrD7aEwls88wRAldEB$QMS0g3OPHJq7yHy0tYbvdHxzVeRi" +
    "Qzm9H#7MPit5PD#WpWvor$Mg#gPhQsdI1J4hXxFR2tVGLxC07RB698H6PC9UILJyaRcP47U" +
    "oGVv94ko8XkoNSig1byiMWVjuCwyVCPxB#wS1Syot6zspdONYhDMtARYFbNnj#ZYwqdG$mF" +
    "7K1n2");

  public LangParser() {
    super(PARSING_TABLES);
  }

  protected Symbol invokeReduceAction(int rule_num, int offset) {
    return actions[rule_num].reduce(_symbols, offset);
  }
}
