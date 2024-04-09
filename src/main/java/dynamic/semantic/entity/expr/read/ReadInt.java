package dynamic.semantic.entity.expr.read;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;

public class ReadInt extends Read<Integer> {
  public ReadInt(Span span) {
    super(span);
  }

  @Override
  public void validate(ValidationContext context) {
    this.type = Type.INT;
  }
}
