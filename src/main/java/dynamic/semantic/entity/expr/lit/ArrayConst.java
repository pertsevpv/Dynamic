package dynamic.semantic.entity.expr.lit;

import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaArray;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Optimizable;
import dynamic.semantic.entity.expr.Expr;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayConst extends Const<List<Expr>> {

  public ArrayConst(List<Expr> exprs, Span span) {
    super(exprs, Type.ARRAY, span);
  }

  @Override
  public String toString() {
    return value.stream()
        .map(Expr::toString)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var e: value) e.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("[");
    if (!value.isEmpty()) {
      value.get(0).print(depth, sb);
      for (int i = 1; i < value.size(); i++)
        value.get(i).print(depth, sb.append(", "));
    }
    sb.append("]");
  }

  @Override
  public Expr optimize() {
    return new ArrayConst(value.stream().map(Optimizable::optimize).toList(), span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    Map<Integer, Integer> array = new HashMap<>();
    int index = 0;
    for (var expr: value) {
      expr.execute(memory, valueStack, stackFrame);
      var elem = valueStack.pop();
      if (elem.isNotAllocated()) memory.create(elem);
      array.put(index++, elem.memoryAddress);
    }
    valueStack.push(new DynaArray(array));
  }
}
