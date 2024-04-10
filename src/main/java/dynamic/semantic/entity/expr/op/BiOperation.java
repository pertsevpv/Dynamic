package dynamic.semantic.entity.expr.op;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.lit.BoolConst;
import dynamic.semantic.entity.expr.lit.Const;
import dynamic.semantic.entity.expr.lit.IntConst;
import dynamic.semantic.entity.expr.lit.RealConst;
import dynamic.utils.TypeUtils;

import java.util.Objects;

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
    if (!(optLeft instanceof Const<?> leftConst) || !(optRight instanceof Const<?> rightConst))
      return new BiOperation(optLeft, optRight, opType);
    if (leftConst instanceof BoolConst leftVal && rightConst instanceof BoolConst rightVal) {
      return switch (opType) {
        case AND -> new BoolConst(leftVal.value && rightVal.value, leftVal.span);
        case OR -> new BoolConst(leftVal.value || rightVal.value, leftVal.span);
        case XOR -> new BoolConst(leftVal.value ^ rightVal.value, leftVal.span);
        case EQ -> new BoolConst(leftVal.value == rightVal.value, leftVal.span);
        case NOT_EQ -> new BoolConst(leftVal.value != rightVal.value, leftVal.span);
        default -> throw new IllegalArgumentException();
      };
    }
    if (leftConst instanceof IntConst leftVal && rightConst instanceof IntConst rightVal) {
      return switch (opType) {
        case AND -> new IntConst(leftVal.value + rightVal.value, leftVal.span);
        case MINUS -> new IntConst(leftVal.value - rightVal.value, leftVal.span);
        case DIV -> new IntConst(leftVal.value / rightVal.value, leftVal.span);
        case TIMES -> new IntConst(leftVal.value * rightVal.value, leftVal.span);
        case LE -> new BoolConst(leftVal.value < rightVal.value, leftVal.span);
        case LE_EQ -> new BoolConst(leftVal.value <= rightVal.value, leftVal.span);
        case EQ -> new BoolConst(Objects.equals(leftVal.value, rightVal.value), leftVal.span);
        case NOT_EQ -> new BoolConst(!Objects.equals(leftVal.value, rightVal.value), leftVal.span);
        case GR -> new BoolConst(leftVal.value > rightVal.value, leftVal.span);
        case GR_EQ -> new BoolConst(leftVal.value >= rightVal.value, leftVal.span);
        default -> throw new IllegalArgumentException();
      };
    }
    if (leftConst instanceof RealConst leftVal && rightConst instanceof IntConst rightVal) {
      return switch (opType) {
        case AND -> new RealConst(leftVal.value + rightVal.value, leftVal.span);
        case MINUS -> new RealConst(leftVal.value - rightVal.value, leftVal.span);
        case DIV -> new RealConst(leftVal.value / rightVal.value, leftVal.span);
        case TIMES -> new RealConst(leftVal.value * rightVal.value, leftVal.span);
        case LE -> new BoolConst(leftVal.value < rightVal.value, leftVal.span);
        case LE_EQ -> new BoolConst(leftVal.value <= rightVal.value, leftVal.span);
        case EQ -> new BoolConst(false, leftVal.span);
        case NOT_EQ -> new BoolConst(true, leftVal.span);
        case GR -> new BoolConst(leftVal.value > rightVal.value, leftVal.span);
        case GR_EQ -> new BoolConst(leftVal.value >= rightVal.value, leftVal.span);
        default -> throw new IllegalArgumentException();
      };
    }
    if (leftConst instanceof IntConst leftVal && rightConst instanceof RealConst rightVal) {
      return switch (opType) {
        case AND -> new RealConst(leftVal.value + rightVal.value, leftVal.span);
        case MINUS -> new RealConst(leftVal.value - rightVal.value, leftVal.span);
        case DIV -> new RealConst(leftVal.value / rightVal.value, leftVal.span);
        case TIMES -> new RealConst(leftVal.value * rightVal.value, leftVal.span);
        case LE -> new BoolConst(leftVal.value < rightVal.value, leftVal.span);
        case LE_EQ -> new BoolConst(leftVal.value <= rightVal.value, leftVal.span);
        case EQ -> new BoolConst(false, leftVal.span);
        case NOT_EQ -> new BoolConst(true, leftVal.span);
        case GR -> new BoolConst(leftVal.value > rightVal.value, leftVal.span);
        case GR_EQ -> new BoolConst(leftVal.value >= rightVal.value, leftVal.span);
        default -> throw new IllegalArgumentException();
      };
    }
    if (leftConst instanceof RealConst leftVal && rightConst instanceof RealConst rightVal) {
      return switch (opType) {
        case AND -> new RealConst(leftVal.value + rightVal.value, leftVal.span);
        case MINUS -> new RealConst(leftVal.value - rightVal.value, leftVal.span);
        case DIV -> new RealConst(leftVal.value / rightVal.value, leftVal.span);
        case TIMES -> new RealConst(leftVal.value * rightVal.value, leftVal.span);
        case LE -> new BoolConst(leftVal.value < rightVal.value, leftVal.span);
        case LE_EQ -> new BoolConst(leftVal.value <= rightVal.value, leftVal.span);
        case EQ -> new BoolConst(false, leftVal.span);
        case NOT_EQ -> new BoolConst(true, leftVal.span);
        case GR -> new BoolConst(leftVal.value > rightVal.value, leftVal.span);
        case GR_EQ -> new BoolConst(leftVal.value >= rightVal.value, leftVal.span);
        default -> throw new IllegalArgumentException();
      };
    }
    return new BiOperation(optLeft, optRight, opType);
  }

  public enum OpType {
    AND("and"), OR("or"), XOR("xor"),
    LE("<"), LE_EQ("<="), EQ("="), NOT_EQ("/="), GR(">"), GR_EQ(">="),
    PLUS("+"), MINUS("-"), DIV("/"), TIMES("*");

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
