package dynamic.semantic.entity.statement;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaEmpty;
import dynamic.interpret.obj.DynaInteger;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Block;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.fun.Parameter;
import dynamic.utils.CheckUtils;

import java.math.BigInteger;

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
    CheckUtils.checkVarNotDeclared(param.name, context);

    from.validate(context);
    CheckUtils.checkTypes(Type.INT, from);

    to.validate(context);
    CheckUtils.checkTypes(Type.INT, to);

    context.enterScope();
    context.putDeclaration(param);
    block.validate(context);
    context.exitScope();
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("for ")
        .append(param.name)
        .append(" in ");
    from.print(depth, sb);
    sb.append("..");
    to.print(depth, sb);
    sb.append(" ")
        .append("loop\n");
    block.print(depth, sb);
    sb.append("  ".repeat(depth))
        .append("end");
  }

  @Override
  public Statement optimize() {
    return new For(param.optimize(), from.optimize(), to.optimize(), block.optimize(), span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    from.execute(memory, valueStack, stackFrame);
    var fromObj = valueStack.pop();
    if (!(fromObj instanceof DynaInteger fromInt))
      throw new DynaRuntimeException(from.span, "For borders must be integers");

    to.execute(memory, valueStack, stackFrame);
    var toObj = valueStack.pop();
    if (!(toObj instanceof DynaInteger toInt))
      throw new DynaRuntimeException(to.span, "For borders must be integers");

    int pAddr = memory.alloc(new DynaEmpty());
    stackFrame.put(param.name.name, pAddr);
    stackFrame.enterScope();

    BigInteger i = fromInt.value;
    while (i.compareTo(toInt.value) < 0) {
      var paramObj = new DynaInteger(i);
//      memory.write(pAddr, paramObj);
      stackFrame.rewrite(param.name.name, paramObj.memoryAddress);
      block.execute(memory, valueStack, stackFrame);
      i = i.add(BigInteger.valueOf(1));
    }
    stackFrame.exitScope();
  }
}
