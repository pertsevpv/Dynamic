// Generated from src/main/resources/dynamic/grammar/DynaParser.g4 by ANTLR 4.13.1
package dynamic.parser.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DynaParser}.
 */
public interface DynaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DynaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DynaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DynaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DynaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DynaParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(DynaParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(DynaParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DynaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DynaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(DynaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(DynaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(DynaParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(DynaParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(DynaParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(DynaParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(DynaParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(DynaParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(DynaParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(DynaParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DynaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DynaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(DynaParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(DynaParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(DynaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(DynaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(DynaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(DynaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(DynaParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(DynaParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(DynaParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(DynaParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#typeIndicator}.
	 * @param ctx the parse tree
	 */
	void enterTypeIndicator(DynaParser.TypeIndicatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#typeIndicator}.
	 * @param ctx the parse tree
	 */
	void exitTypeIndicator(DynaParser.TypeIndicatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFunctionLiteral(DynaParser.FunctionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFunctionLiteral(DynaParser.FunctionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(DynaParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(DynaParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#funBody}.
	 * @param ctx the parse tree
	 */
	void enterFunBody(DynaParser.FunBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#funBody}.
	 * @param ctx the parse tree
	 */
	void exitFunBody(DynaParser.FunBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(DynaParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(DynaParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(DynaParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(DynaParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void enterLoopBody(DynaParser.LoopBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void exitLoopBody(DynaParser.LoopBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(DynaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(DynaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(DynaParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(DynaParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTupleLiteral(DynaParser.TupleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTupleLiteral(DynaParser.TupleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#tupleElem}.
	 * @param ctx the parse tree
	 */
	void enterTupleElem(DynaParser.TupleElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#tupleElem}.
	 * @param ctx the parse tree
	 */
	void exitTupleElem(DynaParser.TupleElemContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(DynaParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(DynaParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DynaParser#delim}.
	 * @param ctx the parse tree
	 */
	void enterDelim(DynaParser.DelimContext ctx);
	/**
	 * Exit a parse tree produced by {@link DynaParser#delim}.
	 * @param ctx the parse tree
	 */
	void exitDelim(DynaParser.DelimContext ctx);
}