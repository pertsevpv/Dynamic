package dynamic.semantic.entity.expr.ref;

import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;

public abstract class Call extends Reference {

  public Reference ref;

  public Call(Reference ref) {
    super(ref.span);
    this.ref = ref;
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    ref.execute(memory, valueStack, stackFrame);
  }
}
