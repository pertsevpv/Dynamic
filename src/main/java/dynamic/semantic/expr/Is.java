package dynamic.semantic.expr;

import dynamic.semantic.Type;
import dynamic.semantic.expr.ref.Reference;

public class Is extends Expr {

  public Reference ref;
  public Type isType;

  public Is(Reference ref, Type isType) {
    super(ref.span);
    this.ref = ref;
    this.isType = isType;
  }
}
