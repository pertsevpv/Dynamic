package dynamic.semantic.statement;

import dynamic.semantic.Span;
import dynamic.semantic.Validatable;

public abstract class Statement implements Validatable {

  public Span span;

  public Statement(Span span) {
    this.span = span;
  }
}
