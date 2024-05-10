package dynamic.semantic.entity.expr.ref;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.*;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

import java.util.SortedMap;

public class ArrayCall extends Call {

  public Expr expr;

  private SortedMap<Integer, Integer> array;
  private int index;

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
    this.index = indInt.value.intValue();

    if (refObj instanceof DynaArray gotArray) {
      this.array = gotArray.array;

      DynaObject pushObj;
      Integer pushAddr = gotArray.array.get(index);
      if (pushAddr != null) pushObj = memory.get(pushAddr);
      else {
        pushObj = new DynaEmpty();
        memory.alloc(pushObj);
      }
      valueStack.push(pushObj);
    } else if (refObj instanceof DynaString gotString) {
      if (index < 0 || index >= gotString.value.length()) throw new DynaRuntimeException();
      char charCode = gotString.value.charAt(index);
      valueStack.push(new DynaString(String.valueOf(charCode)));
    } else throw new DynaRuntimeException();
  }

  @Override
  public void onAssign(int newAddr, StackFrame stackFrame) {
    array.put(index, newAddr);
  }
}
