package dynamic.exception;

import dynamic.semantic.Span;

public class ValidationException extends Exception {

  public ValidationException(Span span, String msg) {
    super("%s %s".formatted(span, msg));
  }
}
