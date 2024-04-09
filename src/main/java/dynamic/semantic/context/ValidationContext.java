package dynamic.semantic.context;

import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.statement.Declaration;

public class ValidationContext {

  public VarMap varMap = new VarMap(null);

  public void enterScope() {
    varMap = new VarMap(varMap);
  }

  public void exitScope() {
    varMap = varMap.parent;
  }

  public void putDeclaration(Declaration declaration) {
    varMap.putDeclaration(declaration);
  }

  public Declaration getDeclaration(String name) {
    return varMap.getDecl(name);
  }

  public boolean containDecl(String name) {
    return varMap.containDecl(name);
  }

  public boolean containDeclInCurScope(String name) {
    return varMap.containDeclInCurScope(name);
  }

  public Expr getExpr(String name) {
    return varMap.getExpr(name);
  }

  public Type getType(String name) {
    return varMap.getType(name);
  }

  public void rewriteVar(String name, Expr expr) {
    varMap.rewriteVar(name, expr);
  }
}
