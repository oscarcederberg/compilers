package lang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import lang.ast.LangParser;
import lang.ast.LangParser.SyntaxError;
import lang.ast.LangScanner;

public class OKCompiler {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("You must specify a source file on the command line!");
			System.exit(1);
		}

		try {
			parse(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void parse(Reader reader) {
		LangScanner scanner = new LangScanner(reader);
		OKParser parser = new OKParser();

		try {
			parser.parse(scanner);
			System.out.println("Valid syntax");
		} catch (SyntaxError e) {
			System.err.println("Syntax error: " + e.getMessage());
			System.exit(1);
		}
	}
}
