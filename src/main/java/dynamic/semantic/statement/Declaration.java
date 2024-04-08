package dynamic.semantic.statement;

import dynamic.semantic.Id;
import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class Declaration extends Statement {

  public Id name;
  public Expr expression;

  public Declaration(Id name, Span span) {
    this(name, null, span);
  }

  public Declaration(Id name, Expr expression, Span span) {
    super(span);
    this.name = name;
    this.expression = expression;
  }
}
