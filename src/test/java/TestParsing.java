import dynamic.exception.ValidationException;
import dynamic.interpret.IOContext;
import dynamic.parser.gen.DynaLexer;
import dynamic.parser.gen.DynaParser;
import dynamic.semantic.DynaWalker;
import dynamic.semantic.context.ValidationContext;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestParsing {

  @Test
  public void testLexing() {
    String source = readFile("main2.d");
    Assertions.assertDoesNotThrow(() -> {
      var lexer = new DynaLexer(CharStreams.fromString(source));
      var tokenStream = new CommonTokenStream(lexer);
      tokenStream.fill();
      var allTokens = tokenStream.getTokens();
      allTokens.forEach(this::printTokenNames);
    });
  }

  @Test
  public void testParsing() {
    String source = readFile("binSearch.d");
    Assertions.assertDoesNotThrow(() -> {
      var lexer = new DynaLexer(CharStreams.fromString(source));
      var tokenStream = new CommonTokenStream(lexer);
      tokenStream.fill();
      var parser = new DynaParser(tokenStream);
      parser.setErrorHandler(new BailErrorStrategy());
      var program = parser.program();
    });
  }

  @Test
  public void testSemantic() {
    String source = readFile("binSearch.d");
    var lexer = new DynaLexer(CharStreams.fromString(source));
    var tokenStream = new CommonTokenStream(lexer);
    tokenStream.fill();
    var parser = new DynaParser(tokenStream);
    parser.setErrorHandler(new BailErrorStrategy());
    var programCtx = parser.program();
    try {
      var walker = new DynaWalker(programCtx).analyze();
      StringBuilder sb = new StringBuilder();
      walker.validate(new ValidationContext());
      walker.optimize().print(0, sb);
      System.out.println();
      System.out.println(sb);
    } catch (ValidationException e) {
    e.printStackTrace();
//      System.err.println(e.getMessage());
    }
  }

  @Test
  public void testExecute() {
    int i = IOContext.nextInt();
    System.out.println(i);
    String source = readFile("test.d");
    var lexer = new DynaLexer(CharStreams.fromString(source));
    var tokenStream = new CommonTokenStream(lexer);
    tokenStream.fill();
    var parser = new DynaParser(tokenStream);
    parser.setErrorHandler(new BailErrorStrategy());
    var programCtx = parser.program();
    try {
      var walker = new DynaWalker(programCtx).analyze();
      walker.validate(new ValidationContext());
      walker.execute();
    } catch (ValidationException e) {
      e.printStackTrace();
//      System.err.println(e.getMessage());
    }
  }

  private String readFile(String filename) {
    try {
      return Files.readString(Path.of("src", "test", "resources", "interpret", filename));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void printTokenInfo(Token token) {
    if (token.getType() == Token.EOF) {
      System.out.println("<EOF>");
      return;
    }
    if (token.getChannel() == DynaLexer.HIDDEN) return;
    var text = token.getText()
        .replace("\n", "\\n")
        .replace("\r", "\\r");
    var ruleName = DynaLexer.ruleNames[token.getType() - 1];
    System.out.print(ruleName + " at " + token.getLine() + ":" + token.getCharPositionInLine() + " — " + text + " ");
    if (token.getChannel() == DynaLexer.HIDDEN) System.out.print("(HIDDEN)");
    System.out.println();
  }

  private void printTokenNames(Token token) {
    if (token.getType() == Token.EOF) {
      System.out.println("<EOF>");
      return;
    }
    if (token.getType() == DynaLexer.NEW_LINE || token.getType() == DynaLexer.WS)
      System.out.print(token.getText());
    else {
      var ruleName = DynaLexer.VOCABULARY.getSymbolicName(token.getType());
      System.out.print(ruleName);
    }
  }
}
