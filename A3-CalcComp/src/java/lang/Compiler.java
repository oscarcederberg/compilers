package lang;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import beaver.Parser.Exception;

import lang.ast.Program;
import lang.ast.LangParser;
import lang.ast.LangScanner;

/**
 * Computes the maximum statement nesting depth for a Calc program.
 */
public class Compiler {
		public static Object DrAST_root_node; // Enable debugging with DrAST.
	
		public static void main(String[] args) {
		try {
			if (args.length != 1) {
				System.err.println(
						"You must specify a source file on the command line!");
				printUsage();
				System.exit(1);
				return;
			}

			String filename = args[0];
			LangScanner scanner = new LangScanner(new FileReader(filename));
			LangParser parser = new LangParser();
			Program program = (Program) parser.parse(scanner);
			//program.checkNames(System.err);
			program.prettyPrint(System.out);
			System.out.println("Found interactive statement(s): " + CheckInteractiveVisitor.result(program));
			DrAST_root_node = program; // Enable debugging with DrAST.
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void printUsage() {
		System.err.println("Usage: Compiler FILE");
		System.err.println("    where FILE is the file to be compiled");
	}
}

