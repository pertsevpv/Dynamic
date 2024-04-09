package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;

public class Return extends Statement {

  public Expr expr;

  public Return(Span span) {
    this(null, span);
  }

  public Return(Expr expr, Span span) {
    super(span);
    this.expr = expr;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    if (expr != null) expr.validate(context);
  }
}
