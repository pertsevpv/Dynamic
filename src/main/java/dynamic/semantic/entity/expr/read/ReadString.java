package dynamic.semantic.entity.expr.read;

import dynamic.interpret.IOContext;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaString;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;

public class ReadString extends Read<String> {
  public ReadString(Span span) {
    super(span);
  }

  @Override
  public void validate(ValidationContext context) {
    this.type = Type.STRING;
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("readString");
  }

  @Override
  public Expr optimize() {
    return new ReadString(span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    valueStack.push(new DynaString(IOContext.nextString()));
  }
}
