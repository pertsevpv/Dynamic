package dynamic.semantic.entity.expr.read;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class ReadString extends Read<String> {
  public ReadString(Span span) {
    super(span);
  }

  @Override
  public void validate(ValidationContext context) {
    this.type = Type.STRING;
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("readString");
  }

  @Override
  public Expr optimize() {
    return new ReadString(span);
  }
}
