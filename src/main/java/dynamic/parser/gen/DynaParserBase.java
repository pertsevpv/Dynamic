package dynamic.parser.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

public abstract class DynaParserBase extends Parser {

  public DynaParserBase(TokenStream input) {
    super(input);
  }

  protected boolean newLineAhead() {
    int ind = this.getCurrentToken().getTokenIndex() - 1;
    Token ahead = _input.get(ind);
    return ahead.getChannel() != Lexer.HIDDEN && ahead.getType() == DynaParser.NEW_LINE;
  }

}
