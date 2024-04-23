package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.ref.FunctionCall;

public class CallStat extends Statement {

  public FunctionCall call;

  public CallStat(FunctionCall call) {
    super(call.span);
    this.call = call;
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth));
    call.print(depth, sb);
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    call.validate(context);
  }

  @Override
  public CallStat optimize() {
    return new CallStat(call.optimize());
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    call.execute(memory, valueStack, stackFrame);
    valueStack.pop();
  }
}
