// Generated from src/main/resources/dynamic/grammar/DynaParser.g4 by ANTLR 4.13.1
package dynamic.parser.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DynaParser extends DynaParserBase {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARROW=1, SEMI=2, COMMA=3, ASSIGN=4, DOTDOT=5, DOT=6, OR=7, AND=8, XOR=9, 
		NOT=10, IF=11, THEN=12, ELSE=13, END=14, WHILE=15, LOOP=16, FOR=17, IN=18, 
		RETURN=19, IS=20, PRINT=21, VAR=22, READ_INT=23, READ_REAL=24, READ_STRING=25, 
		LCURLY=26, RCURLY=27, LPAREN=28, RPAREN=29, LBRACK=30, RBRACK=31, LE=32, 
		LE_EQ=33, GR=34, GR_EQ=35, EQ=36, NOT_EQ=37, PLUS=38, MINUS=39, MUL=40, 
		DIV=41, INT=42, REAL=43, BOOL=44, STRING=45, EMPTY=46, FUNC=47, IDENTIFIER=48, 
		BOOLEAN_LITERAL=49, INTEGER_LITERAL=50, REAL_LITERAL=51, STRING_LITERAL=52, 
		WS=53, COMMENT=54, LINE_COMMENT=55, NEW_LINE=56;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_variableDefinition = 2, RULE_statement = 3, 
		RULE_assignment = 4, RULE_if = 5, RULE_loop = 6, RULE_return = 7, RULE_print = 8, 
		RULE_expression = 9, RULE_relation = 10, RULE_factor = 11, RULE_term = 12, 
		RULE_unary = 13, RULE_primary = 14, RULE_typeIndicator = 15, RULE_functionLiteral = 16, 
		RULE_parameters = 17, RULE_funBody = 18, RULE_reference = 19, RULE_loopBody = 20, 
		RULE_literal = 21, RULE_arrayLiteral = 22, RULE_tupleLiteral = 23, RULE_tupleElem = 24, 
		RULE_body = 25, RULE_delim = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "variableDefinition", "statement", "assignment", 
			"if", "loop", "return", "print", "expression", "relation", "factor", 
			"term", "unary", "primary", "typeIndicator", "functionLiteral", "parameters", 
			"funBody", "reference", "loopBody", "literal", "arrayLiteral", "tupleLiteral", 
			"tupleElem", "body", "delim"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'=>'", "';'", "','", "':='", "'..'", "'.'", "'or'", "'and'", "'xor'", 
			"'not'", "'if'", "'then'", "'else'", "'end'", "'while'", "'loop'", "'for'", 
			"'in'", "'return'", "'is'", "'print'", "'var'", "'readInt'", "'readReal'", 
			"'readString'", "'{'", "'}'", "'('", "')'", "'['", "']'", "'<'", "'<='", 
			"'>'", "'>='", "'='", "'/='", "'+'", "'-'", "'*'", "'/'", "'int'", "'real'", 
			"'bool'", "'string'", "'empty'", "'func'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ARROW", "SEMI", "COMMA", "ASSIGN", "DOTDOT", "DOT", "OR", "AND", 
			"XOR", "NOT", "IF", "THEN", "ELSE", "END", "WHILE", "LOOP", "FOR", "IN", 
			"RETURN", "IS", "PRINT", "VAR", "READ_INT", "READ_REAL", "READ_STRING", 
			"LCURLY", "RCURLY", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "LE", "LE_EQ", 
			"GR", "GR_EQ", "EQ", "NOT_EQ", "PLUS", "MINUS", "MUL", "DIV", "INT", 
			"REAL", "BOOL", "STRING", "EMPTY", "FUNC", "IDENTIFIER", "BOOLEAN_LITERAL", 
			"INTEGER_LITERAL", "REAL_LITERAL", "STRING_LITERAL", "WS", "COMMENT", 
			"LINE_COMMENT", "NEW_LINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DynaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DynaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DynaParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<DelimContext> delim() {
			return getRuleContexts(DelimContext.class);
		}
		public DelimContext delim(int i) {
			return getRuleContext(DelimContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474983692288L) != 0)) {
				{
				{
				setState(54);
				statement();
				setState(55);
				delim();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(DynaParser.VAR, 0); }
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DynaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DynaParser.COMMA, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(VAR);
			setState(65);
			variableDefinition();
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					match(COMMA);
					setState(67);
					variableDefinition();
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DynaParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(DynaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitVariableDefinition(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(IDENTIFIER);
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(74);
				match(ASSIGN);
				setState(75);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				declaration();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				assignment();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				if_();
				}
				break;
			case WHILE:
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				loop();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				return_();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 6);
				{
				setState(83);
				print();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(DynaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			reference(0);
			setState(87);
			match(ASSIGN);
			setState(88);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ParserRuleContext {
		public BodyContext ifBlock;
		public BodyContext elseBlock;
		public TerminalNode IF() { return getToken(DynaParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(DynaParser.THEN, 0); }
		public TerminalNode END() { return getToken(DynaParser.END, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(DynaParser.ELSE, 0); }
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitIf(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(IF);
			setState(91);
			expression();
			setState(92);
			match(THEN);
			setState(93);
			((IfContext)_localctx).ifBlock = body();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(94);
				match(ELSE);
				setState(95);
				((IfContext)_localctx).elseBlock = body();
				}
			}

			setState(98);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopContext extends ParserRuleContext {
		public ExpressionContext cond;
		public ExpressionContext from;
		public ExpressionContext to;
		public TerminalNode WHILE() { return getToken(DynaParser.WHILE, 0); }
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FOR() { return getToken(DynaParser.FOR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DynaParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(DynaParser.IN, 0); }
		public TerminalNode DOTDOT() { return getToken(DynaParser.DOTDOT, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_loop);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(WHILE);
				setState(101);
				((LoopContext)_localctx).cond = expression();
				setState(102);
				loopBody();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(FOR);
				setState(105);
				match(IDENTIFIER);
				setState(106);
				match(IN);
				{
				setState(107);
				((LoopContext)_localctx).from = expression();
				setState(108);
				match(DOTDOT);
				setState(109);
				((LoopContext)_localctx).to = expression();
				}
				setState(111);
				loopBody();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(DynaParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitReturn(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(RETURN);
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(116);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(DynaParser.PRINT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DynaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DynaParser.COMMA, i);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_print);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(PRINT);
			setState(120);
			expression();
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(121);
					match(COMMA);
					setState(122);
					expression();
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Token AND;
		public List<Token> sign = new ArrayList<Token>();
		public Token OR;
		public Token XOR;
		public Token _tset208;
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(DynaParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(DynaParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(DynaParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(DynaParser.OR, i);
		}
		public List<TerminalNode> XOR() { return getTokens(DynaParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(DynaParser.XOR, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			relation();
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					((ExpressionContext)_localctx)._tset208 = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) ) {
						((ExpressionContext)_localctx)._tset208 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((ExpressionContext)_localctx).sign.add(((ExpressionContext)_localctx)._tset208);
					setState(130);
					relation();
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationContext extends ParserRuleContext {
		public Token sign;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TerminalNode LE() { return getToken(DynaParser.LE, 0); }
		public TerminalNode LE_EQ() { return getToken(DynaParser.LE_EQ, 0); }
		public TerminalNode GR() { return getToken(DynaParser.GR, 0); }
		public TerminalNode GR_EQ() { return getToken(DynaParser.GR_EQ, 0); }
		public TerminalNode EQ() { return getToken(DynaParser.EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(DynaParser.NOT_EQ, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitRelation(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			factor();
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(137);
				((RelationContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 270582939648L) != 0)) ) {
					((RelationContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				factor();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public Token s38;
		public List<Token> sign = new ArrayList<Token>();
		public Token s39;
		public Token _tset274;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(DynaParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(DynaParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(DynaParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(DynaParser.MINUS, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			term();
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					((FactorContext)_localctx)._tset274 = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
						((FactorContext)_localctx)._tset274 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((FactorContext)_localctx).sign.add(((FactorContext)_localctx)._tset274);
					setState(143);
					term();
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public Token s40;
		public List<Token> sign = new ArrayList<Token>();
		public Token s41;
		public Token _tset297;
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(DynaParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(DynaParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(DynaParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(DynaParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			unary();
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(150);
					((TermContext)_localctx)._tset297 = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==MUL || _la==DIV) ) {
						((TermContext)_localctx)._tset297 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((TermContext)_localctx).sign.add(((TermContext)_localctx)._tset297);
					setState(151);
					unary();
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public Token sign;
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode IS() { return getToken(DynaParser.IS, 0); }
		public TypeIndicatorContext typeIndicator() {
			return getRuleContext(TypeIndicatorContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(DynaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(DynaParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(DynaParser.NOT, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unary);
		int _la;
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				reference(0);
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(158);
					match(IS);
					setState(159);
					typeIndicator();
					}
					break;
				}
				}
				break;
			case NOT:
			case READ_INT:
			case READ_REAL:
			case READ_STRING:
			case LCURLY:
			case LPAREN:
			case LBRACK:
			case PLUS:
			case MINUS:
			case FUNC:
			case BOOLEAN_LITERAL:
			case INTEGER_LITERAL:
			case REAL_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(162);
					((UnaryContext)_localctx).sign = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 824633721856L) != 0)) ) {
						((UnaryContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(165);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode READ_INT() { return getToken(DynaParser.READ_INT, 0); }
		public TerminalNode READ_REAL() { return getToken(DynaParser.READ_REAL, 0); }
		public TerminalNode READ_STRING() { return getToken(DynaParser.READ_STRING, 0); }
		public FunctionLiteralContext functionLiteral() {
			return getRuleContext(FunctionLiteralContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DynaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DynaParser.RPAREN, 0); }
		public TerminalNode MINUS() { return getToken(DynaParser.MINUS, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primary);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LCURLY:
			case LBRACK:
			case BOOLEAN_LITERAL:
			case INTEGER_LITERAL:
			case REAL_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				literal();
				}
				break;
			case READ_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(READ_INT);
				}
				break;
			case READ_REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(READ_REAL);
				}
				break;
			case READ_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				match(READ_STRING);
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				functionLiteral();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(173);
				match(LPAREN);
				setState(174);
				expression();
				setState(175);
				match(RPAREN);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				match(MINUS);
				setState(178);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeIndicatorContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DynaParser.INT, 0); }
		public TerminalNode REAL() { return getToken(DynaParser.REAL, 0); }
		public TerminalNode BOOL() { return getToken(DynaParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(DynaParser.STRING, 0); }
		public TerminalNode EMPTY() { return getToken(DynaParser.EMPTY, 0); }
		public TerminalNode LBRACK() { return getToken(DynaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(DynaParser.RBRACK, 0); }
		public TerminalNode LCURLY() { return getToken(DynaParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DynaParser.RCURLY, 0); }
		public TerminalNode FUNC() { return getToken(DynaParser.FUNC, 0); }
		public TypeIndicatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIndicator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterTypeIndicator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitTypeIndicator(this);
		}
	}

	public final TypeIndicatorContext typeIndicator() throws RecognitionException {
		TypeIndicatorContext _localctx = new TypeIndicatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeIndicator);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(INT);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(REAL);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(BOOL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				match(STRING);
				}
				break;
			case EMPTY:
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				match(EMPTY);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
				match(LBRACK);
				setState(187);
				match(RBRACK);
				}
				break;
			case LCURLY:
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				match(LCURLY);
				setState(189);
				match(RCURLY);
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				match(FUNC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionLiteralContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(DynaParser.FUNC, 0); }
		public FunBodyContext funBody() {
			return getRuleContext(FunBodyContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterFunctionLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitFunctionLiteral(this);
		}
	}

	public final FunctionLiteralContext functionLiteral() throws RecognitionException {
		FunctionLiteralContext _localctx = new FunctionLiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(FUNC);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(194);
				parameters();
				}
			}

			setState(197);
			funBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DynaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DynaParser.RPAREN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(DynaParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(DynaParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DynaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DynaParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(LPAREN);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(200);
				match(IDENTIFIER);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(201);
					match(COMMA);
					setState(202);
					match(IDENTIFIER);
					}
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(210);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunBodyContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(DynaParser.IS, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(DynaParser.END, 0); }
		public TerminalNode ARROW() { return getToken(DynaParser.ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterFunBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitFunBody(this);
		}
	}

	public final FunBodyContext funBody() throws RecognitionException {
		FunBodyContext _localctx = new FunBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funBody);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IS:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(IS);
				setState(213);
				body();
				setState(214);
				match(END);
				}
				break;
			case ARROW:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(ARROW);
				setState(217);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DynaParser.IDENTIFIER, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(DynaParser.LBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(DynaParser.RBRACK, 0); }
		public TerminalNode LPAREN() { return getToken(DynaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DynaParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DynaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DynaParser.COMMA, i);
		}
		public TerminalNode DOT() { return getToken(DynaParser.DOT, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(DynaParser.INTEGER_LITERAL, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitReference(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		return reference(0);
	}

	private ReferenceContext reference(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ReferenceContext _localctx = new ReferenceContext(_ctx, _parentState);
		ReferenceContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_reference, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(221);
			match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(247);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(223);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(224);
						match(LBRACK);
						setState(225);
						expression();
						setState(226);
						match(RBRACK);
						}
						break;
					case 2:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(228);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(229);
						match(LPAREN);
						setState(238);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8867287868113920L) != 0)) {
							{
							setState(230);
							expression();
							setState(235);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(231);
								match(COMMA);
								setState(232);
								expression();
								}
								}
								setState(237);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(240);
						match(RPAREN);
						}
						break;
					case 3:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(241);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(242);
						match(DOT);
						setState(243);
						match(IDENTIFIER);
						}
						break;
					case 4:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(244);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(245);
						match(DOT);
						setState(246);
						match(INTEGER_LITERAL);
						}
						break;
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopBodyContext extends ParserRuleContext {
		public TerminalNode LOOP() { return getToken(DynaParser.LOOP, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(DynaParser.END, 0); }
		public LoopBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterLoopBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitLoopBody(this);
		}
	}

	public final LoopBodyContext loopBody() throws RecognitionException {
		LoopBodyContext _localctx = new LoopBodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_loopBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(LOOP);
			setState(253);
			body();
			setState(254);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(DynaParser.INTEGER_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(DynaParser.REAL_LITERAL, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(DynaParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DynaParser.STRING_LITERAL, 0); }
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public TupleLiteralContext tupleLiteral() {
			return getRuleContext(TupleLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(INTEGER_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				match(REAL_LITERAL);
				}
				break;
			case BOOLEAN_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				match(BOOLEAN_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				match(STRING_LITERAL);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				arrayLiteral();
				}
				break;
			case LCURLY:
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				tupleLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(DynaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(DynaParser.RBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DynaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DynaParser.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitArrayLiteral(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(LBRACK);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8867287868113920L) != 0)) {
				{
				setState(265);
				expression();
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(266);
					match(COMMA);
					setState(267);
					expression();
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(275);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleLiteralContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(DynaParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DynaParser.RCURLY, 0); }
		public List<TupleElemContext> tupleElem() {
			return getRuleContexts(TupleElemContext.class);
		}
		public TupleElemContext tupleElem(int i) {
			return getRuleContext(TupleElemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DynaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DynaParser.COMMA, i);
		}
		public TupleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterTupleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitTupleLiteral(this);
		}
	}

	public final TupleLiteralContext tupleLiteral() throws RecognitionException {
		TupleLiteralContext _localctx = new TupleLiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_tupleLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(LCURLY);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8867287868113920L) != 0)) {
				{
				setState(278);
				tupleElem();
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(279);
					match(COMMA);
					setState(280);
					tupleElem();
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(288);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleElemContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(DynaParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(DynaParser.ASSIGN, 0); }
		public TupleElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleElem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterTupleElem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitTupleElem(this);
		}
	}

	public final TupleElemContext tupleElem() throws RecognitionException {
		TupleElemContext _localctx = new TupleElemContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_tupleElem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(290);
				match(IDENTIFIER);
				setState(291);
				match(ASSIGN);
				}
				break;
			}
			setState(294);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<DelimContext> delim() {
			return getRuleContexts(DelimContext.class);
		}
		public DelimContext delim(int i) {
			return getRuleContext(DelimContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474983692288L) != 0)) {
				{
				{
				setState(296);
				statement();
				setState(297);
				delim();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DelimContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(DynaParser.SEMI, 0); }
		public TerminalNode EOF() { return getToken(DynaParser.EOF, 0); }
		public DelimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).enterDelim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DynaParserListener ) ((DynaParserListener)listener).exitDelim(this);
		}
	}

	public final DelimContext delim() throws RecognitionException {
		DelimContext _localctx = new DelimContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_delim);
		try {
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				if (!(this.newLineAhead())) throw new FailedPredicateException(this, "this.newLineAhead()");
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return reference_sempred((ReferenceContext)_localctx, predIndex);
		case 26:
			return delim_sempred((DelimContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean reference_sempred(ReferenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean delim_sempred(DelimContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return this.newLineAhead();
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00018\u0136\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"E\b\u0001\n\u0001\f\u0001H\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002M\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003U\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005a\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006r\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"v\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b|\b\b\n\b\f\b\u007f\t"+
		"\b\u0001\t\u0001\t\u0001\t\u0005\t\u0084\b\t\n\t\f\t\u0087\t\t\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u008c\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u0091\b\u000b\n\u000b\f\u000b\u0094\t\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u0099\b\f\n\f\f\f\u009c\t\f\u0001\r\u0001\r\u0001\r"+
		"\u0003\r\u00a1\b\r\u0001\r\u0003\r\u00a4\b\r\u0001\r\u0003\r\u00a7\b\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00b4\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00c0\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00c4\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u00cc\b\u0011\n\u0011\f\u0011\u00cf\t\u0011\u0003\u0011\u00d1\b"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00db\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005"+
		"\u0013\u00ea\b\u0013\n\u0013\f\u0013\u00ed\t\u0013\u0003\u0013\u00ef\b"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00f8\b\u0013\n\u0013\f\u0013\u00fb\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0107\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u010d\b\u0016"+
		"\n\u0016\f\u0016\u0110\t\u0016\u0003\u0016\u0112\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u011a"+
		"\b\u0017\n\u0017\f\u0017\u011d\t\u0017\u0003\u0017\u011f\b\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u0125\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u012c"+
		"\b\u0019\n\u0019\f\u0019\u012f\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u0134\b\u001a\u0001\u001a\u0000\u0001&\u001b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.024\u0000\u0005\u0001\u0000\u0007\t\u0001\u0000 %\u0001\u0000"+
		"&\'\u0001\u0000()\u0002\u0000\n\n&\'\u0151\u0000;\u0001\u0000\u0000\u0000"+
		"\u0002@\u0001\u0000\u0000\u0000\u0004I\u0001\u0000\u0000\u0000\u0006T"+
		"\u0001\u0000\u0000\u0000\bV\u0001\u0000\u0000\u0000\nZ\u0001\u0000\u0000"+
		"\u0000\fq\u0001\u0000\u0000\u0000\u000es\u0001\u0000\u0000\u0000\u0010"+
		"w\u0001\u0000\u0000\u0000\u0012\u0080\u0001\u0000\u0000\u0000\u0014\u0088"+
		"\u0001\u0000\u0000\u0000\u0016\u008d\u0001\u0000\u0000\u0000\u0018\u0095"+
		"\u0001\u0000\u0000\u0000\u001a\u00a6\u0001\u0000\u0000\u0000\u001c\u00b3"+
		"\u0001\u0000\u0000\u0000\u001e\u00bf\u0001\u0000\u0000\u0000 \u00c1\u0001"+
		"\u0000\u0000\u0000\"\u00c7\u0001\u0000\u0000\u0000$\u00da\u0001\u0000"+
		"\u0000\u0000&\u00dc\u0001\u0000\u0000\u0000(\u00fc\u0001\u0000\u0000\u0000"+
		"*\u0106\u0001\u0000\u0000\u0000,\u0108\u0001\u0000\u0000\u0000.\u0115"+
		"\u0001\u0000\u0000\u00000\u0124\u0001\u0000\u0000\u00002\u012d\u0001\u0000"+
		"\u0000\u00004\u0133\u0001\u0000\u0000\u000067\u0003\u0006\u0003\u0000"+
		"78\u00034\u001a\u00008:\u0001\u0000\u0000\u000096\u0001\u0000\u0000\u0000"+
		":=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"+
		"\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005\u0000"+
		"\u0000\u0001?\u0001\u0001\u0000\u0000\u0000@A\u0005\u0016\u0000\u0000"+
		"AF\u0003\u0004\u0002\u0000BC\u0005\u0003\u0000\u0000CE\u0003\u0004\u0002"+
		"\u0000DB\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0003\u0001\u0000\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000IL\u00050\u0000\u0000JK\u0005\u0004\u0000\u0000"+
		"KM\u0003\u0012\t\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"M\u0005\u0001\u0000\u0000\u0000NU\u0003\u0002\u0001\u0000OU\u0003\b\u0004"+
		"\u0000PU\u0003\n\u0005\u0000QU\u0003\f\u0006\u0000RU\u0003\u000e\u0007"+
		"\u0000SU\u0003\u0010\b\u0000TN\u0001\u0000\u0000\u0000TO\u0001\u0000\u0000"+
		"\u0000TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TS\u0001\u0000\u0000\u0000U\u0007\u0001\u0000\u0000\u0000"+
		"VW\u0003&\u0013\u0000WX\u0005\u0004\u0000\u0000XY\u0003\u0012\t\u0000"+
		"Y\t\u0001\u0000\u0000\u0000Z[\u0005\u000b\u0000\u0000[\\\u0003\u0012\t"+
		"\u0000\\]\u0005\f\u0000\u0000]`\u00032\u0019\u0000^_\u0005\r\u0000\u0000"+
		"_a\u00032\u0019\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000bc\u0005\u000e\u0000\u0000c\u000b\u0001\u0000"+
		"\u0000\u0000de\u0005\u000f\u0000\u0000ef\u0003\u0012\t\u0000fg\u0003("+
		"\u0014\u0000gr\u0001\u0000\u0000\u0000hi\u0005\u0011\u0000\u0000ij\u0005"+
		"0\u0000\u0000jk\u0005\u0012\u0000\u0000kl\u0003\u0012\t\u0000lm\u0005"+
		"\u0005\u0000\u0000mn\u0003\u0012\t\u0000no\u0001\u0000\u0000\u0000op\u0003"+
		"(\u0014\u0000pr\u0001\u0000\u0000\u0000qd\u0001\u0000\u0000\u0000qh\u0001"+
		"\u0000\u0000\u0000r\r\u0001\u0000\u0000\u0000su\u0005\u0013\u0000\u0000"+
		"tv\u0003\u0012\t\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"v\u000f\u0001\u0000\u0000\u0000wx\u0005\u0015\u0000\u0000x}\u0003\u0012"+
		"\t\u0000yz\u0005\u0003\u0000\u0000z|\u0003\u0012\t\u0000{y\u0001\u0000"+
		"\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u0011\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u0080\u0085\u0003\u0014\n\u0000\u0081\u0082\u0007\u0000"+
		"\u0000\u0000\u0082\u0084\u0003\u0014\n\u0000\u0083\u0081\u0001\u0000\u0000"+
		"\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0013\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b\u0003\u0016\u000b"+
		"\u0000\u0089\u008a\u0007\u0001\u0000\u0000\u008a\u008c\u0003\u0016\u000b"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000"+
		"\u0000\u008c\u0015\u0001\u0000\u0000\u0000\u008d\u0092\u0003\u0018\f\u0000"+
		"\u008e\u008f\u0007\u0002\u0000\u0000\u008f\u0091\u0003\u0018\f\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093"+
		"\u0017\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095"+
		"\u009a\u0003\u001a\r\u0000\u0096\u0097\u0007\u0003\u0000\u0000\u0097\u0099"+
		"\u0003\u001a\r\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009c\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001"+
		"\u0000\u0000\u0000\u009b\u0019\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009d\u00a0\u0003&\u0013\u0000\u009e\u009f\u0005\u0014"+
		"\u0000\u0000\u009f\u00a1\u0003\u001e\u000f\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a4\u0007\u0004\u0000\u0000\u00a3\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a7\u0003\u001c\u000e\u0000\u00a6\u009d\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a3\u0001\u0000\u0000\u0000\u00a7\u001b\u0001\u0000"+
		"\u0000\u0000\u00a8\u00b4\u0003*\u0015\u0000\u00a9\u00b4\u0005\u0017\u0000"+
		"\u0000\u00aa\u00b4\u0005\u0018\u0000\u0000\u00ab\u00b4\u0005\u0019\u0000"+
		"\u0000\u00ac\u00b4\u0003 \u0010\u0000\u00ad\u00ae\u0005\u001c\u0000\u0000"+
		"\u00ae\u00af\u0003\u0012\t\u0000\u00af\u00b0\u0005\u001d\u0000\u0000\u00b0"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\'\u0000\u0000\u00b2\u00b4"+
		"\u0003\u0012\t\u0000\u00b3\u00a8\u0001\u0000\u0000\u0000\u00b3\u00a9\u0001"+
		"\u0000\u0000\u0000\u00b3\u00aa\u0001\u0000\u0000\u0000\u00b3\u00ab\u0001"+
		"\u0000\u0000\u0000\u00b3\u00ac\u0001\u0000\u0000\u0000\u00b3\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u001d\u0001"+
		"\u0000\u0000\u0000\u00b5\u00c0\u0005*\u0000\u0000\u00b6\u00c0\u0005+\u0000"+
		"\u0000\u00b7\u00c0\u0005,\u0000\u0000\u00b8\u00c0\u0005-\u0000\u0000\u00b9"+
		"\u00c0\u0005.\u0000\u0000\u00ba\u00bb\u0005\u001e\u0000\u0000\u00bb\u00c0"+
		"\u0005\u001f\u0000\u0000\u00bc\u00bd\u0005\u001a\u0000\u0000\u00bd\u00c0"+
		"\u0005\u001b\u0000\u0000\u00be\u00c0\u0005/\u0000\u0000\u00bf\u00b5\u0001"+
		"\u0000\u0000\u0000\u00bf\u00b6\u0001\u0000\u0000\u0000\u00bf\u00b7\u0001"+
		"\u0000\u0000\u0000\u00bf\u00b8\u0001\u0000\u0000\u0000\u00bf\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bf\u00ba\u0001\u0000\u0000\u0000\u00bf\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u001f\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c3\u0005/\u0000\u0000\u00c2\u00c4\u0003\""+
		"\u0011\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0003$\u0012"+
		"\u0000\u00c6!\u0001\u0000\u0000\u0000\u00c7\u00d0\u0005\u001c\u0000\u0000"+
		"\u00c8\u00cd\u00050\u0000\u0000\u00c9\u00ca\u0005\u0003\u0000\u0000\u00ca"+
		"\u00cc\u00050\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd"+
		"\u0001\u0000\u0000\u0000\u00d0\u00c8\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0005\u001d\u0000\u0000\u00d3#\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		"\u0014\u0000\u0000\u00d5\u00d6\u00032\u0019\u0000\u00d6\u00d7\u0005\u000e"+
		"\u0000\u0000\u00d7\u00db\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0001"+
		"\u0000\u0000\u00d9\u00db\u0003\u0012\t\u0000\u00da\u00d4\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db%\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0006\u0013\uffff\uffff\u0000\u00dd\u00de\u00050\u0000\u0000"+
		"\u00de\u00f9\u0001\u0000\u0000\u0000\u00df\u00e0\n\u0004\u0000\u0000\u00e0"+
		"\u00e1\u0005\u001e\u0000\u0000\u00e1\u00e2\u0003\u0012\t\u0000\u00e2\u00e3"+
		"\u0005\u001f\u0000\u0000\u00e3\u00f8\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\n\u0003\u0000\u0000\u00e5\u00ee\u0005\u001c\u0000\u0000\u00e6\u00eb\u0003"+
		"\u0012\t\u0000\u00e7\u00e8\u0005\u0003\u0000\u0000\u00e8\u00ea\u0003\u0012"+
		"\t\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000"+
		"\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ee\u00e6\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f8\u0005\u001d\u0000"+
		"\u0000\u00f1\u00f2\n\u0002\u0000\u0000\u00f2\u00f3\u0005\u0006\u0000\u0000"+
		"\u00f3\u00f8\u00050\u0000\u0000\u00f4\u00f5\n\u0001\u0000\u0000\u00f5"+
		"\u00f6\u0005\u0006\u0000\u0000\u00f6\u00f8\u00052\u0000\u0000\u00f7\u00df"+
		"\u0001\u0000\u0000\u0000\u00f7\u00e4\u0001\u0000\u0000\u0000\u00f7\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f4\u0001\u0000\u0000\u0000\u00f8\u00fb"+
		"\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fa\'\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0005\u0010\u0000\u0000\u00fd\u00fe\u0003"+
		"2\u0019\u0000\u00fe\u00ff\u0005\u000e\u0000\u0000\u00ff)\u0001\u0000\u0000"+
		"\u0000\u0100\u0107\u00052\u0000\u0000\u0101\u0107\u00053\u0000\u0000\u0102"+
		"\u0107\u00051\u0000\u0000\u0103\u0107\u00054\u0000\u0000\u0104\u0107\u0003"+
		",\u0016\u0000\u0105\u0107\u0003.\u0017\u0000\u0106\u0100\u0001\u0000\u0000"+
		"\u0000\u0106\u0101\u0001\u0000\u0000\u0000\u0106\u0102\u0001\u0000\u0000"+
		"\u0000\u0106\u0103\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0107+\u0001\u0000\u0000\u0000"+
		"\u0108\u0111\u0005\u001e\u0000\u0000\u0109\u010e\u0003\u0012\t\u0000\u010a"+
		"\u010b\u0005\u0003\u0000\u0000\u010b\u010d\u0003\u0012\t\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0112"+
		"\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0109"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u001f\u0000\u0000\u0114-\u0001"+
		"\u0000\u0000\u0000\u0115\u011e\u0005\u001a\u0000\u0000\u0116\u011b\u0003"+
		"0\u0018\u0000\u0117\u0118\u0005\u0003\u0000\u0000\u0118\u011a\u00030\u0018"+
		"\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000"+
		"\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000"+
		"\u0000\u011e\u0116\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u001b\u0000"+
		"\u0000\u0121/\u0001\u0000\u0000\u0000\u0122\u0123\u00050\u0000\u0000\u0123"+
		"\u0125\u0005\u0004\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0003\u0012\t\u0000\u01271\u0001\u0000\u0000\u0000\u0128\u0129"+
		"\u0003\u0006\u0003\u0000\u0129\u012a\u00034\u001a\u0000\u012a\u012c\u0001"+
		"\u0000\u0000\u0000\u012b\u0128\u0001\u0000\u0000\u0000\u012c\u012f\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012e3\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000"+
		"\u0000\u0000\u0130\u0134\u0005\u0002\u0000\u0000\u0131\u0134\u0005\u0000"+
		"\u0000\u0001\u0132\u0134\u0004\u001a\u0004\u0000\u0133\u0130\u0001\u0000"+
		"\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0132\u0001\u0000"+
		"\u0000\u0000\u01345\u0001\u0000\u0000\u0000!;FLT`qu}\u0085\u008b\u0092"+
		"\u009a\u00a0\u00a3\u00a6\u00b3\u00bf\u00c3\u00cd\u00d0\u00da\u00eb\u00ee"+
		"\u00f7\u00f9\u0106\u010e\u0111\u011b\u011e\u0124\u012d\u0133";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}