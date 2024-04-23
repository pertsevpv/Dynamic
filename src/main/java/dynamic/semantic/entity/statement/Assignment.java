package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.interpret.Context;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.lit.Const;
import dynamic.semantic.entity.expr.ref.FunctionCall;
import dynamic.semantic.entity.expr.ref.IdRef;
import dynamic.semantic.entity.expr.ref.Reference;
import dynamic.utils.CheckUtils;

public class Assignment extends Statement {

  public Reference reference;
  public Expr expression;
  public boolean isReassigned = false;
  public boolean rewroteToDeclaration = false;

  public Assignment(Reference reference, Expr expression) {
    super(reference.span);
    this.reference = reference;
    this.expression = expression;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    if (reference instanceof FunctionCall call) {
      throw new ValidationException(call.span, "function call %s is illegal in assigment\n".formatted(call));
    } else if (reference instanceof IdRef idRef) {
      CheckUtils.checkVarDeclared(idRef.id, context);
    } else {
      reference.validate(context);
    }
    expression.validate(context);
    if (reference instanceof IdRef idRef) context.rewriteVar(idRef.id.name, this);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth));
    reference.print(depth, sb);
    expression.print(depth, sb.append(" := "));
  }

  @Override
  public Statement optimize() {
    if (rewroteToDeclaration) return null;
    if (isReassigned) {
      if (expression instanceof FunctionCall call) {
        return new CallStat(call.optimize());
      } else return null;
    }
    return new Assignment(reference, expression.optimize());
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    Context.isLeftRefCall = true;
    reference.execute(memory, valueStack, stackFrame);
    Context.isLeftRefCall = false;

    var oldObj = valueStack.pop();
    var addr = oldObj.memoryAddress;

    expression.execute(memory, valueStack, stackFrame);
    var newValue = valueStack.pop();

    if (addr == -1) addr = memory.alloc(newValue);
    memory.write(addr, newValue);
  }
}
