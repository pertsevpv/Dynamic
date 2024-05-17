package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;

public class DynaReal extends DynaObject {

  public double value;

  public DynaReal(double value) {
    super(Type.REAL);
    this.value = value;
  }

  @Override
  public String asStr(Memory memory) {
    return String.valueOf(value);
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    return other instanceof DynaReal dynaReal && value == dynaReal.value
        || other instanceof DynaInteger dynaInt && dynaInt.value.doubleValue() == value;
  }
}
