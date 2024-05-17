package dynamic.exception;

import dynamic.semantic.Span;

public class DynaRuntimeException extends RuntimeException {

  public DynaRuntimeException(String message) {
    super(message);
  }

  public DynaRuntimeException(Span span, String message) {
    super(String.format("%s %s", span, message));
  }
}
