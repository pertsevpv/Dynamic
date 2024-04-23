package dynamic.interpret;

import dynamic.exception.DynaRuntimeError;
import dynamic.exception.DynaRuntimeException;

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
}
