package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Type;
import dynamic.semantic.entity.Block;
import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.fun.Parameter;
import dynamic.utils.CheckUtils;

public class For extends Statement {

  public Parameter param;
  public Expr from, to;
  public Block block;

  public For(Parameter param, Expr from, Expr to, Block block, Span span) {
    super(span);
    this.param = param;
    this.from = from;
    this.to = to;
    this.block = block;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    CheckUtils.checkVarDeclared(param.name, context);

    from.validate(context);
    CheckUtils.checkTypes(Type.INT, from);

    to.validate(context);
    CheckUtils.checkTypes(Type.INT, to);

    context.enterScope();
    context.putDeclaration(param);
    block.validate(context);
    context.exitScope();
  }
}
