package dynamic.semantic.entity;

import dynamic.semantic.Span;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Id {

  public Span span;
  public String name;

  public Id(String name, Span span) {
    this.name = name;
    this.span = span;
  }

  public static Id fromNode(TerminalNode node) {
    return fromToken(node.getSymbol());
  }

  public static Id fromToken(Token token) {
    return new Id(token.getText(), Span.fromToken(token));
  }

  @Override
  public String toString() {
    return name;
  }
}
