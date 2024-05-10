package dynamic.semantic.entity.expr.ref;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaTuple;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

public class IntDotCall extends Call {
  public int label;
  private DynaTuple tuple;

  public IntDotCall(Reference ref, int label) {
    super(ref);
    this.ref = ref;
    this.label = label;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    CheckUtils.checkTypes(Type.TUPLE, ref);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    ref.print(depth, sb);
    sb.append(".").append(label);
  }

  @Override
  public Expr optimize() {
    return new IntDotCall(ref, label);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    super.execute(memory, valueStack, stackFrame);
    var refObj = valueStack.pop();

    if (!(refObj instanceof DynaTuple refTuple)) throw new DynaRuntimeException();
    valueStack.push(memory.get(refTuple.getObj(label)));
  }

  @Override
  public void onAssign(int newAddr, StackFrame stackFrame) {
    tuple.writePos(label, newAddr);
  }
}
