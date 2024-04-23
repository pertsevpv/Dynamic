package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;

public class DynaBool extends DynaObject {

  public boolean value;

  public DynaBool(boolean value) {
    super(Type.BOOL);
    this.value = value;
  }

  @Override
  public String asStr(Memory memory) {
    return String.valueOf(value);
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    return other instanceof DynaBool dynaBool && value == dynaBool.value;
  }
}
