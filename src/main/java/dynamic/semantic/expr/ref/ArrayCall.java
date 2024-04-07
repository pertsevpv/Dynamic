package dynamic.semantic.expr.ref;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class ArrayCall extends Reference {

  public Reference ref;
  public Expr pos;

  public ArrayCall(Reference ref, Expr pos) {
    super(ref.span);
    this.ref = ref;
    this.pos = pos;
  }
}
