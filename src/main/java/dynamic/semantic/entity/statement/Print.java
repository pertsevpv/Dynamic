package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

import java.util.List;

public class Print extends Statement {

  public List<Expr> exprs;

  public Print(List<Expr> exprs, Span span) {
    super(span);
    this.exprs = exprs;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var expr: exprs) expr.validate(context);
  }
}
