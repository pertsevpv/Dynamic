package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;

public abstract class DynaObject {

  public int memoryAddress = -1;
  public final Type type;

  public DynaObject(Type type) {
    this.type = type;
  }

  public abstract String asStr(Memory memory);

  public abstract boolean eq(DynaObject other, Memory memory);

  public boolean refEq(DynaObject other) {
    return memoryAddress != -1 && memoryAddress == other.memoryAddress;
  }

  public boolean isNotAllocated() {
    return memoryAddress == -1;
  }
}
