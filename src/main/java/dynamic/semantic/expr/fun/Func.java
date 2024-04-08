package dynamic.semantic.expr.fun;

import dynamic.semantic.Block;
import dynamic.semantic.Id;
import dynamic.semantic.Span;
import dynamic.semantic.expr.Expr;

import java.util.List;

public class Func extends Expr {

  public List<Id> params;
  public Block block;

  public Func(List<Id> params, Block block, Span span) {
    super(span);
    this.params = params;
    this.block = block;
  }
}
