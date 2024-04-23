package dynamic.semantic.entity.statement;

import dynamic.interpret.Executable;
import dynamic.semantic.Span;
import dynamic.semantic.entity.Optimizable;
import dynamic.semantic.entity.Printable;
import dynamic.semantic.entity.Validatable;

public abstract class Statement implements Validatable, Printable, Optimizable<Statement>, Executable {

  public Span span;
  public boolean isReachable = true;

  public Statement(Span span) {
    this.span = span;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    print(0, sb);
    return sb.toString();
  }
}
