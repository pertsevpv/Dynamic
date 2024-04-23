package dynamic.semantic.entity.expr.fun;

import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaFunc;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;

import java.util.List;

public abstract class Func extends Expr {

  public List<Parameter> params;

  public Func(List<Parameter> params, Span span) {
    super(span);
    this.params = params;
    this.type = Type.FUNC;
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    valueStack.push(new DynaFunc(this, stackFrame.scope));
  }

  public void call(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    for (int i = params.size() - 1; i >= 0; i--) {
      var param = params.get(i);
      var arg = valueStack.pop();
      if (arg.isNotAllocated()) memory.alloc(arg);
      stackFrame.put(param.name.name, arg.memoryAddress);
    }
  }
}
