package dynamic.semantic.expr.op;

import dynamic.semantic.expr.Expr;

public class BiOperation extends Expr {

  public Expr left, right;

  public BiOperation(Expr left, Expr right, OpType opType) {
    super(left.span);
    this.left = left;
    this.right = right;
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
