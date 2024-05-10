package dynamic;

import dynamic.exception.ValidationException;
import dynamic.interpret.IOContext;
import dynamic.parser.gen.DynaLexer;
import dynamic.parser.gen.DynaParser;
import dynamic.semantic.DynaWalker;
import dynamic.semantic.context.ValidationContext;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLButtonElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLTextAreaElement;

public class Client {

  private static HTMLTextAreaElement codeEditor;
  private static HTMLTextAreaElement input, output;
  private static HTMLButtonElement runButton;

  public static void main(String[] args) {
    var document = HTMLDocument.current();
    codeEditor = document.getElementById("code-editor").cast();
    input = document.getElementById("input").cast();
    output = document.getElementById("output").cast();

    runButton = document.getElementById("run").cast();
    runButton.addEventListener("click", Client::onRunClicked);
  }

  private static void onRunClicked(Event event) {
    var code = codeEditor.getValue();
    var inputData = input.getValue();
    IOContext.setScannerSource(inputData);
    IOContext.setPrint(Client::print);

    try {
      var lexer = new DynaLexer(CharStreams.fromString(code));
      var tokenStream = new CommonTokenStream(lexer);
      tokenStream.fill();
      var parser = new DynaParser(tokenStream);
      var programCtx = parser.program();
      var walker = new DynaWalker(programCtx).analyze();
      walker.validate(new ValidationContext());
      walker.execute();
    } catch (Exception e) {
      printError(e.getMessage());
    }
  }

  private static void printError(String string) {
    output.getStyle().setProperty("color", "red");
    System.out.println("Hui: " + string);
    output.setValue(string);
  }

  private static void print(String string) {
    output.setValue(output.getValue() + string);
  }
}
