package dynamic.semantic.expr.ref;

import dynamic.semantic.expr.Expr;

import java.util.List;

public class FunctionCall extends Reference {

  public Reference ref;
  public List<Expr> params;

  public FunctionCall(Reference ref, List<Expr> params) {
    super(ref.span);
    this.ref = ref;
    this.params = params;
  }
}
