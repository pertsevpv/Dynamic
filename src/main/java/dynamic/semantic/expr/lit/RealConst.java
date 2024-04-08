package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;

public class RealConst extends Const<Double>{
  public RealConst(Double value, Span span) {
    super(value, Type.REAL, span);
  }
}
