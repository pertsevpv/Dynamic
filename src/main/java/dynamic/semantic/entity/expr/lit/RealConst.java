package dynamic.semantic.entity.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;

public class RealConst extends Const<Double>{
  public RealConst(Double value, Span span) {
    super(value, Type.REAL, span);
  }

  @Override
  public void validate(ValidationContext context) {
    this.type = Type.REAL;
  }
}
