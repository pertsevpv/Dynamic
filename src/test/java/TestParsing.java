import dynamic.parser.gen.DynaLexer;
import dynamic.parser.gen.DynaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestParsing {

  @Test
  public void testParsing() {
    String source = readFile("binSearch.d");
    var lexer = new DynaLexer(CharStreams.fromString(source));
    var tokenStream = new CommonTokenStream(lexer);
    tokenStream.fill();
    var parser = new DynaParser(tokenStream);
    var program = parser.program();
    System.out.println(program.getText());
  }

  private String readFile(String filename) {
    try {
      return Files.readString(Path.of("src", "test", "resources", "examples", filename));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
