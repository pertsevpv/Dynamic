package dynamic.semantic.entity.expr.fun;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

import java.util.List;

public class ExprFunc extends Func {

  public Expr expr;

  public ExprFunc(List<Parameter> params, Expr expr, Span span) {
    super(params, span);
    this.expr = expr;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var p: params) p.validate(context);
    context.enterScope();
    for (var p: params) context.putDeclaration(p);
    expr.validate(context);
    context.exitScope();
  }
}
