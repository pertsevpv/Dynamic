package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;

public class DynaEmpty extends DynaObject {

  public DynaEmpty() {
    super(Type.EMPTY);
  }

  @Override
  public String asStr(Memory memory) {
    return "<empty>";
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    return other instanceof DynaEmpty;
  }
}
