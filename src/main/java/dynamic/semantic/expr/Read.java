package dynamic.semantic.expr;

import dynamic.semantic.Span;
import dynamic.semantic.Type;

public class Read extends Expr {

  public Type readType;

  public Read(Type readType, Span span) {
    super(span);
    if (!checkType(type)) throw new IllegalArgumentException("Illegal type for read: " + readType);
    this.readType = readType;
  }

  private boolean checkType(Type type) {
    return type == Type.INT || type == Type.REAL || type == Type.STRING;
  }

  @Override
  public String toString() {
    return switch (readType) {
      case INT -> "readInt";
      case REAL -> "readReal";
      case STRING -> "readString";
      default -> throw new IllegalArgumentException("Illegal type for read: " + readType);
    };
  }
}
