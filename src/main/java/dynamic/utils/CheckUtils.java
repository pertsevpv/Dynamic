package dynamic.utils;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.expr.Expr;

public class CheckUtils {

  public static void checkVarDeclared(Id id, ValidationContext context) throws ValidationException {
    if (!context.containDeclaration(id.name)) {
      throw new ValidationException("Undeclared variable %s at %s".formatted(id.name, id.span));
    }
  }

  public static void checkVarNotDeclared(Id id, ValidationContext context) throws ValidationException {
    if (context.containDeclaration(id.name)) {
      throw new ValidationException("Var %s at %s is already defined".formatted(id.name, id.span));
    }
  }

  public static void checkTypes(Type expected, Expr got) throws ValidationException {
    if (got == null) return;
    checkTypes(expected, got.type, got.span);
  }

  public static void checkTypes(Type expected, Type got, Span span) throws ValidationException {
    if (!TypeUtils.checkType(Type.INT, got)) {
      throw new ValidationException("Expected %s at %s, but %s got".formatted(expected, got, span));
    }
  }
}
