package dynamic.utils;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.expr.Expr;

public class CheckUtils {

  public static void checkVarDeclared(Id id, ValidationContext context) throws ValidationException {
    if (!context.containDecl(id.name)) {
      throw new ValidationException(id.span, "Undeclared variable %s".formatted(id.name));
    }
  }

  public static void checkVarNotDeclared(Id id, ValidationContext context) throws ValidationException {
    if (context.containDeclInCurScope(id.name)) {
      throw new ValidationException(id.span, "Var %s is already defined".formatted(id.name));
    }
  }

  public static void checkTypes(Type expected, Expr got) throws ValidationException {
    if (got == null) return;
    checkTypes(expected, got.type, got.span);
  }

  public static void checkTypes(Type expected, Type got, Span span) throws ValidationException {
    if (!TypeUtils.checkType(expected, got)) {
      throw new ValidationException(span, "Expected %s, but %s got".formatted(expected, got));
    }
  }
}
