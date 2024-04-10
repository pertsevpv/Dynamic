package dynamic.semantic.entity.expr.ref;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.expr.Expr;

public class DotCall extends Call {
  public Id id;

  public DotCall(Reference ref, Id id) {
    super(ref);
    this.ref = ref;
    this.id = id;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    ref.print(depth, sb);
    sb.append(".").append(id);
  }

  @Override
  public Expr optimize() {
    return new DotCall(ref, id);
  }
}
