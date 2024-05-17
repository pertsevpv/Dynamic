package dynamic.semantic.entity.expr.ref;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaEmpty;
import dynamic.interpret.obj.DynaFunc;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Optimizable;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.fun.Func;
import dynamic.utils.CheckUtils;

import java.util.List;

public class FunctionCall extends Call {

  public List<Expr> params;

  public FunctionCall(Reference ref, List<Expr> params) {
    super(ref);
    this.params = params;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    for (var p: params) p.validate(context);

    if (ref instanceof IdRef idRef) {
      CheckUtils.checkVarDeclared(idRef.id, context);
      var expr = context.getExpr(idRef.id.name);
      CheckUtils.checkTypes(Type.FUNC, expr);
      if (expr instanceof Func func) {
        if (func.params.size() != params.size()) {
          throw new ValidationException(span,
              String.format("Wrong number of params for function call %s: expected %s, got %s",
                  this, func.params.size(), params.size())
          );
        }
      }
    }
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    ref.print(depth, sb);
    sb.append("(");
    if (!params.isEmpty()) {
      params.get(0).print(depth, sb);
      for (int i = 1; i < params.size(); i++)
        params.get(i).print(depth, sb.append(", "));
    }
    sb.append(")");
  }

  @Override
  public FunctionCall optimize() {
    var optimizedParams = params.stream().map(Optimizable::optimize).toList();
    return new FunctionCall(ref, optimizedParams);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    super.execute(memory, valueStack, stackFrame);
    var refObj = valueStack.pop();
    if (!(refObj instanceof DynaFunc refFunc))
      throw new DynaRuntimeException(ref.span, "Trying to call not a function");

    var toReturn = new DynaEmpty();
    memory.create(toReturn);

    for (var p: params) p.execute(memory, valueStack, stackFrame);

    StackFrame frame = new StackFrame(stackFrame, toReturn.memoryAddress);

    refFunc.visibleVars.forEach(frame::put);

    refFunc.func.call(memory, valueStack, frame);
    valueStack.push(memory.get(toReturn.memoryAddress));
  }

  @Override
  public void onAssign(int newAddr, StackFrame stackFrame) {
    throw new DynaRuntimeException(ref.span, "Can't assign function call");
  }
}
