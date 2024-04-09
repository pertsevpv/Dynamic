package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.ref.IdRef;
import dynamic.semantic.entity.expr.ref.Reference;
import dynamic.utils.CheckUtils;

public class Assignment extends Statement {

  public Reference reference;
  public Expr expression;

  public Assignment(Reference reference, Expr expression) {
    super(reference.span);
    this.reference = reference;
    this.expression = expression;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    reference.validate(context);
    expression.validate(context);

    if (reference instanceof IdRef idRef) {
      CheckUtils.checkVarDeclared(idRef.id, context);
      context.rewriteVar(idRef.id.name, expression);
    }
  }
}
