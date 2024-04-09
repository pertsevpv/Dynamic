package dynamic.semantic;

import dynamic.parser.gen.DynaParser;
import dynamic.semantic.entity.Block;
import dynamic.semantic.entity.Id;
import dynamic.semantic.entity.Program;
import dynamic.semantic.entity.expr.Expr;
import dynamic.semantic.entity.expr.Is;
import dynamic.semantic.entity.expr.fun.ExprFunc;
import dynamic.semantic.entity.expr.fun.BlockFunc;
import dynamic.semantic.entity.expr.fun.Parameter;
import dynamic.semantic.entity.expr.lit.*;
import dynamic.semantic.entity.expr.read.ReadInt;
import dynamic.semantic.entity.expr.read.ReadReal;
import dynamic.semantic.entity.expr.read.ReadString;
import dynamic.semantic.entity.expr.ref.*;
import dynamic.semantic.entity.statement.*;
import dynamic.semantic.entity.expr.op.BiOperation;
import dynamic.semantic.entity.expr.op.UnOperation;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynaWalker {

  DynaParser.ProgramContext program;

  public DynaWalker(DynaParser.ProgramContext program) {
    this.program = program;
  }

  public Program analyze() {
    return new Program(handleBlock(program.statement()));
  }

  private Block handleBlock(List<DynaParser.StatementContext> ctx) {
    return new Block(ctx.stream().map(this::handleStatement).toList());
  }

  private Statement handleStatement(DynaParser.StatementContext ctx) {
    if (ctx.declaration() != null) return handleDeclaration(ctx.declaration());
    if (ctx.assignment() != null) return handleAssignment(ctx.assignment());
    if (ctx.if_() != null) return handleIf(ctx.if_());
    if (ctx.return_() != null) return handleReturn(ctx.return_());
    if (ctx.print() != null) return handlePrint(ctx.print());
    return handleLoop(ctx.loop());
  }

  private Statement handleDeclaration(DynaParser.DeclarationContext ctx) {
    List<Declaration> result = new ArrayList<>();
    result.add(handleVarDefinition(ctx.variableDefinition(0), Span.fromNode(ctx.VAR())));
    for (int i = 1; i < ctx.variableDefinition().size(); i++)
      result.add(handleVarDefinition(ctx.variableDefinition(i)));
    if (result.size() == 1) return result.get(0);
    return new DeclarationList(result);
  }

  private Declaration handleVarDefinition(DynaParser.VariableDefinitionContext ctx) {
    var id = Id.fromNode(ctx.IDENTIFIER());
    var span = id.span;
    if (ctx.expression() != null) {
      var expr = handleExpr(ctx.expression());
      return new Declaration(id, expr, span);
    }
    return new Declaration(id, span);
  }

  private Declaration handleVarDefinition(DynaParser.VariableDefinitionContext ctx, Span span) {
    var id = Id.fromNode(ctx.IDENTIFIER());
    if (ctx.expression() != null) {
      var expr = handleExpr(ctx.expression());
      return new Declaration(id, expr, span);
    }
    return new Declaration(id, span);
  }

  private Assignment handleAssignment(DynaParser.AssignmentContext ctx) {
    var ref = handleRef(ctx.reference());
    var expr = handleExpr(ctx.expression());
    return new Assignment(ref, expr);
  }

  private If handleIf(DynaParser.IfContext ctx) {
    var span = Span.fromNode(ctx.IF());
    var expr = handleExpr(ctx.expression());
    var ifBlock = handleBlock(ctx.ifBlock.statement());
    if (ctx.elseBlock == null) return new If(expr, ifBlock, span);
    var elseBlock = handleBlock(ctx.elseBlock.statement());
    return new If(expr, ifBlock, elseBlock, span);
  }

  private Return handleReturn(DynaParser.ReturnContext ctx) {
    var span = Span.fromNode(ctx.RETURN());
    if (ctx.expression() != null) {
      var expr = handleExpr(ctx.expression());
      return new Return(expr, span);
    }
    return new Return(span);
  }

  private Print handlePrint(DynaParser.PrintContext ctx) {
    var span = Span.fromNode(ctx.PRINT());
    var exprs = ctx.expression().stream().map(this::handleExpr).toList();
    return new Print(exprs, span);
  }

  private Statement handleLoop(DynaParser.LoopContext ctx) {
    var block = handleBlock(ctx.loopBody().body().statement());
    if (ctx.WHILE() != null) {
      var span = Span.fromNode(ctx.WHILE());
      var expr = handleExpr(ctx.cond);
      return new While(expr, block, span);
    }
    var span = Span.fromNode(ctx.FOR());
    var var = new Parameter(Id.fromNode(ctx.IDENTIFIER()));
    var from = handleExpr(ctx.from);
    var to = handleExpr(ctx.to);
    return new For(var, from, to, block, span);
  }

  private Expr handleExpr(DynaParser.ExpressionContext ctx) {
    var expr = handleExpr(ctx.relation(0));
    for (int i = 1; i < ctx.relation().size(); i++) {
      var op = getBinOpType(ctx.sign.get(i - 1));
      expr = new BiOperation(expr, handleExpr(ctx.relation(i)), op);
    }
    return expr;
  }

  private Expr handleExpr(DynaParser.RelationContext ctx) {
    var left = handleExpr(ctx.factor(0));
    if (ctx.factor().size() > 1) {
      var op = getBinOpType(ctx.sign);
      var right = handleExpr(ctx.factor(1));
      return new BiOperation(left, right, op);
    }
    return left;
  }

  private Expr handleExpr(DynaParser.FactorContext ctx) {
    var expr = handleExpr(ctx.term(0));
    for (int i = 1; i < ctx.term().size(); i++) {
      var op = getBinOpType(ctx.sign.get(i - 1));
      expr = new BiOperation(expr, handleExpr(ctx.term(i)), op);
    }
    return expr;
  }

  private Expr handleExpr(DynaParser.TermContext ctx) {
    var expr = handleExpr(ctx.unary(0));
    for (int i = 1; i < ctx.unary().size(); i++) {
      var op = getBinOpType(ctx.sign.get(i - 1));
      expr = new BiOperation(expr, handleExpr(ctx.unary(i)), op);
    }
    return expr;
  }

  private Expr handleExpr(DynaParser.UnaryContext ctx) {
    if (ctx.reference() != null) {
      var ref = handleRef(ctx.reference());
      if (ctx.IS() != null) {
        var type = getType(ctx.typeIndicator());
        return new Is(ref, type);
      }
      return ref;
    } else {
      var expr = handleExpr(ctx.primary());
      if (ctx.sign != null) return new UnOperation(expr, getUnOpType(ctx.sign));
      else return expr;
    }
  }

  private Expr handleExpr(DynaParser.PrimaryContext ctx) {
    if (ctx.literal() != null) return handleConst(ctx.literal());
    if (ctx.READ_INT() != null) return new ReadInt(Span.fromNode(ctx.READ_INT()));
    if (ctx.READ_REAL() != null) return new ReadReal(Span.fromNode(ctx.READ_REAL()));
    if (ctx.READ_STRING() != null) return new ReadString(Span.fromNode(ctx.READ_STRING()));
    if (ctx.expression() != null) {
      var expr = handleExpr(ctx.expression());
      if (ctx.MINUS() != null) return new UnOperation(expr, UnOperation.OpType.MINUS);
      else return expr;
    }
    return handleFunc(ctx.functionLiteral());
  }

  private Expr handleFunc(DynaParser.FunctionLiteralContext ctx) {
    var span = Span.fromNode(ctx.FUNC());
    List<Parameter> params;
    if (ctx.parameters() == null) params = Collections.emptyList();
    else params = ctx.parameters().IDENTIFIER().stream()
        .map(Id::fromNode).map(Parameter::new)
        .toList();

    if (ctx.funBody().expression() != null) {
      var expr = handleExpr(ctx.funBody().expression());
      return new ExprFunc(params, expr, span);
    } else {
      var statementList = ctx.funBody().body().statement()
          .stream().map(this::handleStatement)
          .toList();
      var block = new Block(statementList);
      return new BlockFunc(params, block, span);
    }
  }

  private Const<?> handleConst(DynaParser.LiteralContext ctx) {
    var span = Span.fromToken(ctx.start);
    if (ctx.INTEGER_LITERAL() != null) {
      int val = Integer.parseInt(ctx.INTEGER_LITERAL().getText());
      return new IntConst(val, span);
    }
    if (ctx.REAL_LITERAL() != null) {
      double val = Double.parseDouble(ctx.REAL_LITERAL().getText());
      return new RealConst(val, span);
    }
    if (ctx.BOOLEAN_LITERAL() != null) {
      boolean val = Boolean.parseBoolean(ctx.BOOLEAN_LITERAL().getText());
      return new BoolConst(val, span);
    }
    if (ctx.STRING_LITERAL() != null) {
      String val = ctx.STRING_LITERAL().getText();
      return new StringConst(val, span);
    }
    if (ctx.arrayLiteral() != null) {
      List<Expr> exprs = ctx.arrayLiteral().expression()
          .stream().map(this::handleExpr)
          .toList();
      return new ArrayConst(exprs, span);
    }
    var tuple = ctx.tupleLiteral().tupleElem()
        .stream().map(this::handleTupleElem)
        .toList();
    return new TupleConst(tuple, span);
  }

  private TupleConst.TupleElem handleTupleElem(DynaParser.TupleElemContext ctx) {
    var expr = handleExpr(ctx.expression());
    if (ctx.IDENTIFIER() != null) {
      var id = Id.fromNode(ctx.IDENTIFIER());
      return new TupleConst.TupleElem(id, expr);
    }
    return new TupleConst.TupleElem(expr);
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

  private Type getType(DynaParser.TypeIndicatorContext ctx) {
    if (ctx.INT() != null) return Type.INT;
    if (ctx.REAL() != null) return Type.REAL;
    if (ctx.BOOL() != null) return Type.BOOL;
    if (ctx.STRING() != null) return Type.STRING;
    if (ctx.EMPTY() != null) return Type.EMPTY;
    if (ctx.FUNC() != null) return Type.FUNC;
    if (ctx.LBRACK() != null && ctx.RBRACK() != null) return Type.ARRAY;
    if (ctx.LCURLY() != null && ctx.RCURLY() != null) return Type.TUPLE;
    throw new IllegalStateException();
  }

  private UnOperation.OpType getUnOpType(Token token) {
    return switch (token.getText()) {
      case "+" -> UnOperation.OpType.PLUS;
      case "-" -> UnOperation.OpType.MINUS;
      case "not" -> UnOperation.OpType.NOT;
      default -> throw new IllegalArgumentException();
    };
  }

  private BiOperation.OpType getBinOpType(Token token) {
    return switch (token.getText()) {
      case "+" -> BiOperation.OpType.PLUS;
      case "-" -> BiOperation.OpType.MINUS;
      case "*" -> BiOperation.OpType.TIMES;
      case "/" -> BiOperation.OpType.DIV;

      case "and" -> BiOperation.OpType.AND;
      case "or" -> BiOperation.OpType.OR;
      case "xor" -> BiOperation.OpType.XOR;

      case "<" -> BiOperation.OpType.LE;
      case "<=" -> BiOperation.OpType.LE_EQ;
      case "=" -> BiOperation.OpType.EQ;
      case "/=" -> BiOperation.OpType.NOT_EQ;
      case ">" -> BiOperation.OpType.GR;
      case "=>" -> BiOperation.OpType.GR_EQ;

      default -> throw new IllegalArgumentException();
    };
  }
}
