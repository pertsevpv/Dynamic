package dynamic.semantic.expr.op;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class BiOperation extends Expr {

  public Expr left, right;

  public BiOperation(Expr left, Expr right, Span span) {
    super(span);
    this.left = left;
    this.right = right;
  }

  enum Type {
    AND("and"), OR("or"), XOR("xor"),
    LE("<"), LE_EQ("<="), EQ("="), NOT_EQ("/="), GR(">"), GR_EQ(">="),
    PLUS("+"), MINUS("-");

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
