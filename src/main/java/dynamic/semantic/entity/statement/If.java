package dynamic.semantic.entity.statement;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaBool;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Block;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

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
  public void validate(ValidationContext context) throws ValidationException {
    cond.validate(context);
    CheckUtils.checkTypes(Type.BOOL, cond);

    context.enterScope();
    ifBlock.validate(context);
    context.exitScope();

    if (elseBlock != null) {
      context.enterScope();
      elseBlock.validate(context);
      context.exitScope();
    }
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("if ");
    cond.print(depth, sb);
    sb.append(" then\n");
    ifBlock.print(depth, sb);
    if (elseBlock != null) {
      sb.append("  ".repeat(depth)).append("else\n");
      elseBlock.print(depth, sb);
    }
    sb.append("  ".repeat(depth)).append("end");
  }

  @Override
  public Statement optimize() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    cond.execute(memory, valueStack, stackFrame);
    var condObj = valueStack.pop();
    if (!(condObj instanceof DynaBool condBool)) throw new DynaRuntimeException();

    stackFrame.enterScope();
    if (condBool.value) {
      ifBlock.execute(memory, valueStack, stackFrame);
    } else if (elseBlock != null) {
      elseBlock.execute(memory, valueStack, stackFrame);
    }
    stackFrame.exitScope();
  }
}
