package dynamic.semantic.entity.statement;

import dynamic.exception.ValidationException;
import dynamic.semantic.Span;
import dynamic.semantic.Type;
import dynamic.semantic.context.ValidationContext;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.expr.Expr;
import dynamic.utils.CheckUtils;

public class Declaration extends Statement {

  public Id name;
  public Expr expression;
  public Type type;
  public boolean isVariableUsed = true;

  public Declaration(Id name, Span span) {
    this(name, null, span);
  }

  public Declaration(Id name, Expr expression, Span span) {
    super(span);
    this.name = name;
    this.expression = expression;
  }

  @Override
  public void validate(ValidationContext context) throws ValidationException {
    CheckUtils.checkVarNotDeclared(name, context);
    context.putDeclaration(this);
    if (expression != null) {
      expression.validate(context);
      this.type = expression.type;
    } else {
      this.type = Type.EMPTY;
    }
  }

  @Override
  public void print(int depth, StringBuilder sb) {
    sb.append("  ".repeat(depth))
        .append("var ")
        .append(name);
    if (expression != null) expression.print(depth, sb.append(" := "));
  }
}
