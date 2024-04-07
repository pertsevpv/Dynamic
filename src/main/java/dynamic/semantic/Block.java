package dynamic.semantic;

import dynamic.semantic.statement.Statement;

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
}
