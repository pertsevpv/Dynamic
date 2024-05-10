package dynamic.semantic.entity.expr.ref;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaArray;
import dynamic.interpret.obj.DynaInteger;
import dynamic.interpret.obj.DynaString;
import dynamic.interpret.obj.DynaTuple;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.expr.Expr;

public class DotCall extends Call {
  public Id id;

  private DynaTuple tuple;

  public DotCall(Reference ref, Id id) {
    super(ref);
    this.ref = ref;
    this.id = id;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    ref.print(depth, sb);
    sb.append(".").append(id);
  }

  @Override
  public Expr optimize() {
    return new DotCall(ref, id);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    super.execute(memory, valueStack, stackFrame);
    var refObj = valueStack.pop();

    if (refObj instanceof DynaArray refArray) {
      if (!id.name.equals("length")) throw new DynaRuntimeException();
      valueStack.push(new DynaInteger(refArray.array.size()));
      return;
    }
    if (refObj instanceof DynaString refString) {
      if (!id.name.equals("length")) throw new DynaRuntimeException();
      valueStack.push(new DynaInteger(refString.value.length()));
      return;
    }
    if (!(refObj instanceof DynaTuple refTuple)) throw new DynaRuntimeException();
    this.tuple = refTuple;
    valueStack.push(memory.get(tuple.getObj(id.name)));
  }

  @Override
  public void onAssign(int newAddr, StackFrame stackFrame) {
    tuple.writeLabel(id.name, newAddr);
  }
}
