package dynamic.semantic.entity.expr.fun;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Block;
import dynamic.semantic.Span;

import java.util.List;

public class BlockFunc extends Func {

  public Block block;

  public BlockFunc(List<Parameter> params, Block block, Span span) {
    super(params, span);
    this.block = block;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var p: params) p.validate(context);
    context.enterScope();
    for (var p: params) context.putDeclaration(p);
    block.validate(context);
    context.exitScope();
  }
}
