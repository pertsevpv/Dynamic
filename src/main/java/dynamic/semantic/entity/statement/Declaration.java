package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.interpret.obj.DynaEmpty;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.ref.FunctionCall;
import dynamic.utils.CheckUtils;

public class Declaration extends Statement {

  public Id name;
  public Expr expression;
  public Type type;
  public Assignment firstRewroteAssignment;
  public boolean isVariableUsed = true;

  public Declaration(Id name, Span span) {
    this(name, null, span);
  }

  public Declaration(Id name, Expr expression, Span span) {
    super(span);
    this.name = name;
    this.expression = expression;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    CheckUtils.checkVarNotDeclared(name, context);
    context.putDeclaration(this);
    if (expression != null) {
      expression.validate(context);
      this.type = expression.type;
    } else {
      this.type = Type.EMPTY;
    }
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("var ")
        .append(name);
    if (expression != null) expression.print(depth, sb.append(" := "));
  }

  @Override
  public Statement optimize() {
    if (!isVariableUsed) {
      if (expression instanceof FunctionCall call) {
        return new CallStat(call.optimize());
      } else return null;
    } else if (firstRewroteAssignment != null) {
      firstRewroteAssignment.rewroteToDeclaration = true;
      return new Declaration(name, firstRewroteAssignment.expression.optimize(), span);
    }
    if (expression == null) return new Declaration(name, span);
    else return new Declaration(name, expression.optimize(), span);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    var newObj = new DynaEmpty();
    int newAddr = memory.create(newObj);

    stackFrame.put(name.name, newAddr);
    if (expression != null) {
      expression.execute(memory, valueStack, stackFrame);
      var value = valueStack.pop();
      memory.write(newAddr, value);
    }
  }
}
