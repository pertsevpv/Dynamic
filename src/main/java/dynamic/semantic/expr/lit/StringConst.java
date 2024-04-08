package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;

public class StringConst extends Const<String> {
  public StringConst(String value, Span span) {
    super(value, Type.STRING, span);
  }
}
