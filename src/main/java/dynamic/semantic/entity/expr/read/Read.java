package dynamic.semantic.entity.expr.read;

import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;

public abstract class Read<T> extends Expr {

  public T value;

  public Read(Span span) {
    super(span);
  }
}
