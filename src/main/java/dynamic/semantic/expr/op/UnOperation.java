package dynamic.semantic.expr.op;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class UnOperation extends Expr {

  public Expr expr;

  public UnOperation(Span span, Expr expr) {
    super(span);
    this.expr = expr;
  }

  enum Type {
    MINUS("-"), PLUS("+"), NOT("not");

    final String sign;
    Type(String sign) {
      this.sign = sign;
    }

    @Override
    public String toString() {
      return sign;
    }
  }

}
