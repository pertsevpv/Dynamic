package dynamic.semantic.entity.expr.ref;

import dynamic.exception.ValidationException;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

public class ArrayCall extends Call {

  public Expr expr;

  public ArrayCall(Reference ref, Expr expr) {
    super(ref);
    this.ref = ref;
    this.expr = expr;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    CheckUtils.checkTypes(Type.ARRAY, ref);
    expr.validate(context);
    CheckUtils.checkTypes(Type.INT, ref);
  }
}
