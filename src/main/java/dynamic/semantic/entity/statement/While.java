package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Type;
import dynamic.semantic.entity.Block;
import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

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

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    cond.validate(context);
    CheckUtils.checkTypes(Type.BOOL, cond);

    context.enterScope();
    block.validate(context);
    context.exitScope();
  }
}
