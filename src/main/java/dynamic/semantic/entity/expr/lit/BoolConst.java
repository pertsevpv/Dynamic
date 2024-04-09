package dynamic.semantic.entity.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;

public class BoolConst extends Const<Boolean> {
  public BoolConst(Boolean value, Span span) {
    super(value, Type.BOOL, span);
  }

  @Override
  public void validate(ValidationContext context) {
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(value);
  }
}
