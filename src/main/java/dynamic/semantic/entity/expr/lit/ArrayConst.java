package dynamic.semantic.entity.expr.lit;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

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

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var e: value) e.validate(context);
    this.type = Type.ARRAY;
  }
}
