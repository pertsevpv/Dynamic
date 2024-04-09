package dynamic.semantic.context;

import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.statement.Declaration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VarMap {

  public VarMap parent;
  public Map<String, VarNode> varToInfo = new HashMap<>();
  public Set<String> unusedVars = new HashSet<>();

  public VarMap(VarMap parent) {
    this.parent = parent;
  }

  public void putDeclaration(Declaration decl) {
    var info = new VarNode(decl, decl.expression, decl.type);
    String name = decl.name.name;
    varToInfo.put(name, info);
    unusedVars.add(name);
  }

  public void markUnused() {
    for (var v: unusedVars) {
      varToInfo.get(v).initialDeclaration.isVariableUsed = false;
    }
  }

  public boolean containDeclaration(String name) {
    return get(name) != null;
  }

  private VarNode get(String name) {
    if (varToInfo.containsKey(name)) return varToInfo.get(name);
    else if (parent != null) return parent.get(name);
    return null;
  }

  public Declaration getDecl(String name) {
    var info = get(name);
    if (info == null) throw new IllegalArgumentException();
    return info.initialDeclaration;
  }

  public Expr getExpr(String name) {
    var info = get(name);
    if (info == null) return null;
    return info.currentExpression;
  }

  public Type getType(String name) {
    var info = get(name);
    if (info == null) return null;
    return info.currentType;
  }

  public void rewriteVar(String name, Expr newExpr) {
    var info = get(name);
    if (info == null) throw new IllegalArgumentException();
    info.currentExpression = newExpr;
    info.currentType = newExpr.type;
  }
}
