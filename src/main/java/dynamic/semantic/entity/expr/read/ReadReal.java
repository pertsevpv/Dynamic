package dynamic.semantic.entity.expr.read;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class ReadReal extends Read<Double> {
  public ReadReal(Span span) {
    super(span);
  }

  @Override
  public void validate(ValidationContext context) {
    this.type = Type.REAL;
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("readReal");
  }

  @Override
  public Expr optimize() {
    return new ReadReal(span);
  }
}
