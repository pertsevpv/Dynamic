package dynamic.semantic.entity.expr.fun;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Block;
import dynamic.semantic.Span;

import java.util.List;

public class BlockFunc extends Func {

  public Block block;

  public BlockFunc(List<Parameter> params, Block block, Span span) {
    super(params, span);
    this.block = block;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    context.enterScope();
    for (var p: params) p.validate(context);
    for (var p: params) context.putDeclaration(p);
    block.validate(context);
    context.exitScope();
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("func ");
    if (params != null) {
      sb.append("(");
      if (!params.isEmpty()) {
        params.get(0).print(depth, sb);
        for (int i = 1; i < params.size(); i++)
          params.get(i).print(depth, sb.append(", "));
      }
      sb.append(")");
    }
    sb.append(" is\n");
    block.print(depth, sb);
    sb.append("  ".repeat(depth));
    sb.append("end\n\n");
  }
}
