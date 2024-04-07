package dynamic.semantic.expr.ref;

import dynamic.semantic.Id;
import dynamic.semantic.Span;

public class DotCall extends Reference {
  public Reference ref;
  public Id id;

  public DotCall(Reference ref, Id id) {
    super(ref.span);
    this.ref = ref;
    this.id = id;
  }
}
