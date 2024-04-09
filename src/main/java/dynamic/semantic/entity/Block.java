package dynamic.semantic.entity;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.statement.Return;
import dynamic.semantic.entity.statement.Statement;

import java.util.List;
import java.util.stream.Collectors;

public class Block implements Validatable {

  public List<Statement> block;

  public Block(List<Statement> block) {
    this.block = block;
  }

  @Override
  public String toString() {
    if (block.size() == 1) return block.get(0).toString();
    return block.stream()
        .map(Statement::toString)
        .collect(Collectors.joining("\n", "{\n", "\n}"));
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    boolean hasReturn = false;
    for (var stat: block) {
      stat.validate(context);
      if (hasReturn) stat.isReachable = false;
      if (stat instanceof Return) hasReturn = true;
    }
  }
}
