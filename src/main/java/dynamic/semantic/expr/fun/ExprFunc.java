package dynamic.semantic.expr.fun;

import dynamic.semantic.Id;
import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

import java.util.List;

public class ExprFunc extends Expr {

  public List<Id> params;
  public Expr expr;

  public ExprFunc(List<Id> params, Expr expr, Span span) {
    super(span);
    this.params = params;
    this.expr = expr;
  }
}
