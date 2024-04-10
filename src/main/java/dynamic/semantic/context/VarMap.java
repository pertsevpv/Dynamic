package dynamic.semantic.context;

import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.statement.Assignment;
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
    var info = new VarNode(decl);
    String name = decl.name.name;
    varToInfo.put(name, info);
    unusedVars.add(name);
  }

  public void markUnused() {
    for (var name: unusedVars) markUnused(name, null);
  }

  private void markUnused(String name, Assignment assignment) {
    var decl = varToInfo.get(name);
    if (decl.lastAssignment != null) {
      System.out.format("%s last assigment of %s is rewrote without usage\n", decl.lastAssignment.span, name);
      decl.lastAssignment.isReassigned = true;
    } else if (decl.getExpr() != null) {
      if (assignment != null) {
        System.out.format("%s var decl of %s is rewrote without usage\n", decl.initialDeclaration.span, name);
        decl.initialDeclaration.firstRewroteAssignment = assignment;
      } else {
        System.out.format("%s var decl of %s is unused\n", decl.initialDeclaration.span, name);
        decl.initialDeclaration.isVariableUsed = false;
      }
    }
  }

  public boolean containDecl(String name) {
    if (varToInfo.containsKey(name)) {
      return true;
    } else if (parent != null) return parent.containDecl(name);
    return false;
  }

  public boolean containDeclInCurScope(String name) {
    return varToInfo.containsKey(name);
  }

  private VarNode get(String name) {
    if (varToInfo.containsKey(name)) {
      unusedVars.remove(name);
      return varToInfo.get(name);
    } else if (parent != null) return parent.get(name);
    return null;
  }

  public Expr getExpr(String name) {
    var info = get(name);
    if (info == null) return null;
    return info.getExpr();
  }

  public VarNode rewriteVar(String name) {
    if (varToInfo.containsKey(name)) {
      return varToInfo.get(name);
    } else if (parent != null) return parent.get(name);
    return null;
  }

  public void rewriteVar(String name, Assignment assignment) {
    VarNode info;
    if (varToInfo.containsKey(name)) {
      if (unusedVars.contains(name)) markUnused(name, assignment);
      else unusedVars.add(name);
      info = varToInfo.get(name);
    } else info = rewriteVar(name);

    if (info == null) throw new IllegalArgumentException();
    info.lastAssignment = assignment;
  }
}
