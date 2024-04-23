package dynamic.utils;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.entity.expr.op.BiOperation;
import dynamic.semantic.entity.expr.op.UnOperation;

import java.util.List;

public class TypeUtils {

  public static boolean checkType(Type expected, Type got) {
    return expected == null || got == null || expected == got;
  }

  public static Type checkUnOpType(
      Span span,
      Type paramType,
      UnOperation.OpType type
  ) throws ValidationException {
    if (paramType == null) return null;
    var possible = getPossibleOpTypes(type);
    for (var pair: possible) {
      if (checkType(pair.first, paramType)) return pair.second;
    }
    throw new ValidationException(span, "Illegal param type %s for unary operation %s".formatted(paramType, type));
  }

  public static Type checkBiOpType(
      Span span,
      Type leftParam,
      Type rightParam,
      BiOperation.OpType type
  ) throws ValidationException {
    if (leftParam == null || rightParam == null) return null;
    var possible = getPossibleOpTypes(type);
    for (var triple: possible) {
      if (checkType(triple.first, leftParam) && checkType(triple.second, rightParam)) return triple.third;
    }
    throw new ValidationException(span, "Illegal param types %s, %s for binary operation %s".formatted(leftParam, rightParam, type));
  }

  // Param -> Result
  private static List<Pair<Type, Type>> getPossibleOpTypes(UnOperation.OpType type) {
    return switch (type) {
      case NOT -> List.of(new Pair<>(Type.BOOL, Type.BOOL));
      case MINUS, PLUS -> List.of(
          new Pair<>(Type.INT, Type.INT),
          new Pair<>(Type.REAL, Type.REAL)
      );
    };
  }

  // Param -> Param -> Result
  private static List<Triple<Type, Type, Type>> getPossibleOpTypes(BiOperation.OpType type) {
    return switch (type) {
      case AND, OR, XOR -> List.of(new Triple<>(Type.BOOL, Type.BOOL, Type.BOOL));
      case LE, LE_EQ, GR, GR_EQ -> List.of(
          new Triple<>(Type.INT, Type.INT, Type.BOOL),
          new Triple<>(Type.REAL, Type.REAL, Type.BOOL),
          new Triple<>(Type.STRING, Type.STRING, Type.BOOL)
      );
      case EQ, NOT_EQ -> List.of(
          new Triple<>(Type.INT, Type.INT, Type.BOOL),
          new Triple<>(Type.REAL, Type.REAL, Type.BOOL),
          new Triple<>(Type.STRING, Type.STRING, Type.BOOL),
          new Triple<>(Type.BOOL, Type.BOOL, Type.BOOL),
          new Triple<>(Type.ARRAY, Type.ARRAY, Type.BOOL),
          new Triple<>(Type.TUPLE, Type.TUPLE, Type.BOOL)
      );
      case MINUS, DIV, TIMES -> List.of(
          new Triple<>(Type.INT, Type.INT, Type.INT),
          new Triple<>(Type.REAL, Type.INT, Type.REAL),
          new Triple<>(Type.INT, Type.REAL, Type.REAL),
          new Triple<>(Type.REAL, Type.REAL, Type.REAL)
      );
      case PLUS -> List.of(
          new Triple<>(Type.INT, Type.INT, Type.INT),
          new Triple<>(Type.REAL, Type.INT, Type.REAL),
          new Triple<>(Type.INT, Type.REAL, Type.REAL),
          new Triple<>(Type.REAL, Type.REAL, Type.REAL),
          new Triple<>(Type.ARRAY, Type.ARRAY, Type.ARRAY),
          new Triple<>(Type.TUPLE, Type.TUPLE, Type.TUPLE),
          new Triple<>(null, Type.STRING, Type.STRING),
          new Triple<>(Type.STRING, null, Type.STRING)
      );
      case REF_EQ, REF_NOT_EQ -> List.of();
      case MOD -> List.of(
          new Triple<>(Type.INT, Type.INT, Type.INT)
      );
    };
  }
}
