package dynamic.semantic.entity.statement;

import dynamic.exception.DynaRuntimeException;
import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.*;
import dynamic.semantic.Span;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Block;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.fun.Parameter;
import dynamic.utils.CheckUtils;

public class ForEach extends Statement {

  public Parameter label, value;
  public Expr iterable;
  public Block block;

  public ForEach(Span span, Parameter label, Parameter value, Expr iterable, Block block) {
    super(span);
    this.label = label;
    this.value = value;
    this.iterable = iterable;
    this.block = block;
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    iterable.execute(memory, valueStack, stackFrame);
    var iterObj = valueStack.pop();

    stackFrame.enterScope();
    if (iterObj instanceof DynaTuple tupleObj) {
      for (var pair : tupleObj.tuple) {
        if (label != null) {
          int labelAddr;
          if (pair.first == null) labelAddr = memory.alloc(new DynaEmpty());
          else labelAddr = memory.alloc(new DynaString(pair.first));
          stackFrame.put(label.name.name, labelAddr);
        }
        var valueObj = memory.get(pair.second);
        stackFrame.put(value.name.name, valueObj.memoryAddress);
        block.execute(memory, valueStack, stackFrame);
      }
    } else if (iterObj instanceof DynaArray arrayObj) {
      for (var entry : arrayObj.sortedStream().toList()) {
        if (label != null) {
          var indAddr = memory.alloc(new DynaInteger(entry.getKey()));
          stackFrame.put(label.name.name, indAddr);
        }
        var valueObj = memory.get(entry.getValue());
        stackFrame.put(value.name.name, valueObj.memoryAddress);
        block.execute(memory, valueStack, stackFrame);
      }
    } else throw new DynaRuntimeException(String.format("%s is not iterable", iterObj.type));
    stackFrame.exitScope();
  }

  @Override
  public Statement optimize() {
    return new ForEach(span, label, value, iterable, block);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("for ");
    if (label != null) sb.append(label.name).append(", ");
    sb.append(value.name)
        .append(" in ");
    iterable.print(depth, sb);
    sb.append(" ")
        .append("loop\n");
    block.print(depth, sb);
    sb.append("  ".repeat(depth))
        .append("end");
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    if (label != null) CheckUtils.checkVarNotDeclared(label.name, context);
    CheckUtils.checkVarNotDeclared(value.name, context);

    iterable.validate(context);

    context.enterScope();
    if (label != null) context.putDeclaration(label);
    context.putDeclaration(value);
    block.validate(context);
    context.exitScope();
  }
}
