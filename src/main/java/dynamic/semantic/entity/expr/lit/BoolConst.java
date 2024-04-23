package dynamic.semantic.entity.expr.lit;

import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaBool;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class BoolConst extends Const<Boolean> {
  public BoolConst(Boolean value, Span span) {
    super(value, Type.BOOL, span);
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
    return new BoolConst(value, span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    valueStack.push(new DynaBool(value));
  }
}
