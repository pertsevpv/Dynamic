package dynamic.semantic.entity.expr;

import dynamic.exception.ValidationException;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.ref.Reference;

public class Is extends Expr {

  public Reference ref;
  public Type isType;

  public Is(Reference ref, Type isType) {
    super(ref.span);
    this.ref = ref;
    this.isType = isType;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    this.type = Type.BOOL;
  }

  @Override
  public String toString() {
    return "%s ";
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    ref.print(depth, sb);
    sb.append(" is ").append(isType);
  }
}
