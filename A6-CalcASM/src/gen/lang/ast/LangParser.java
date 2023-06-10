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
    public static final short ID = 1;
    public static final short IN = 2;
    public static final short DIV = 3;
    public static final short MUL = 4;
    public static final short END = 5;
    public static final short NUMERAL = 6;
    public static final short MINUS = 7;
    public static final short LET = 8;
    public static final short ASK = 9;
    public static final short ASSIGN = 10;
    public static final short USER = 11;

    public static final String[] NAMES = {
        "EOF",
        "ID",
        "IN",
        "DIV",
        "MUL",
        "END",
        "NUMERAL",
        "MINUS",
        "LET",
        "ASK",
        "ASSIGN",
        "USER",
    };
  }

  private final Action[] actions = {
    Action.RETURN, // [0] factor =  numeral (default action: return symbol 1)
    new Action() { // [1] numeral =  NUMERAL
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol num = _symbols[offset + 1];
        return new Numeral(num);
      }
    },
    new Action() { // [2] program =  exp
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        return new Program(a);
      }
    },
    Action.RETURN, // [3] exp =  factor (default action: return symbol 1)
    new Action() { // [4] id_use =  ID
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol id = _symbols[offset + 1];
        return new IdUse(id);
      }
    },
    new Action() { // [5] factor =  MINUS factor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol MINUS = _symbols[offset + 1];
        final Expr f = (Expr) _symbols[offset + 2].value;
        return new Neg(f);
      }
    },
    new Action() { // [6] binding_list =  binding
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Binding a = (Binding) _symbols[offset + 1].value;
        return new List().add(a);
      }
    },
    new Action() { // [7] id_decl =  ID
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol id = _symbols[offset + 1];
        return new IdDecl(id);
      }
    },
    new Action() { // [8] GOAL =  program EOF
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Program program = (Program) _symbols[offset + 1].value;
        final Symbol sym2 = _symbols[offset + 2];
        return program;
      }
    },
    new Action() { // [9] ask =  ASK USER
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol ASK = _symbols[offset + 1];
        final Symbol USER = _symbols[offset + 2];
        return new Ask();
      }
    },
    new Action() { // [10] binding_list =  binding_list binding
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final List a = (List) _symbols[offset + 1].value;
        final Binding b = (Binding) _symbols[offset + 2].value;
        return a.add(b);
      }
    },
    new Action() { // [11] exp =  exp DIV factor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol DIV = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Div(a, b);
      }
    },
    new Action() { // [12] exp =  exp MUL factor
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Expr a = (Expr) _symbols[offset + 1].value;
        final Symbol MUL = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Mul(a, b);
      }
    },
    new Action() { // [13] binding =  id_decl ASSIGN exp
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final IdDecl a = (IdDecl) _symbols[offset + 1].value;
        final Symbol ASSIGN = _symbols[offset + 2];
        final Expr b = (Expr) _symbols[offset + 3].value;
        return new Binding(a, b);
      }
    },
    new Action() { // [14] let =  LET binding_list IN exp END
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol LET = _symbols[offset + 1];
        final List a = (List) _symbols[offset + 2].value;
        final Symbol IN = _symbols[offset + 3];
        final Expr b = (Expr) _symbols[offset + 4].value;
        final Symbol END = _symbols[offset + 5];
        return new Let(a, b);
      }
    },
  };

  static final ParsingTables PARSING_TABLES = new ParsingTables(
    "U9orbJjI0a4GXlzPG0H4bASl932p33In34p8p4mqCpBs06OIU00FOEu1hF80diBS0w0e8hx" +
    "6VuQ5cM5tgh3KxlgAcd#6teRkdWN4CVAOmpo00b88a4G6DRtEOsX3NPkq30bCOmPPv916aN" +
    "iFF315TJPKrValuznP6ksKk5eELoREYlpKZocZOgbrnlam3jkgY3Kdpz$exyOT$Ssuy#0Y5" +
    "cBpwSj#RAABdlnVFNelNlVLorl75#DE$Axi$adyP#DE$2VZJdnLyTNeOsL7TlJUkFve78B$" +
    "Uebrgx3xqkoQJBWMeug6#gY#Whacc6sA7PPdlnRq5F0yogHgLFzvhPjlst4GJaVILjquJh$" +
    "bPAnvp$#tJZKs7v#UzUJlq#7HVVMQe8wJvVz7yNrwH37vgBs8RlSLq6WXx1pe6rBT8sjaa#" +
    "oIFN903ia9EINdv89SaYjoJMx8BRaZzwHDU6UAD2cH1jaWEwH9zibHQp1MlCLHFnkarrQVa" +
    "q3hZMkCiqwshFKsQSPzN$tswEJ$q0gSDC5v4vnUeMQPCoUe1RmL1DysWhT8m5Dg7N0$eIdg" +
    "jrKAjM#tVuoj");

  public LangParser() {
    super(PARSING_TABLES);
  }

  protected Symbol invokeReduceAction(int rule_num, int offset) {
    return actions[rule_num].reduce(_symbols, offset);
  }
}