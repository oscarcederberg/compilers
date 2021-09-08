package lang;

import lang.ast.LangParser.Terminals;

public class OKParser extends RDPTemplate {

    protected void parseProgram(){
        parseStmt();
    }

    protected void parseStmt(){
        int token = peek();
        switch (token){
            case Terminals.FOR:
                parseForStmt();
                break;
            case Terminals.IF:
                parseIfStmt();
                break;
            case Terminals.ID:
                parseAssignment();
                break;
            default:
                error("Not a stmt");
        }
    }

    protected void parseForStmt(){
        accept(Terminals.FOR);
        parseAssignment();
        accept(Terminals.UNTIL);
        parseExpr();
        accept(Terminals.DO);
        parseStmt();
        accept(Terminals.OD);
    }

    protected void parseIfStmt(){
        accept(Terminals.IF);
        parseExpr();
        accept(Terminals.THEN);
        parseStmt();
        accept(Terminals.FI);
    }

    protected void parseAssignment(){
        accept(Terminals.ID);
        accept(Terminals.ASSIGN);
        parseExpr();
    }

    protected void parseExpr(){
        int token = peek();
        switch(token){
            case Terminals.ID:
                accept(Terminals.ID);
                break;
            case Terminals.NUMERAL:
                accept(Terminals.NUMERAL);
                break;
            case Terminals.NOT:
                accept(Terminals.NOT);
                parseExpr();
                break;
            default:
                error("Expected an expr, found not an expr");
        }
    }
}
