package dynamic.semantic.entity.expr.ref;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.utils.CheckUtils;

public class IdRef extends Reference {

  public Id id;

  public IdRef(Id id) {
    super(id.span);
    this.id = id;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    CheckUtils.checkVarDeclared(id, context);
    var expr = context.getExpr(id.name);
    if (expr != null) this.type = expr.type;
  }
}
