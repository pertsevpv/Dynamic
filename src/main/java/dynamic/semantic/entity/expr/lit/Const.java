package dynamic.semantic.entity.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;

public abstract class Const<T> extends Expr {
  public T value;

  public Const(T value, Type type, Span span) {
    super(span);
    this.value = value;
    this.type = type;
  }
}