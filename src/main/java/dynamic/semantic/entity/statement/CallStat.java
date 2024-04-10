package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.ref.FunctionCall;

public class CallStat extends Statement {

  public FunctionCall call;

  public CallStat(FunctionCall call) {
    super(call.span);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
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
}
