package dynamic.semantic.statement;

import dynamic.semantic.Block;
import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

public class If extends Statement {

  public Expr cond;
  public Block ifBlock, elseBlock;

  public If(Expr cond, Block ifBlock, Span span) {
    this(cond, ifBlock, null, span);
  }

  public If(Expr cond, Block ifBlock, Block elseBlock, Span span) {
    super(span);
    this.cond = cond;
    this.ifBlock = ifBlock;
    this.elseBlock = elseBlock;
  }

  @Override
  public String toString() {
    if (elseBlock == null) return "if %s then %s".formatted(cond, ifBlock);
    else return "if %s then %s else %s".formatted(cond, ifBlock, elseBlock);
  }
}
