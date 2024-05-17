package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;
import dynamic.utils.Pair;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DynaArray extends DynaObject {

  public Map<Integer, Integer> array;

  public DynaArray(Map<Integer, Integer> array) {
    super(Type.ARRAY);
    this.array = array;
  }

  public Stream<Map.Entry<Integer, Integer>> sortedStream() {
    return array.entrySet().stream()
        .sorted(Map.Entry.comparingByKey());
  }

  @Override
  public String asStr(Memory memory) {
    return sortedStream()
        .map(it -> new Pair<>(it.getKey(), memory.get(it.getValue())))
//        .map(it -> String.format("%d -> %s", it.first, it.second.asStr(memory)))
        .map(it -> String.format("%s", it.second.asStr(memory)))
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
