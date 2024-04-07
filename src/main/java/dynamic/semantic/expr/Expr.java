package dynamic.semantic.expr;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.Validatable;

public abstract class Expr implements Validatable {

  public Span span;
  public Type type;

  public Expr(Span span) {
    this.span = span;
  }
}
