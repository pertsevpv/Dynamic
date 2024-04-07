package dynamic.semantic.expr.ref;

import dynamic.semantic.Id;

public class IdRef extends Reference {

  public Id id;

  public IdRef(Id id) {
    super(id.span);
    this.id = id;
  }
}
