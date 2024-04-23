package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.interpret.Scope;
import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.fun.Func;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DynaFunc extends DynaObject {

  public final Func func;
  public final Map<String, Integer> visibleVars;

  public DynaFunc(Func func, Scope scope) {
    super(Type.FUNC);
    this.func = func;
    visibleVars = new HashMap<>();
    while (scope != null) {
      visibleVars.putAll(scope);
      scope = scope.parent;
    }
  }

  @Override
  public String asStr(Memory memory) {
    return "func(%s)".formatted(
        func.params.stream()
            .map(p -> p.name.name)
            .collect(Collectors.joining(", "))
    );
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    return refEq(other);
  }
}
