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
  public Set<String> unusedDeclaredVars = new HashSet<>();
  public Set<String> unusedRewroteVars = new HashSet<>();

  public VarMap(VarMap parent) {
    this.parent = parent;
  }

  public void putDeclaration(Declaration decl) {
    var info = new VarNode(decl);
    String name = decl.name.name;
    varToInfo.put(name, info);
    unusedDeclaredVars.add(name);
  }

  public void markUnusedDecl() {
    for (var name: unusedDeclaredVars) markUnusedDecl(name);
    for (var name: unusedRewroteVars) markUnusedRewrite(name);
  }

  private void markUnusedDecl(String name) {
    var decl = varToInfo.get(name);
    System.out.println(String.format("%s var decl of %s is unused", decl.initialDeclaration.span, name));
    decl.initialDeclaration.isVariableUsed = false;
  }

  private void markUnusedRewrite(String name, Assignment assignment) {
    var decl = varToInfo.get(name);
    if (decl.getExpr() != null) {
      if (assignment != null) {
        System.out.println(String.format("%s var %s is rewrote without usage", assignment.span, name));
        if (decl.initialDeclaration.firstRewroteAssignment == null) decl.initialDeclaration.firstRewroteAssignment = assignment;
        assignment.isReassigned = true;
      }
    }
  }

  private void markUnusedRewrite(String name) {
    var decl = varToInfo.get(name);
    Assignment assignment = decl.lastAssignment;
    if (decl.getExpr() != null) {
      if (assignment != null) {
        System.out.println(String.format("%s var %s is rewrote without usage", assignment.span, name));
        decl.initialDeclaration.firstRewroteAssignment = assignment;
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
      unusedDeclaredVars.remove(name);
      return varToInfo.get(name);
    } else if (parent != null) return parent.get(name);
    return null;
  }

  public Expr getExpr(String name) {
    var info = get(name);
    if (info == null) return null;
    return info.getExpr();
  }

  public Declaration getDecl(String name) {
    var info = get(name);
    if (info == null) return null;
    return info.initialDeclaration;
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
      if (unusedDeclaredVars.contains(name)) markUnusedRewrite(name, assignment);
      else unusedRewroteVars.add(name);
      info = varToInfo.get(name);
    } else info = rewriteVar(name);

    if (info == null) throw new IllegalArgumentException();
    info.lastAssignment = assignment;
  }
}
