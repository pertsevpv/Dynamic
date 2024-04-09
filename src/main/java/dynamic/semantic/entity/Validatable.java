package dynamic.semantic.entity;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;

public interface Validatable {

  void validate(ValidationContext context) throws ValidationException;
}
