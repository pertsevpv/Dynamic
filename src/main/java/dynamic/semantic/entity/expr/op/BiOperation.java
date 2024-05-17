package dynamic.semantic.entity.expr.op;

import dynamic.exception.ValidationException;
import dynamic.interpret.Memory;
import dynamic.interpret.StackFrame;
import dynamic.interpret.ValueStack;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.TypeUtils;

public class BiOperation extends Expr {

  public Expr left, right;
  public OpType opType;

  public BiOperation(Expr left, Expr right, OpType opType) {
    super(left.span);
    this.left = left;
    this.right = right;
    this.opType = opType;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    left.validate(context);
    right.validate(context);
    this.type = TypeUtils.checkBiOpType(span, left.type, right.type, opType);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("(");
    left.print(depth, sb);
    sb.append(" ").append(opType.sign).append(" ");
    right.print(depth, sb);
    sb.append(")");
  }

  @Override
  public Expr optimize() {
    var optLeft = left.optimize();
    var optRight = right.optimize();
    return new BiOperation(optLeft, optRight, opType);
  }

  @Override
  public void execute(Memory memory, ValueStack valueStack, StackFrame stackFrame) {
    left.execute(memory, valueStack, stackFrame);
    right.execute(memory, valueStack, stackFrame);
    var rightObj = valueStack.pop();
    var leftObj = valueStack.pop();
    valueStack.push(BiOps.op(opType, leftObj, rightObj, memory));
  }

  public enum OpType {
    AND("and"), OR("or"), XOR("xor"),
    LE("<"), LE_EQ("<="), EQ("="), NOT_EQ("/="), GR(">"), GR_EQ(">="),
    REF_EQ("=="), REF_NOT_EQ("/=="),
    PLUS("+"), MINUS("-"), DIV("/"), TIMES("*"), MOD("%");

    final String sign;

    OpType(String sign) {
      this.sign = sign;
    }

    @Override
    public String toString() {
      return sign;
    }
  }
}
