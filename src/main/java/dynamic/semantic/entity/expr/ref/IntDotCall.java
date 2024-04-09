package dynamic.semantic.entity.expr.ref;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Type;
import dynamic.utils.CheckUtils;

public class IntDotCall extends Call {
  public int label;

  public IntDotCall(Reference ref, int label) {
    super(ref);
    this.ref = ref;
    this.label = label;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    CheckUtils.checkTypes(Type.TUPLE, ref);
  }
}
