package dynamic.semantic.entity.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;

public class IntConst extends Const<Integer> {
  public IntConst(Integer value, Span span) {
    super(value, Type.INT, span);
  }

  @Override
  public void validate(ValidationContext context) {
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(value);
  }
}
