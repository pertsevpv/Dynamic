package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;
import dynamic.utils.Pair;

import java.util.SortedMap;
import java.util.stream.Collectors;

public class DynaArray extends DynaObject {

  public SortedMap<Integer, Integer> array;

  public DynaArray(SortedMap<Integer, Integer> array) {
    super(Type.ARRAY);
    this.array = array;
  }

  @Override
  public String asStr(Memory memory) {
    return array.entrySet()
        .stream()
        .map(it -> new Pair<>(it.getKey(), memory.get(it.getValue())))
        .map(it -> String.format("%d -> %s", it.first, it.second.asStr(memory)))
        .collect(Collectors.joining(", ", "[", "]"));
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    if (!(other instanceof DynaArray otherArray)) return false;
    if (otherArray.array.size() != array.size()) return false;
    for (var elem: array.entrySet()) {
      var otherElem = otherArray.array.get(elem.getKey());
      if (otherElem == null) return false;
      if (!memory.get(elem.getValue()).eq(memory.get(otherElem), memory)) return false;
    }
    return true;
  }
}
