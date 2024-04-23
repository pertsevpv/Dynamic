package dynamic.semantic.entity.expr;

import dynamic.interpret.Executable;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaEmpty;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.entity.Optimizable;
import dynamic.semantic.entity.Printable;
import dynamic.semantic.entity.Validatable;

public abstract class Expr implements Validatable, Printable, Optimizable<Expr>, Executable {

  public Span span;
  public Type type;

  public Expr(Span span) {
    this.span = span;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    print(0, sb);
    return sb.toString();
  }
}
