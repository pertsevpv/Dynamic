package dynamic.semantic.entity;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;

public class Program implements Validatable, Printable {

  public Block program;

  public Program(Block program) {
    this.program = program;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    program.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    program.block.forEach(it -> it.print(depth, sb));
  }
}
