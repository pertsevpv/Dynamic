package dynamic.interpret;

import dynamic.exception.DynaRuntimeError;
import dynamic.interpret.obj.DynaObject;

public class ValueStack {

  public DynaObject[] stack;
  public static final int STACK_SIZE = 1 << 10;
  public int stackPtr;

  public ValueStack() {
    stack = new DynaObject[STACK_SIZE];
    stackPtr = 0;
  }

  public void push(DynaObject obj) {
    if (stackPtr >= stack.length) throw new DynaRuntimeError("Stack overflow");
    stack[stackPtr++] = obj;
  }

  public DynaObject pop() {
    if (stackPtr - 1 < 0) throw new DynaRuntimeError("Stack underflow");
    var obj = stack[stackPtr - 1];
    stack[--stackPtr] = null;
    return obj;
  }
}
