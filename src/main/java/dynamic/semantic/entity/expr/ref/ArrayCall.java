package dynamic.semantic.entity.expr.ref;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Context;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.*;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

import java.math.BigInteger;

public class ArrayCall extends Call {

  public Expr expr;

  public ArrayCall(Reference ref, Expr expr) {
    super(ref);
    this.expr = expr;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    CheckUtils.checkTypes(Type.ARRAY, ref);
    expr.validate(context);
    CheckUtils.checkTypes(Type.INT, expr);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    ref.print(depth, sb);
    expr.print(depth, sb.append("["));
    sb.append("]");
  }

  @Override
  public Expr optimize() {
    return new ArrayCall(ref, expr.optimize());
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    super.execute(memory, valueStack, stackFrame);
    expr.execute(memory, valueStack, stackFrame);
    var indObj = valueStack.pop();
    var refObj = valueStack.pop();

    if (!(indObj instanceof DynaInteger indInt)) throw new DynaRuntimeException();

    int index = indInt.value.intValueExact();

    if (refObj instanceof DynaArray gotArray) {
      DynaObject pushObj;
      Integer pushAddr = gotArray.array.get(index);
      if (pushAddr == null) {
        pushObj = new DynaEmpty();
        if (Context.isLeftRefCall)gotArray.array.put(index, memory.alloc(pushObj));
      } else pushObj = memory.get(pushAddr);
      valueStack.push(pushObj);
    } else if (refObj instanceof DynaString gotString) {
      if (index < 0 || index >= gotString.value.length()) throw new DynaRuntimeException();
      char charCode = gotString.value.charAt(index);
      valueStack.push(new DynaString(String.valueOf(charCode)));
    } else throw new DynaRuntimeException();
  }
}
