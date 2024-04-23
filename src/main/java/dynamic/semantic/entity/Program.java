package dynamic.semantic.entity;

import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.semantic.context.ValidationContext;

public class Program implements Validatable, Printable, Optimizable<Program> {

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

  @Override
  public Program optimize() {
    return new Program(program.optimize());
  }

  public void execute() {
    Memory memory = new Memory();
    ValueStack valueStack = new ValueStack();
    StackFrame globalStackFrame = new StackFrame(null, -1);
    program.execute(memory, valueStack, globalStackFrame);
    System.out.println();
  }
}
