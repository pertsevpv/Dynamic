package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;

public class BoolConst extends Const<Boolean> {
  public BoolConst(Boolean value, Span span) {
    super(value, Type.BOOL, span);
  }
}
