package dynamic.parser.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;

public abstract class DynaParserBase extends Parser {

  public DynaParserBase(TokenStream input) {
    super(input);
  }

  protected boolean newLineAhead() {
    int ind = this.getCurrentToken().getTokenIndex() - 1;
    while (_input.get(ind).getChannel() == Lexer.HIDDEN) {
      if (_input.get(ind).getType() == DynaParser.NEW_LINE ||
          _input.get(ind).getType() == DynaParser.COMMENT &&
          _input.get(ind).getText().contains("\n")
      ) return true;
      ind--;
    }
    return false;
  }

}
