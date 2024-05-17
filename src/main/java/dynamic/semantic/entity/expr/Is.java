package dynamic.semantic.entity.expr;

import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaBool;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.lit.BoolConst;
import dynamic.semantic.entity.expr.lit.Const;
import dynamic.semantic.entity.expr.ref.IdRef;
import dynamic.semantic.entity.expr.ref.Reference;

public class Is extends Expr {

  public Reference ref;
  public Type isType;

  public Is(Reference ref, Type isType) {
    super(ref.span);
    this.ref = ref;
    this.isType = isType;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    ref.validate(context);
    this.type = Type.BOOL;
  }

  @Override
  public String toString() {
    return "%s ";
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    ref.print(depth, sb);
    sb.append(" is ").append(isType);
  }

  @Override
  public Expr optimize() {
    var optRef = ref.optimize();
    if (optRef instanceof Const<?> aConst) return new BoolConst(aConst.type == isType, span);
    return new Is(ref, isType);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    ref.execute(memory, valueStack, stackFrame);
    var obj = valueStack.pop();
    valueStack.push(new DynaBool(obj.type == isType));
  }
}
