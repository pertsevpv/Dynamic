package dynamic.semantic.entity.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class RealConst extends Const<Double>{
  public RealConst(Double value, Span span) {
    super(value, Type.REAL, span);
  }

  @Override
  public void validate(ValidationContext context) {
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(value);
  }

  @Override
  public Expr optimize() {
    return new RealConst(value, span);
  }
}
