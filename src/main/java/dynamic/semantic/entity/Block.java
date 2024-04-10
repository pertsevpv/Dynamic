package dynamic.semantic.entity;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.statement.Return;
import dynamic.semantic.entity.statement.Statement;

import java.util.List;
import java.util.stream.Collectors;

public class Block implements Validatable, Printable {

  public List<Statement> block;

  public Block(List<Statement> block) {
    this.block = block;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    boolean hasReturn = false;
    for (var stat: block) {
      stat.validate(context);
      if (hasReturn) {
        System.out.format("%s statement %s is unreachable\n", stat.span, stat);
        stat.isReachable = false;
      }
      if (stat instanceof Return) hasReturn = true;
    }
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    for (var stat: block) {
      stat.print(depth + 1, sb);
      sb.append("\n");
    }
  }
}
