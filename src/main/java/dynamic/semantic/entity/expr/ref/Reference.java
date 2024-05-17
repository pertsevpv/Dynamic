package dynamic.semantic.entity.expr.ref;

import dynamic.interpret.StackFrame;
import dynamic.semantic.Span;
import dynamic.semantic.entity.expr.Expr;

public abstract class Reference extends Expr {
  public Reference(Span span) {
    super(span);
  }

  public abstract void onAssign(int newAddr, StackFrame stackFrame);
}
