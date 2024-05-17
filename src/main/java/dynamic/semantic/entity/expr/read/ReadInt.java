package dynamic.semantic.entity.expr.read;

import dynamic.interpret.IOContext;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaInteger;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class ReadInt extends Read<Integer> {
  public ReadInt(Span span) {
    super(span);
  }

  @Override
  public void validate(ValidationContext context) {
    this.type = Type.INT;
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("readInt");
  }

  @Override
  public Expr optimize() {
    return new ReadInt(span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    valueStack.push(new DynaInteger(IOContext.nextInt()));
  }
}
