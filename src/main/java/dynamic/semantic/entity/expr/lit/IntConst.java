package dynamic.semantic.entity.expr.lit;

import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaInteger;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class IntConst extends Const<Integer> {

  public IntConst(Integer value, Span span) {
    super(value, Type.INT, span);
  }

  @Override
  public void validate(ValidationContext context) {
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(value);
  }

  @Override
  public Expr optimize() {
    return new IntConst(value, span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    valueStack.push(new DynaInteger(value));
  }
}
