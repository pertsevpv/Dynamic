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
    if (ahead.getChannel() != Lexer.HIDDEN) return false;
    if (ahead.getType() == DynaParser.NEW_LINE) return true;
    if (ahead.getType() == DynaParser.WS) {
      ahead = _input.get(ind - 1);
      return ahead.getType() == DynaParser.NEW_LINE;
    }
    return false;
  }

}
