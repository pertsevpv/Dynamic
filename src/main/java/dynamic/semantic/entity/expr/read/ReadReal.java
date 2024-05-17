package dynamic.semantic.entity.expr.read;

import dynamic.interpret.IOContext;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaReal;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class ReadReal extends Read<Double> {
  public ReadReal(Span span) {
    super(span);
  }

  @Override
  public void validate(ValidationContext context) {
    this.type = Type.REAL;
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("readReal");
  }

  @Override
  public Expr optimize() {
    return new ReadReal(span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    valueStack.push(new DynaReal(IOContext.nextDouble()));
  }
}
