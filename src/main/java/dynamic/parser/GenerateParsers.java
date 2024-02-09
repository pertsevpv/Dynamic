package dynamic.parser;

import org.antlr.v4.Tool;


public class GenerateParsers {

  public static final String OUTPUT = "src/main/java/dynamic/parser/gen";
  public static final String PACKAGE = "dynamic.parser.gen";
  public static final String GRAMMAR_PATH = "src/main/resources/dynamic/grammar/";

  public static void main(String[] args) {
    args = new String[] {
        "-o", OUTPUT,
        "-package", PACKAGE,
        "-Xexact-output-dir",
        GRAMMAR_PATH + "DynaLexer.g4",
        GRAMMAR_PATH + "DynaParser.g4"
    };
    new Tool(args).processGrammarsOnCommandLine();
  }
}
