package dynamic.semantic.statement;

import dynamic.semantic.expr.Expr;
import dynamic.semantic.expr.ref.Reference;

public class Assignment extends Statement {

  public Reference reference;
  public Expr expression;

  public Assignment(Reference reference, Expr expression) {
    super(reference.span);
    this.reference = reference;
    this.expression = expression;
  }
}
