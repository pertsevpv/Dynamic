package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.expr.Expr;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayConst extends Const<List<Expr>> {

  public ArrayConst(List<Expr> exprs, Span span) {
    super(exprs, Type.ARRAY, span);
  }

  @Override
  public String toString() {
    return value.stream()
        .map(Expr::toString)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}
