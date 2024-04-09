package dynamic.semantic.entity.expr.op;

import dynamic.exception.ValidationException;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.Pair;
import dynamic.utils.TypeUtils;

import java.util.ArrayList;
import java.util.List;

public class UnOperation extends Expr {

  public Expr expr;
  public OpType opType;

  public UnOperation(Expr expr, OpType type) {
    super(expr.span);
    this.expr = expr;
    this.opType = type;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    expr.validate(context);
    this.type = TypeUtils.checkUnOpType(span, expr.type, opType);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(opType.sign).append("(");
    expr.print(depth, sb);
    sb.append(")");
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
