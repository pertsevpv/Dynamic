package dynamic.semantic.entity.expr.op;

import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class UnOperation extends Expr {

  public Expr expr;
  public OpType opType;

  public UnOperation(Expr expr, OpType type) {
    super(expr.span);
    this.expr = expr;
    this.opType = type;
  }

  @Override
  public void validate(ValidationContext context) {

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
