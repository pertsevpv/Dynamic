package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

import java.util.List;
import java.util.stream.Collectors;

public class Print extends Statement {

  public List<Expr> exprs;

  public Print(List<Expr> exprs, Span span) {
    super(span);
    this.exprs = exprs;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var expr: exprs) expr.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("print(")
        .append(exprs.stream().map(Expr::toString).collect(Collectors.joining(", ")))
        .append(")\n");
  }
}
