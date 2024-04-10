package dynamic.semantic.context;

import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.statement.Assignment;
import dynamic.semantic.entity.statement.Declaration;

public class VarNode {

  public Declaration initialDeclaration;
  public Assignment lastAssignment;

  public VarNode(Declaration initialDeclaration) {
    this.initialDeclaration = initialDeclaration;
  }

  public Expr getExpr() {
    if (lastAssignment != null) return lastAssignment.expression;
    else return initialDeclaration.expression;
  }
}
