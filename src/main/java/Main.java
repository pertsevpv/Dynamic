import dynamic.exception.ValidationException;
import dynamic.parser.gen.DynaLexer;
import dynamic.parser.gen.DynaParser;
import dynamic.semantic.DynaWalker;
import dynamic.semantic.context.ValidationContext;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {
    String source = readFile("main.d");
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
      System.err.println(e.getMessage());
    }
  }

  private static String readFile(String filename) {
    try {
      return Files.readString(Path.of("src", "test", "resources", "interpret", filename));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
