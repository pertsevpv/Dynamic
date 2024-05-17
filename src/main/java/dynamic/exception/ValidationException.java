package dynamic.exception;

import dynamic.semantic.Span;

public class ValidationException extends Exception {

  public ValidationException(Span span, String msg) {
    super(String.format("%s %s", span, msg));
  }
}
