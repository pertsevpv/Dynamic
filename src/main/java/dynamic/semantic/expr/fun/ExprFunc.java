package dynamic.semantic.expr.fun;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

import java.util.List;

public class ExprFunc extends Expr {

  public List<String> params;
  public Expr expr;

  public ExprFunc(List<String> params, Expr expr, Span span) {
    super(span);
    this.params = params;
    this.expr = expr;
  }
}
