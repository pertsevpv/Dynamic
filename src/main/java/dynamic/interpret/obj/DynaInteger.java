package dynamic.interpret.obj;

import dynamic.interpret.Memory;
import dynamic.semantic.Type;

import java.math.BigInteger;

public class DynaInteger extends DynaObject {

  public BigInteger value;

  public DynaInteger(BigInteger value) {
    super(Type.INT);
    this.value = value;
  }

  public DynaInteger(int value) {
    super(Type.INT);
    this.value = BigInteger.valueOf(value);
  }

  @Override
  public String asStr(Memory memory) {
    return String.valueOf(value);
  }

  @Override
  public boolean eq(DynaObject other, Memory memory) {
    return other instanceof DynaInteger dynaInt && value.equals(dynaInt.value);

  }
}
