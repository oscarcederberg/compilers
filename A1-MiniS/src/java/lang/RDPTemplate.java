package lang;

import lang.ast.LangScanner;
import lang.ast.LangParser.SyntaxError;
import lang.ast.LangParser;
/**
* Abstract base class for recursive decent parsers.
* You should implement the parseProgram() method to parse a MiniS program.
*/
public abstract class RDPTemplate {
    private LangScanner scanner;
    private beaver.Symbol currentToken;
    /** Initialize the parser and start parsing via the parseProgram() method. */
    public void parse(LangScanner scanner) {
        this.scanner = scanner;
        parseProgram();
        accept(LangParser.Terminals.EOF); // Ensure all input is processed.
    }
    protected abstract void parseProgram(); // TODO
    
    /** Returns the current token without proceeding to the next. */
    protected int peek() {
        if (currentToken == null) accept();
        return currentToken.getId();
    }

    /** Read the next token from the scanner. */
    protected void accept() {
        try {
            currentToken = scanner.nextToken();
            System.out.println(LangParser.Terminals.NAMES[currentToken.getId()]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /** Ensure the current token is of a certain type; then read the next. */
    protected void accept(int expectedToken) {
        if (peek() != expectedToken) {
            error("expected token " +
            LangParser.Terminals.NAMES[expectedToken] +
            " got token " +
            LangParser.Terminals.NAMES[currentToken.getId()]);
        }
        accept();
    }

    protected static void error(String message) {
        throw new RuntimeException(message);
    }
}
