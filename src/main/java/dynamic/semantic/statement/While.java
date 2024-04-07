package dynamic.semantic.statement;

import dynamic.semantic.Block;
import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class While extends Statement {

  public Expr cond;
  public Block block;

  public While(Expr cond, Block block, Span span) {
    super(span);
    this.cond = cond;
    this.block = block;
  }

  @Override
  public String toString() {
    return "while %s %s".formatted(cond, block);
  }
}
