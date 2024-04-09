package dynamic.semantic.entity.expr;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.entity.Validatable;

public abstract class Expr implements Validatable {

  public Span span;
  public Type type;

  public Expr(Span span) {
    this.span = span;
  }
}
