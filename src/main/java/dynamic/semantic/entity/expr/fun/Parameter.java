package dynamic.semantic.entity.expr.fun;

import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.statement.Declaration;

public class Parameter extends Declaration {

  public Parameter(Id id) {
    super(id, id.span);
  }
}
