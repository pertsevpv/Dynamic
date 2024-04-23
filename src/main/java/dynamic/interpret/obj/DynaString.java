package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;

public class DynaString extends DynaObject {

  public String value;

  public DynaString(String value) {
    super(Type.STRING);
    this.value = value;
  }

  @Override
  public String asStr(Memory memory) {
    return "%s".formatted(value);
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    return other instanceof DynaString otherString && value.equals(otherString.value);
  }
}
