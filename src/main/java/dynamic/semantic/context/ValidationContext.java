package dynamic.semantic.context;

import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.statement.Declaration;

import java.util.Scanner;

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

  public boolean containDeclaration(String name) {
    return varMap.containDeclaration(name);
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
