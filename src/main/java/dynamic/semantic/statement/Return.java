package dynamic.semantic.statement;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class Return extends Statement {

  public Expr expr;

  public Return(Expr expr, Span span) {
    super(span);
    this.expr = expr;
  }
}
