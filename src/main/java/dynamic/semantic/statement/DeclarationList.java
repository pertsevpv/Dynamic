package dynamic.semantic.statement;

import java.util.List;

public class DeclarationList extends Statement {

  public List<Declaration> declarations;

  public DeclarationList(List<Declaration> declarations) {
    super(declarations.get(0).span);
    this.declarations = declarations;
  }
}
