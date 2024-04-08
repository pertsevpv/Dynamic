package dynamic.semantic.statement;

import dynamic.semantic.Block;
import dynamic.semantic.Id;
import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class For extends Statement {

  public Id var;
  public Expr from, to;
  public Block block;

  public For(Id var, Expr from, Expr to, Block block, Span span) {
    super(span);
    this.var = var;
    this.from = from;
    this.to = to;
    this.block = block;
  }
}
