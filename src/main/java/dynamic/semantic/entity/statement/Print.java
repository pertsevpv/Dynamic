package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.interpret.IOContext;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.semantic.Span;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Optimizable;
import dynamic.semantic.entity.expr.Expr;

import java.util.List;
import java.util.stream.Collectors;

public class Print extends Statement {

  public List<Expr> exprs;
  public static final String SEPARATOR = " ";

  public Print(List<Expr> exprs, Span span) {
    super(span);
    this.exprs = exprs;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var expr: exprs) expr.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("print(")
        .append(exprs.stream().map(Expr::toString).collect(Collectors.joining(", ")))
        .append(")\n");
  }

  @Override
  public Statement optimize() {
    return new Print(exprs.stream().map(Optimizable::optimize).toList(), span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    for (int i = 0; i < exprs.size() - 1; i++) {
      var expr = exprs.get(i);
      expr.execute(memory, valueStack, stackFrame);
      var obj = valueStack.pop();
      IOContext.print(obj.asStr(memory));
      IOContext.print(SEPARATOR);
    }
    var expr = exprs.get(exprs.size() - 1);
    expr.execute(memory, valueStack, stackFrame);
    var obj = valueStack.pop();
    IOContext.println(obj.asStr(memory));
  }
}
