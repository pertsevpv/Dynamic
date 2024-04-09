package dynamic.semantic.entity.statement;

import dynamic.semantic.Span;
import dynamic.semantic.entity.Validatable;

public abstract class Statement implements Validatable {

  public Span span;
  public boolean isReachable = true;

  public Statement(Span span) {
    this.span = span;
  }
}
