package dynamic.semantic.entity.expr.ref;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Type;
import dynamic.semantic.entity.Id;
import dynamic.utils.CheckUtils;

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
    CheckUtils.checkTypes(Type.TUPLE, ref);
  }
}
