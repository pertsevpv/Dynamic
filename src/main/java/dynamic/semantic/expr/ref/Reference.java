package dynamic.semantic.expr.ref;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public abstract class Reference extends Expr {
  public Reference(Span span) {
    super(span);
  }
}
