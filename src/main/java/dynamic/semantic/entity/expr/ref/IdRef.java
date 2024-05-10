package dynamic.semantic.entity.expr.ref;

import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

public class IdRef extends Reference {

  public Id id;

  public IdRef(Id id) {
    super(id.span);
    this.id = id;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    CheckUtils.checkVarDeclared(id, context);
    var expr = context.getExpr(id.name);
    if (expr != null) {
      this.type = expr.type;
    }/* else if (!(context.getDecl(id.name) instanceof Parameter)) {
      throw new ValidationException(span, "var %s is empty".formatted(id.name));
    }*/
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append(id);
  }

  @Override
  public Expr optimize() {
    return new IdRef(id);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    var objAddr = stackFrame.getAddress(id.name);
    valueStack.push(memory.get(objAddr));
  }

  @Override
  public void onAssign(int newAddr, StackFrame stackFrame) {
    stackFrame.rewrite(id.name, newAddr);
  }
}
