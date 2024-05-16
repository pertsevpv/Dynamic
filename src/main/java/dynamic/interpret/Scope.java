package dynamic.interpret;

import dynamic.exception.DynaRuntimeError;

import java.util.HashMap;

public class Scope extends HashMap<String, Integer> {

  public Scope parent;

  public Scope(Scope parent) {
    this.parent = parent;
  }

  public int getAddress(String symbol) {
    var addr = get(symbol);
    if (addr != null) return addr;
    if (parent == null) return -1;
    return parent.getAddress(symbol);
  }

  public void rewrite(String varName, int memoryAddress) {
    if (containsKey(varName)) put(varName, memoryAddress);
    else if (parent != null) parent.rewrite(varName, memoryAddress);
    else throw new DynaRuntimeError(String.format("Var %s is not in frame stack", varName));
  }
}
