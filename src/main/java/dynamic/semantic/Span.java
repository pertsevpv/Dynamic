package dynamic.semantic;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Objects;

public class Span {

  public int line, pos;
  public String filename;

  public Span(int line, int pos) {
    this(line, pos, null);
  }

  public Span(int line, int pos, String filename) {
    this.line = line;
    this.pos = pos;
    this.filename = filename;
  }

  public static Span fromRule(ParserRuleContext ctx) {
    return fromToken(ctx.start);
  }

  public static Span fromNode(TerminalNode node) {
    return fromToken(node.getSymbol());
  }

  public static Span fromToken(Token start) {
    int line = start.getLine();
    int pos = start.getCharPositionInLine() + 1;
    return new Span(line, pos);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Span span = (Span) o;
    return line == span.line && pos == span.pos && Objects.equals(filename, span.filename);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line, pos, filename);
  }

  @Override
  public String toString() {
    return "(%d: %d)".formatted(line, pos);
  }
}
