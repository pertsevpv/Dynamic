package dynamic.semantic.statement;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class Assigment extends Statement {

  public String name;
  public Expr expression;

  public Assigment(String name, Expr expression, Span span) {
    super(span);
    this.name = name;
    this.expression = expression;
  }
}
