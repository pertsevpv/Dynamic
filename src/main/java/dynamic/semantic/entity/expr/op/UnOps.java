package dynamic.semantic.entity.expr.op;

import dynamic.exception.DynaRuntimeException;
import dynamic.interpret.obj.DynaBool;
import dynamic.interpret.obj.DynaInteger;
import dynamic.interpret.obj.DynaObject;
import dynamic.interpret.obj.DynaReal;

public class UnOps {

  public static DynaObject op(UnOperation.OpType opType, DynaObject obj) {
    return switch (opType) {
      case NOT -> not(obj);
      case PLUS -> obj;
      case MINUS -> unMinus(obj);
    };
  }

  public static DynaObject not(DynaObject obj) {
    if (obj instanceof DynaBool dynaBool) {
      return new DynaBool(!dynaBool.value);
    }
    throw new DynaRuntimeException();
  }

  public static DynaObject unMinus(DynaObject obj) {
    if (obj instanceof DynaInteger dynaInt) {
      return new DynaInteger(dynaInt.value.negate());
    }
    if (obj instanceof DynaReal dynaReal) {
      return new DynaReal(-dynaReal.value);
    }
    throw new DynaRuntimeException();
  }
}
