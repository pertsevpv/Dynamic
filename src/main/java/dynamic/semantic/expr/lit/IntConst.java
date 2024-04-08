package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;

public class IntConst extends Const<Integer> {
  public IntConst(Integer value, Span span) {
    super(value, Type.INT, span);
  }
}
