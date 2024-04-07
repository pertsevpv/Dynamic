package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.expr.Expr;

public class Const extends Expr {

  public Const(Type type, Span span) {
    super(span);
    if (!checkType(type)) throw new IllegalArgumentException("Illegal type for const: " + type);
    this.type = type;
  }

  private boolean checkType(Type type) {
    return type == Type.INT || type == Type.REAL || type == Type.BOOL || type == Type.STRING;
  }
}
