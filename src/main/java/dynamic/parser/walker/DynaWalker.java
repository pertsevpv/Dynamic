package dynamic.parser.walker;

import dynamic.parser.gen.DynaParser;
import dynamic.parser.gen.DynaParserBaseListener;
import dynamic.semantic.Block;
import dynamic.semantic.Id;
import dynamic.semantic.expr.Expr;
import dynamic.semantic.expr.ref.*;
import dynamic.semantic.statement.Declaration;
import dynamic.semantic.statement.Statement;

import java.util.List;

public class DynaWalker extends DynaParserBaseListener {

  @Override
  public void enterProgram(DynaParser.ProgramContext ctx) {
    super.enterProgram(ctx);
  }

  private Block handleBlock(List<DynaParser.StatementContext> ctx) {

  }

  private Statement handleStatement(DynaParser.StatementContext ctx) {

  }

  private List<Declaration> handleDeclaration(DynaParser.DeclarationContext ctx) {

  }

  private Declaration handleVarDefinition(DynaParser.VariableDefinitionContext ctx) {
    var id = Id.fromNode(ctx.IDENTIFIER());
//    var expr
  }

  private Expr handleExpr(DynaParser.ExpressionContext ctx) {

  }

  private Expr handleExpr(DynaParser.RelationContext ctx) {

  }

  private Expr handleExpr(DynaParser.FactorContext ctx) {

  }

  private Expr handleExpr(DynaParser.TermContext ctx) {

  }

  private Expr handleExpr(DynaParser.UnaryContext ctx) {

  }

  private Reference handleRef(DynaParser.ReferenceContext ctx) {
    if (ctx.reference() == null) {
      var id = Id.fromNode(ctx.IDENTIFIER());
      return new IdRef(id);
    }
    var ref = handleRef(ctx.reference());
    if (ctx.IDENTIFIER() != null) {
      var id = Id.fromNode(ctx.IDENTIFIER());
      return new DotCall(ref, id);
    }
    if (ctx.INTEGER_LITERAL() != null) {
      var ind = Integer.parseInt(ctx.INTEGER_LITERAL().getSymbol().getText());
      return new IntDotCall(ref, ind);
    }
    if (ctx.LBRACK() != null && ctx.RBRACK() != null) {
      var ind = handleExpr(ctx.expression(0));
      return new ArrayCall(ref, ind);
    }
    List<Expr> params = ctx.expression()
        .stream()
        .map(this::handleExpr)
        .toList();
    return new FunctionCall(ref, params);
  }
}
