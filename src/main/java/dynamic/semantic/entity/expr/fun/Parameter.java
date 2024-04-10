package dynamic.semantic.entity.expr.fun;

import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.statement.Declaration;
import dynamic.semantic.entity.statement.Statement;

public class Parameter extends Declaration {

  public Parameter(Id id) {
    super(id, id.span);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(name);
  }

  @Override
  public Parameter optimize() {
    return new Parameter(name);
  }
}
