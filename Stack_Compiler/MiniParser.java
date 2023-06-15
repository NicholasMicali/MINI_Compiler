// Generated from Mini.g4 by ANTLR 4.12.0

   /* package declaration here */

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		ID=39, INTEGER=40, WS=41, COMMENT=42;
	public static final int
		RULE_program = 0, RULE_types = 1, RULE_typeDeclaration = 2, RULE_nestedDecl = 3, 
		RULE_decl = 4, RULE_type = 5, RULE_declarations = 6, RULE_declaration = 7, 
		RULE_functions = 8, RULE_function = 9, RULE_parameters = 10, RULE_returnType = 11, 
		RULE_statement = 12, RULE_block = 13, RULE_statementList = 14, RULE_lvalue = 15, 
		RULE_expression = 16, RULE_arguments = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "types", "typeDeclaration", "nestedDecl", "decl", "type", 
			"declarations", "declaration", "functions", "function", "parameters", 
			"returnType", "statement", "block", "statementList", "lvalue", "expression", 
			"arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "'int'", "'bool'", "','", "'fun'", 
			"'('", "')'", "'void'", "'='", "'read'", "'print'", "'endl'", "'if'", 
			"'else'", "'while'", "'delete'", "'return'", "'.'", "'-'", "'!'", "'*'", 
			"'/'", "'+'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", 
			"'true'", "'false'", "'new'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "ID", "INTEGER", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "Mini.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MiniParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			types();
			setState(37);
			declarations();
			setState(38);
			functions();
			setState(39);
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
	public static class TypesContext extends ParserRuleContext {
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_types);
		try {
			int _alt;
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(41);
						typeDeclaration();
						}
						} 
					}
					setState(46);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public NestedDeclContext nestedDecl() {
			return getRuleContext(NestedDeclContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			match(ID);
			setState(52);
			match(T__1);
			setState(53);
			nestedDecl();
			setState(54);
			match(T__2);
			setState(55);
			match(T__3);
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
	public static class NestedDeclContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public NestedDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterNestedDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitNestedDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitNestedDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedDeclContext nestedDecl() throws RecognitionException {
		NestedDeclContext _localctx = new NestedDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_nestedDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				decl();
				setState(58);
				match(T__3);
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 98L) != 0) );
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
	public static class DeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			type();
			setState(65);
			match(ID);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTypeContext extends TypeContext {
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructTypeContext extends TypeContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public StructTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterStructType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitStructType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends TypeContext {
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(T__4);
				}
				break;
			case T__5:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(T__5);
				}
				break;
			case T__0:
				_localctx = new StructTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(T__0);
				setState(70);
				match(ID);
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
	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 98L) != 0)) {
				{
				{
				setState(73);
				declaration();
				}
				}
				setState(78);
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
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MiniParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniParser.ID, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			type();
			setState(80);
			match(ID);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(81);
				match(T__6);
				setState(82);
				match(ID);
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(T__3);
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
	public static class FunctionsContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(90);
				function();
				}
				}
				setState(95);
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
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__7);
			setState(97);
			match(ID);
			setState(98);
			parameters();
			setState(99);
			returnType();
			setState(100);
			match(T__1);
			setState(101);
			declarations();
			setState(102);
			statementList();
			setState(103);
			match(T__2);
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
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__8);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 98L) != 0)) {
				{
				setState(106);
				decl();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(107);
					match(T__6);
					setState(108);
					decl();
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(116);
			match(T__9);
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
	public static class ReturnTypeContext extends ParserRuleContext {
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	 
		public ReturnTypeContext() { }
		public void copyFrom(ReturnTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeVoidContext extends ReturnTypeContext {
		public ReturnTypeVoidContext(ReturnTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterReturnTypeVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitReturnTypeVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitReturnTypeVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeRealContext extends ReturnTypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReturnTypeRealContext(ReturnTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterReturnTypeReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitReturnTypeReal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitReturnTypeReal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnType);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__4:
			case T__5:
				_localctx = new ReturnTypeRealContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				type();
				}
				break;
			case T__10:
				_localctx = new ReturnTypeVoidContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(T__10);
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
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends StatementContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeleteContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeleteContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitDelete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitDelete(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvocationContext extends StatementContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public InvocationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintLnContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintLnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterPrintLn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitPrintLn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitPrintLn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalContext extends StatementContext {
		public BlockContext thenBlock;
		public BlockContext elseBlock;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ConditionalContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedBlockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public NestedBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterNestedBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitNestedBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitNestedBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new NestedBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				block();
				}
				break;
			case 2:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				lvalue(0);
				setState(124);
				match(T__11);
				setState(127);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
				case T__21:
				case T__22:
				case T__34:
				case T__35:
				case T__36:
				case T__37:
				case ID:
				case INTEGER:
					{
					setState(125);
					expression(0);
					}
					break;
				case T__12:
					{
					setState(126);
					match(T__12);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(129);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(T__13);
				setState(132);
				expression(0);
				setState(133);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new PrintLnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(T__13);
				setState(136);
				expression(0);
				setState(137);
				match(T__14);
				setState(138);
				match(T__3);
				}
				break;
			case 5:
				_localctx = new ConditionalContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				match(T__15);
				setState(141);
				match(T__8);
				setState(142);
				expression(0);
				setState(143);
				match(T__9);
				setState(144);
				((ConditionalContext)_localctx).thenBlock = block();
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(145);
					match(T__16);
					setState(146);
					((ConditionalContext)_localctx).elseBlock = block();
					}
				}

				}
				break;
			case 6:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				match(T__17);
				setState(150);
				match(T__8);
				setState(151);
				expression(0);
				setState(152);
				match(T__9);
				setState(153);
				block();
				}
				break;
			case 7:
				_localctx = new DeleteContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(155);
				match(T__18);
				setState(156);
				expression(0);
				setState(157);
				match(T__3);
				}
				break;
			case 8:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(159);
				match(T__19);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164676100608L) != 0)) {
					{
					setState(160);
					expression(0);
					}
				}

				setState(163);
				match(T__3);
				}
				break;
			case 9:
				_localctx = new InvocationContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(164);
				match(ID);
				setState(165);
				match(T__8);
				setState(166);
				arguments();
				setState(167);
				match(T__9);
				setState(168);
				match(T__3);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__1);
			setState(173);
			statementList();
			setState(174);
			match(T__2);
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
	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549757730820L) != 0)) {
				{
				{
				setState(176);
				statement();
				}
				}
				setState(181);
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
	public static class LvalueContext extends ParserRuleContext {
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	 
		public LvalueContext() { }
		public void copyFrom(LvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LvalueIdContext extends LvalueContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public LvalueIdContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterLvalueId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitLvalueId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitLvalueId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LvalueDotContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public LvalueDotContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterLvalueDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitLvalueDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitLvalueDot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LvalueIdContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(183);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LvalueDotContext(new LvalueContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
					setState(185);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(186);
					match(T__20);
					setState(187);
					match(ID);
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerExprContext extends ExpressionContext {
		public TerminalNode INTEGER() { return getToken(MiniParser.INTEGER, 0); }
		public IntegerExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterIntegerExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitIntegerExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitIntegerExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueExprContext extends ExpressionContext {
		public TrueExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitTrueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitTrueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public IdentifierExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ExpressionContext {
		public ExpressionContext lft;
		public Token op;
		public ExpressionContext rht;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NestedExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterNestedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitNestedExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitNestedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public DotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterDotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitDotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitDotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvocationExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MiniParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public InvocationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterInvocationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitInvocationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitInvocationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseExprContext extends ExpressionContext {
		public FalseExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitFalseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitFalseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullExprContext extends ExpressionContext {
		public NullExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterNullExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitNullExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitNullExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new InvocationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(194);
				match(ID);
				setState(195);
				match(T__8);
				setState(196);
				arguments();
				setState(197);
				match(T__9);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__21 || _la==T__22) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(200);
				expression(14);
				}
				break;
			case 3:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new IntegerExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(INTEGER);
				}
				break;
			case 5:
				{
				_localctx = new TrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(T__34);
				}
				break;
			case 6:
				{
				_localctx = new FalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(T__35);
				}
				break;
			case 7:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(T__36);
				setState(206);
				match(ID);
				}
				break;
			case 8:
				{
				_localctx = new NullExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(T__37);
				}
				break;
			case 9:
				{
				_localctx = new NestedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				match(T__8);
				setState(209);
				expression(0);
				setState(210);
				match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(235);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(215);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(216);
						((BinaryExprContext)_localctx).rht = expression(14);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(218);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__25) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(219);
						((BinaryExprContext)_localctx).rht = expression(13);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(221);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2013265920L) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(222);
						((BinaryExprContext)_localctx).rht = expression(12);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(224);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						((BinaryExprContext)_localctx).rht = expression(11);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(227);
						((BinaryExprContext)_localctx).op = match(T__32);
						setState(228);
						((BinaryExprContext)_localctx).rht = expression(10);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lft = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(230);
						((BinaryExprContext)_localctx).op = match(T__33);
						setState(231);
						((BinaryExprContext)_localctx).rht = expression(9);
						}
						break;
					case 7:
						{
						_localctx = new DotExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						{
						setState(233);
						match(T__20);
						setState(234);
						match(ID);
						}
						}
						break;
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniListener ) ((MiniListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniVisitor ) return ((MiniVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164676100608L) != 0)) {
				{
				setState(240);
				expression(0);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(241);
					match(T__6);
					setState(242);
					expression(0);
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		case 16:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u00fb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001+\b\u0001"+
		"\n\u0001\f\u0001.\t\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003=\b\u0003\u000b\u0003"+
		"\f\u0003>\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0006\u0005\u0006"+
		"K\b\u0006\n\u0006\f\u0006N\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007T\b\u0007\n\u0007\f\u0007W\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0005\b\\\b\b\n\b\f\b_\t\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\nn\b\n\n\n\f\nq\t\n\u0003\ns\b\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0003\u000by\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u0080\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u0094\b\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00a2\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00ab\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0005\u000e\u00b2"+
		"\b\u000e\n\u000e\f\u000e\u00b5\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00bd\b\u000f\n\u000f"+
		"\f\u000f\u00c0\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00d5\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00ec\b\u0010\n\u0010\f\u0010\u00ef"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00f4\b\u0011"+
		"\n\u0011\f\u0011\u00f7\t\u0011\u0003\u0011\u00f9\b\u0011\u0001\u0011\u0000"+
		"\u0002\u001e \u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"\u0000\u0005\u0001\u0000\u0016\u0017"+
		"\u0001\u0000\u0018\u0019\u0002\u0000\u0016\u0016\u001a\u001a\u0001\u0000"+
		"\u001b\u001e\u0001\u0000\u001f \u0111\u0000$\u0001\u0000\u0000\u0000\u0002"+
		"0\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000\u0006<\u0001"+
		"\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000\u0000"+
		"\fL\u0001\u0000\u0000\u0000\u000eO\u0001\u0000\u0000\u0000\u0010]\u0001"+
		"\u0000\u0000\u0000\u0012`\u0001\u0000\u0000\u0000\u0014i\u0001\u0000\u0000"+
		"\u0000\u0016x\u0001\u0000\u0000\u0000\u0018\u00aa\u0001\u0000\u0000\u0000"+
		"\u001a\u00ac\u0001\u0000\u0000\u0000\u001c\u00b3\u0001\u0000\u0000\u0000"+
		"\u001e\u00b6\u0001\u0000\u0000\u0000 \u00d4\u0001\u0000\u0000\u0000\""+
		"\u00f8\u0001\u0000\u0000\u0000$%\u0003\u0002\u0001\u0000%&\u0003\f\u0006"+
		"\u0000&\'\u0003\u0010\b\u0000\'(\u0005\u0000\u0000\u0001(\u0001\u0001"+
		"\u0000\u0000\u0000)+\u0003\u0004\u0002\u0000*)\u0001\u0000\u0000\u0000"+
		"+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-1\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/1\u0001\u0000"+
		"\u0000\u00000,\u0001\u0000\u0000\u00000/\u0001\u0000\u0000\u00001\u0003"+
		"\u0001\u0000\u0000\u000023\u0005\u0001\u0000\u000034\u0005\'\u0000\u0000"+
		"45\u0005\u0002\u0000\u000056\u0003\u0006\u0003\u000067\u0005\u0003\u0000"+
		"\u000078\u0005\u0004\u0000\u00008\u0005\u0001\u0000\u0000\u00009:\u0003"+
		"\b\u0004\u0000:;\u0005\u0004\u0000\u0000;=\u0001\u0000\u0000\u0000<9\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?\u0007\u0001\u0000\u0000\u0000@A\u0003\n\u0005"+
		"\u0000AB\u0005\'\u0000\u0000B\t\u0001\u0000\u0000\u0000CH\u0005\u0005"+
		"\u0000\u0000DH\u0005\u0006\u0000\u0000EF\u0005\u0001\u0000\u0000FH\u0005"+
		"\'\u0000\u0000GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000H\u000b\u0001\u0000\u0000\u0000IK\u0003\u000e\u0007"+
		"\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000"+
		"\u0000\u0000LM\u0001\u0000\u0000\u0000M\r\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000OP\u0003\n\u0005\u0000PU\u0005\'\u0000\u0000QR\u0005"+
		"\u0007\u0000\u0000RT\u0005\'\u0000\u0000SQ\u0001\u0000\u0000\u0000TW\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005\u0004\u0000"+
		"\u0000Y\u000f\u0001\u0000\u0000\u0000Z\\\u0003\u0012\t\u0000[Z\u0001\u0000"+
		"\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^\u0011\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000`a\u0005\b\u0000\u0000ab\u0005\'\u0000\u0000bc\u0003\u0014\n\u0000"+
		"cd\u0003\u0016\u000b\u0000de\u0005\u0002\u0000\u0000ef\u0003\f\u0006\u0000"+
		"fg\u0003\u001c\u000e\u0000gh\u0005\u0003\u0000\u0000h\u0013\u0001\u0000"+
		"\u0000\u0000ir\u0005\t\u0000\u0000jo\u0003\b\u0004\u0000kl\u0005\u0007"+
		"\u0000\u0000ln\u0003\b\u0004\u0000mk\u0001\u0000\u0000\u0000nq\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000ps\u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rj\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0005\n\u0000\u0000"+
		"u\u0015\u0001\u0000\u0000\u0000vy\u0003\n\u0005\u0000wy\u0005\u000b\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y\u0017\u0001"+
		"\u0000\u0000\u0000z\u00ab\u0003\u001a\r\u0000{|\u0003\u001e\u000f\u0000"+
		"|\u007f\u0005\f\u0000\u0000}\u0080\u0003 \u0010\u0000~\u0080\u0005\r\u0000"+
		"\u0000\u007f}\u0001\u0000\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0004\u0000\u0000\u0082"+
		"\u00ab\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u000e\u0000\u0000\u0084"+
		"\u0085\u0003 \u0010\u0000\u0085\u0086\u0005\u0004\u0000\u0000\u0086\u00ab"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u000e\u0000\u0000\u0088\u0089"+
		"\u0003 \u0010\u0000\u0089\u008a\u0005\u000f\u0000\u0000\u008a\u008b\u0005"+
		"\u0004\u0000\u0000\u008b\u00ab\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"\u0010\u0000\u0000\u008d\u008e\u0005\t\u0000\u0000\u008e\u008f\u0003 "+
		"\u0010\u0000\u008f\u0090\u0005\n\u0000\u0000\u0090\u0093\u0003\u001a\r"+
		"\u0000\u0091\u0092\u0005\u0011\u0000\u0000\u0092\u0094\u0003\u001a\r\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u00ab\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u0012\u0000\u0000"+
		"\u0096\u0097\u0005\t\u0000\u0000\u0097\u0098\u0003 \u0010\u0000\u0098"+
		"\u0099\u0005\n\u0000\u0000\u0099\u009a\u0003\u001a\r\u0000\u009a\u00ab"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0013\u0000\u0000\u009c\u009d"+
		"\u0003 \u0010\u0000\u009d\u009e\u0005\u0004\u0000\u0000\u009e\u00ab\u0001"+
		"\u0000\u0000\u0000\u009f\u00a1\u0005\u0014\u0000\u0000\u00a0\u00a2\u0003"+
		" \u0010\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00ab\u0005\u0004"+
		"\u0000\u0000\u00a4\u00a5\u0005\'\u0000\u0000\u00a5\u00a6\u0005\t\u0000"+
		"\u0000\u00a6\u00a7\u0003\"\u0011\u0000\u00a7\u00a8\u0005\n\u0000\u0000"+
		"\u00a8\u00a9\u0005\u0004\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000"+
		"\u00aaz\u0001\u0000\u0000\u0000\u00aa{\u0001\u0000\u0000\u0000\u00aa\u0083"+
		"\u0001\u0000\u0000\u0000\u00aa\u0087\u0001\u0000\u0000\u0000\u00aa\u008c"+
		"\u0001\u0000\u0000\u0000\u00aa\u0095\u0001\u0000\u0000\u0000\u00aa\u009b"+
		"\u0001\u0000\u0000\u0000\u00aa\u009f\u0001\u0000\u0000\u0000\u00aa\u00a4"+
		"\u0001\u0000\u0000\u0000\u00ab\u0019\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0005\u0002\u0000\u0000\u00ad\u00ae\u0003\u001c\u000e\u0000\u00ae\u00af"+
		"\u0005\u0003\u0000\u0000\u00af\u001b\u0001\u0000\u0000\u0000\u00b0\u00b2"+
		"\u0003\u0018\f\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b4\u001d\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0006\u000f\uffff\uffff\u0000\u00b7\u00b8"+
		"\u0005\'\u0000\u0000\u00b8\u00be\u0001\u0000\u0000\u0000\u00b9\u00ba\n"+
		"\u0001\u0000\u0000\u00ba\u00bb\u0005\u0015\u0000\u0000\u00bb\u00bd\u0005"+
		"\'\u0000\u0000\u00bc\u00b9\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000"+
		"\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u001f\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0006\u0010\uffff\uffff\u0000\u00c2\u00c3\u0005"+
		"\'\u0000\u0000\u00c3\u00c4\u0005\t\u0000\u0000\u00c4\u00c5\u0003\"\u0011"+
		"\u0000\u00c5\u00c6\u0005\n\u0000\u0000\u00c6\u00d5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0007\u0000\u0000\u0000\u00c8\u00d5\u0003 \u0010\u000e\u00c9"+
		"\u00d5\u0005\'\u0000\u0000\u00ca\u00d5\u0005(\u0000\u0000\u00cb\u00d5"+
		"\u0005#\u0000\u0000\u00cc\u00d5\u0005$\u0000\u0000\u00cd\u00ce\u0005%"+
		"\u0000\u0000\u00ce\u00d5\u0005\'\u0000\u0000\u00cf\u00d5\u0005&\u0000"+
		"\u0000\u00d0\u00d1\u0005\t\u0000\u0000\u00d1\u00d2\u0003 \u0010\u0000"+
		"\u00d2\u00d3\u0005\n\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4"+
		"\u00c1\u0001\u0000\u0000\u0000\u00d4\u00c7\u0001\u0000\u0000\u0000\u00d4"+
		"\u00c9\u0001\u0000\u0000\u0000\u00d4\u00ca\u0001\u0000\u0000\u0000\u00d4"+
		"\u00cb\u0001\u0000\u0000\u0000\u00d4\u00cc\u0001\u0000\u0000\u0000\u00d4"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d4\u00cf\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d5\u00ed\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\n\r\u0000\u0000\u00d7\u00d8\u0007\u0001\u0000\u0000\u00d8\u00ec"+
		"\u0003 \u0010\u000e\u00d9\u00da\n\f\u0000\u0000\u00da\u00db\u0007\u0002"+
		"\u0000\u0000\u00db\u00ec\u0003 \u0010\r\u00dc\u00dd\n\u000b\u0000\u0000"+
		"\u00dd\u00de\u0007\u0003\u0000\u0000\u00de\u00ec\u0003 \u0010\f\u00df"+
		"\u00e0\n\n\u0000\u0000\u00e0\u00e1\u0007\u0004\u0000\u0000\u00e1\u00ec"+
		"\u0003 \u0010\u000b\u00e2\u00e3\n\t\u0000\u0000\u00e3\u00e4\u0005!\u0000"+
		"\u0000\u00e4\u00ec\u0003 \u0010\n\u00e5\u00e6\n\b\u0000\u0000\u00e6\u00e7"+
		"\u0005\"\u0000\u0000\u00e7\u00ec\u0003 \u0010\t\u00e8\u00e9\n\u000f\u0000"+
		"\u0000\u00e9\u00ea\u0005\u0015\u0000\u0000\u00ea\u00ec\u0005\'\u0000\u0000"+
		"\u00eb\u00d6\u0001\u0000\u0000\u0000\u00eb\u00d9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00dc\u0001\u0000\u0000\u0000\u00eb\u00df\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e2\u0001\u0000\u0000\u0000\u00eb\u00e5\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e8\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ee!\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f5\u0003 \u0010\u0000\u00f1\u00f2\u0005\u0007\u0000\u0000\u00f2\u00f4"+
		"\u0003 \u0010\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f0\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f9#\u0001\u0000\u0000\u0000\u0015,0>GLU]orx\u007f"+
		"\u0093\u00a1\u00aa\u00b3\u00be\u00d4\u00eb\u00ed\u00f5\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}