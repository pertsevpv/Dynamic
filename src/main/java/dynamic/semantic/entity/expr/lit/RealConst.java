package dynamic.semantic.entity.expr.lit;

import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaReal;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class RealConst extends Const<Double>{
  public RealConst(Double value, Span span) {
    super(value, Type.REAL, span);
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
    return new RealConst(value, span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    valueStack.push(new DynaReal(value));
  }
}
