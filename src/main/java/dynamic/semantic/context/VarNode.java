package dynamic.semantic.context;

import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.statement.Declaration;

public class VarNode {

  public Declaration initialDeclaration;
  public Expr currentExpression;
  public Type currentType;

  public VarNode(Declaration initialDeclaration, Expr currentExpression, Type currentType) {
    this.initialDeclaration = initialDeclaration;
    this.currentExpression = currentExpression;
    this.currentType = currentType;
  }
}
