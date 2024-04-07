package dynamic.semantic.expr.lit;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

import java.util.List;
import java.util.stream.Collectors;

public class Array extends Expr {

  public List<Expr> exprs;

  public Array(List<Expr> exprs, Span span) {
    super(span);
    this.exprs = exprs;
  }

  @Override
  public String toString() {
    return exprs.stream()
        .map(Expr::toString)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}
