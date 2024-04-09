package dynamic.semantic.entity.expr.op;

import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class BiOperation extends Expr {

  public Expr left, right;
  public OpType opType;

  public BiOperation(Expr left, Expr right, OpType opType) {
    super(left.span);
    this.left = left;
    this.right = right;
    this.opType = opType;
  }

  @Override
  public void validate(ValidationContext context) {

  }

  public enum OpType {
    AND("and"), OR("or"), XOR("xor"),
    LE("<"), LE_EQ("<="), EQ("="), NOT_EQ("/="), GR(">"), GR_EQ(">="),
    PLUS("+"), MINUS("-"), DIV("/"), TIMES("*");

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
