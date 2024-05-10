package dynamic.interpret.obj;

import dynamic.exception.DynaRuntimeException;
import dynamic.interpret.Memory;
import dynamic.semantic.Type;
import dynamic.utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DynaTuple extends DynaObject {

  // string label can be null
  public List<Pair<String, Integer>> tuple;

  public DynaTuple(List<Pair<String, Integer>> tuple) {
    super(Type.TUPLE);
    this.tuple = tuple;
  }

  public static List<Pair<String, Integer>> plus(List<Pair<String, Integer>> a, List<Pair<String, Integer>> b) {
    var result = new ArrayList<>(a);
    for (var p2 : b) {
      if (containLabel(result, p2.first)) throw new DynaRuntimeException();
      result.add(p2);
    }
    return result;
  }

  public int size() {
    return tuple.size();
  }

  public int getObj(int i) {
    if (i < 0 || i >= tuple.size()) throw new DynaRuntimeException();
    return tuple.get(i).second;
  }

  public int getObj(String label) {
    return tuple.stream()
        .filter(it -> it.first.equals(label))
        .findFirst()
        .orElseThrow(DynaRuntimeException::new)
        .second;
  }

  public void writeLabel(String label, int newAddr) {
    tuple.stream()
        .filter(it -> it.first.equals(label))
        .findFirst()
        .orElseThrow()
        .second = newAddr;
  }

  public void writePos(int pos, int newAddr) {
    if (pos < 0 || pos >= tuple.size()) throw new DynaRuntimeException();
    tuple.get(pos).second = newAddr;
  }

  public static boolean containLabel(List<Pair<String, Integer>> tuple, String label) {
    return tuple.stream().anyMatch(it -> Objects.equals(it.first, label));
  }

  @Override
  public String asStr(Memory memory) {
    return tuple.stream()
        .map(it -> new Pair<>(it.first, memory.get(it.second)))
        .map(it -> asStr(it, memory))
        .collect(Collectors.joining(", ", "{", "}"));
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    if (!(other instanceof DynaTuple otherTuple)) return false;
    if (otherTuple.tuple.size() != tuple.size()) return false;
    for (int i = 0; i < tuple.size(); i++) {
      var elem = tuple.get(i);
      var otherElem = otherTuple.tuple.get(i);
      if (!Objects.equals(elem.first, otherElem.first)) return false;
      if (!memory.get(elem.second).eq(memory.get(otherElem.second), memory)) return false;
    }
    return true;
  }

  private String asStr(Pair<String, DynaObject> pair, Memory memory) {
    if (pair.first == null) return pair.second.asStr(memory);
    else return String.format("%s := %s", pair.first, pair.second.asStr(memory));
  }
}
