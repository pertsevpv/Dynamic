package dynamic.semantic.entity.expr.op;

import dynamic.exception.DynaRuntimeException;
import dynamic.interpret.Memory;
import dynamic.interpret.obj.*;
import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BiOps {

  public static DynaObject op(
      BiOperation.OpType opType,
      DynaObject left, DynaObject right,
      Memory memory
  ) {
    return switch (opType) {
      case PLUS -> plus(left, right, memory);
      case MINUS -> minus(left, right);
      case TIMES -> times(left, right);
      case DIV -> divide(left, right);
      case MOD -> mod(left, right);

      case LE -> cmp(left, right, (i) -> i < 0);
      case LE_EQ -> cmp(left, right, (i) -> i <= 0);
      case GR -> cmp(left, right, (i) -> i > 0);
      case GR_EQ -> cmp(left, right, (i) -> i >= 0);

      case EQ -> new DynaBool(left.eq(right, memory));
      case NOT_EQ -> new DynaBool(!left.eq(right, memory));

      case REF_EQ -> new DynaBool(left.refEq(right));
      case REF_NOT_EQ -> new DynaBool(!left.refEq(right));

      case AND -> logical(left, right, Boolean::logicalAnd);
      case OR -> logical(left, right, Boolean::logicalOr);
      case XOR -> logical(left, right, Boolean::logicalXor);
    };
  }

  private static DynaObject plus(DynaObject left, DynaObject right, Memory memory) {
    if (left instanceof DynaInteger leftInt && right instanceof DynaInteger rightInt) {
      return new DynaInteger(leftInt.value.add(rightInt.value));
    } else if (left instanceof DynaReal leftReal && right instanceof DynaInteger rightInt) {
      return new DynaReal(leftReal.value + rightInt.value.doubleValue());
    } else if (left instanceof DynaInteger leftInt && right instanceof DynaReal rightReal) {
      return new DynaReal(leftInt.value.doubleValue() + rightReal.value);
    } else if (left instanceof DynaReal leftReal && right instanceof DynaReal rightReal) {
      return new DynaReal(leftReal.value + rightReal.value);
    }

    if (left instanceof DynaString leftStr && right instanceof DynaString rightStr) {
      return new DynaString(leftStr.value.concat(rightStr.value));
    } else if (left instanceof DynaString leftStr) {
      return new DynaString(leftStr.value.concat(right.asStr(memory)));
    } else if (right instanceof DynaString rightStr) {
      return new DynaString(left.asStr(memory).concat(rightStr.value));
    }

    if (left instanceof DynaTuple leftTuple && right instanceof DynaTuple rightTuple) {
      var leftList = leftTuple.tuple;
      var rightList = rightTuple.tuple;
      return new DynaTuple(DynaTuple.plus(leftList, rightList));
    }
    throw new DynaRuntimeException();
  }

  private static DynaObject minus(DynaObject left, DynaObject right) {
    if (left instanceof DynaInteger leftInt && right instanceof DynaInteger rightInt) {
      return new DynaInteger(leftInt.value.subtract(rightInt.value));
    } else if (left instanceof DynaReal leftReal && right instanceof DynaInteger rightInt) {
      return new DynaReal(leftReal.value - rightInt.value.doubleValue());
    } else if (left instanceof DynaInteger leftInt && right instanceof DynaReal rightReal) {
      return new DynaReal(leftInt.value.doubleValue() - rightReal.value);
    } else if (left instanceof DynaReal leftReal && right instanceof DynaReal rightReal) {
      return new DynaReal(leftReal.value - rightReal.value);
    }
    throw new DynaRuntimeException();
  }

  private static DynaObject times(DynaObject left, DynaObject right) {
    if (left instanceof DynaInteger leftInt && right instanceof DynaInteger rightInt) {
      return new DynaInteger(leftInt.value.multiply(rightInt.value));
    } else if (left instanceof DynaReal leftReal && right instanceof DynaInteger rightInt) {
      return new DynaReal(leftReal.value * rightInt.value.doubleValue());
    } else if (left instanceof DynaInteger leftInt && right instanceof DynaReal rightReal) {
      return new DynaReal(leftInt.value.doubleValue() * rightReal.value);
    }  else if (left instanceof DynaReal leftReal && right instanceof DynaReal rightReal) {
      return new DynaReal(leftReal.value * rightReal.value);
    }
    throw new DynaRuntimeException();
  }

  private static DynaObject divide(DynaObject left, DynaObject right) {
    if (left instanceof DynaInteger leftInt && right instanceof DynaInteger rightInt) {
      if (rightInt.value.equals(BigInteger.ZERO)) throw new DynaRuntimeException();
      return new DynaInteger(leftInt.value.divide(rightInt.value));
    } else if (left instanceof DynaReal leftReal && right instanceof DynaInteger rightInt) {
      return new DynaReal(leftReal.value / rightInt.value.doubleValue());
    } else if (left instanceof DynaInteger leftInt && right instanceof DynaReal rightReal) {
      return new DynaReal(leftInt.value.doubleValue() / rightReal.value);
    }  else if (left instanceof DynaReal leftReal && right instanceof DynaReal rightReal) {
      return new DynaReal(leftReal.value / rightReal.value);
    }
    throw new DynaRuntimeException();
  }

  private static DynaObject mod(DynaObject left, DynaObject right) {
    if (left instanceof DynaInteger leftInt && right instanceof DynaInteger rightInt) {
      return new DynaInteger(leftInt.value.mod(rightInt.value));
    }
    throw new DynaRuntimeException();
  }

  private static DynaBool cmp(DynaObject left, DynaObject right, Function<Integer, Boolean> cmp) {
    if (left instanceof DynaInteger leftInt && right instanceof DynaInteger rightInt) {
      return new DynaBool(cmp.apply(leftInt.value.compareTo(rightInt.value)));
    }
    if (left instanceof DynaReal leftReal && right instanceof DynaInteger rightInt) {
      return new DynaBool(cmp.apply(Double.compare(leftReal.value, rightInt.value.doubleValue())));
    }
    if (left instanceof DynaInteger leftInt && right instanceof DynaReal rightReal) {
      return new DynaBool(cmp.apply(Double.compare(leftInt.value.doubleValue(), rightReal.value)));
    }
    if (left instanceof DynaReal leftReal && right instanceof DynaReal rightReal) {
      return new DynaBool(cmp.apply(Double.compare(leftReal.value, rightReal.value)));
    }
    if (left instanceof DynaString leftString && right instanceof DynaString rightString) {
      return new DynaBool(cmp.apply(leftString.value.compareTo(rightString.value)));
    }
    throw new DynaRuntimeException();
  }

  private static DynaBool logical(DynaObject left, DynaObject right, BiFunction<Boolean, Boolean, Boolean> logical) {
    if (left instanceof DynaBool leftBool && right instanceof DynaBool rightBool) {
      return new DynaBool(leftBool.value & rightBool.value);
    }
    throw new DynaRuntimeException();
  }
}
