package dynamic.semantic.statement;

import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

import java.util.List;

public class Print extends Statement {

  public List<Expr> exprs;

  public Print(List<Expr> exprs, Span span) {
    super(span);
    this.exprs = exprs;
  }
}
