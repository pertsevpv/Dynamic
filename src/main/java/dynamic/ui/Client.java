package dynamic.ui;

import dynamic.interpret.IOContext;
import dynamic.parser.gen.DynaLexer;
import dynamic.parser.gen.DynaParser;
import dynamic.semantic.DynaWalker;
import dynamic.semantic.context.ValidationContext;
import dynamic.ui.examples.*;
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

    onExampleClicked(document, "printing", InputOutput.PRINTING);
    onExampleClicked(document, "reading", InputOutput.READING);
    onExampleClicked(document, "readingArray", InputOutput.READING_ARRAY);

    onExampleClicked(document, "getType", TypesOperations.TYPES);
    onExampleClicked(document, "operations", TypesOperations.OPERATIONS);

    onExampleClicked(document, "lcs", Strings.LCS);

    onExampleClicked(document, "person", Tuple.PERSON);

    onExampleClicked(document, "binSearch", Arrays.BIN_SEARCH);
    onExampleClicked(document, "mergeSort", Arrays.MERGE_SORT);
    onExampleClicked(document, "indices", Arrays.INDICES);

    onExampleClicked(document, "while", Loops.WHILE);
    onExampleClicked(document, "for", Loops.FOR);
    onExampleClicked(document, "forEach", Loops.FOR_EACH);

    onExampleClicked(document, "recursive", Funcs.RECURSIVE);
    onExampleClicked(document, "map", Funcs.MAP);
    onExampleClicked(document, "fold", Funcs.FOLD);
  }

  private static void onRunClicked(Event event) {
    var code = codeEditor.getValue().replace("\r", "");
    var inputData = input.getValue().replace("\r", "");
    output.setValue("");
    output.getStyle().setProperty("color", "black");
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

  private static void onExampleClicked(HTMLDocument document, String exampleId, String exampleSource) {
    HTMLButtonElement btn = document.getElementById(exampleId).cast();
    btn.addEventListener("click", (Event event) -> setSource(exampleSource));
  }

  private static void setSource(String source) {
    codeEditor.setValue(source);
  }

  private static void printError(String string) {
    output.getStyle().setProperty("color", "red");
    output.clear();
    output.setValue(string);
  }

  private static void print(String string) {
    output.setValue(output.getValue() + string);
  }
}
