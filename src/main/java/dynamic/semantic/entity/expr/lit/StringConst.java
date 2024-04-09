package dynamic.semantic.entity.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;

public class StringConst extends Const<String> {
  public StringConst(String value, Span span) {
    super(value, Type.STRING, span);
  }

  @Override
  public void validate(ValidationContext context) {
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(value);
  }
}
