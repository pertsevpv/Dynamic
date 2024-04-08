package dynamic.semantic.expr.op;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class UnOperation extends Expr {

  public Expr expr;
  public OpType opType;

  public UnOperation(Expr expr, OpType type) {
    super(expr.span);
    this.expr = expr;
    this.opType = type;
  }

  public enum OpType {
    MINUS("-"), PLUS("+"), NOT("not");

    final String sign;
    OpType(String sign) {
      this.sign = sign;
    }

    @Override
    public String toString() {
      return sign;
    }
  }

}
