package dynamic.semantic.entity.expr.fun;

import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;

import java.util.List;

public abstract class Func extends Expr {

  public List<Parameter> params;

  public Func(List<Parameter> params, Span span) {
    super(span);
    this.params = params;
  }
}
