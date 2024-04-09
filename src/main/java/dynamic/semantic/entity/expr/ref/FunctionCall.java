package dynamic.semantic.entity.expr.ref;

import dynamic.exception.ValidationException;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.fun.Func;
import dynamic.utils.CheckUtils;

import java.util.List;

public class FunctionCall extends Call {

  public List<Expr> params;

  public FunctionCall(Reference ref, List<Expr> params) {
    super(ref);
    this.params = params;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    for (var p: params) p.validate(context);

    if (ref instanceof IdRef idRef) {
      CheckUtils.checkVarDeclared(idRef.id, context);
      var type = context.getType(idRef.id.name);
      var expr = context.getExpr(idRef.id.name);
      CheckUtils.checkTypes(Type.FUNC, type, span);
      CheckUtils.checkTypes(Type.FUNC, expr);
      if (expr instanceof Func func) {
        if (func.params.size() != params.size()) {
          System.out.format("Wrong number of params for function call %s at %s: expected %s, got %s",
              this, span, func.params.size(), params.size());
        }
      }
    }
  }
}
