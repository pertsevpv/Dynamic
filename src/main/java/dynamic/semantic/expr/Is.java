package dynamic.semantic.expr;

import dynamic.semantic.Span;
import dynamic.semantic.Type;

public class Is extends Expr {

  public Expr expr;
  public Type isType;

  public Is(Expr expr, Type isType, Span span) {
    super(span);
    this.expr = expr;
    this.isType = isType;
  }
}
