package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;

public class Return extends Statement {

  public Expr expr;

  public Return(Span span) {
    this(null, span);
  }

  public Return(Expr expr, Span span) {
    super(span);
    this.expr = expr;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    if (expr != null) expr.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("return");
    if (expr != null) expr.print(depth, sb.append(" "));
  }

  @Override
  public Statement optimize() {
    if (expr == null) return new Return(span);
    else return new Return(expr.optimize(), span);
  }
}
