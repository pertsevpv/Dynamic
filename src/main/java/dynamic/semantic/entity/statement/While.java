package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Type;
import dynamic.semantic.entity.Block;
import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.lit.BoolConst;
import dynamic.semantic.entity.expr.lit.Const;
import dynamic.utils.CheckUtils;

import java.lang.invoke.ConstantBootstraps;

public class While extends Statement {

  public Expr cond;
  public Block block;

  public While(Expr cond, Block block, Span span) {
    super(span);
    this.cond = cond;
    this.block = block;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    cond.validate(context);
    CheckUtils.checkTypes(Type.BOOL, cond);

    context.enterScope();
    block.validate(context);
    context.exitScope();
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth));
    sb.append("while ");
    cond.print(depth, sb);
    sb.append(" loop\n");
    block.print(depth, sb);
    sb.append("  ".repeat(depth)).append("end");
  }

  @Override
  public Statement optimize() {
    var optimizedCond = cond.optimize();
    if (optimizedCond instanceof BoolConst boolConst && !boolConst.value) {
      System.out.format("%s cond in while is const false", span);
      return null;
    }
    return new While(optimizedCond, block.optimize(), span);
  }
}
