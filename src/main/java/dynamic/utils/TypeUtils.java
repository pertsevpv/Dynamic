package dynamic.utils;

import dynamic.semantic.Type;

public class TypeUtils {

  public static boolean checkType(Type expected, Type got) {
    return got == null || expected == got;
  }
}
