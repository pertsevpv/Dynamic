package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Printable;

import java.util.List;

public class DeclarationList extends Statement {

  public List<Declaration> declarations;

  public DeclarationList(List<Declaration> declarations) {
    super(declarations.get(0).span);
    this.declarations = declarations;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    for (var decl: declarations) decl.validate(context);
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    for (var d: declarations) {
      d.print(depth, sb);
      sb.append("\n");
    }
  }
}
