lexer grammar DynaLexer;

// symbols
ARROW: '=>';
SEMI: ';' ;
COMMA : ',' ;
ASSIGN: ':=';
DOT: '.';
DOTDOT: '..';

// logical operators
OR: 'or';
AND: 'and';
XOR: 'xor';
NOT: 'not';

// keywords
IF: 'if';
THEN: 'then';
ELSE: 'else';
END: 'end';
WHILE: 'while';
LOOP: 'loop';
FOR: 'for';
IN: 'in';
RETURN: 'return';
IS: 'is';
PRINT: 'print';
VAR: 'var';

// reading
READ_INT: 'readInt';
READ_REAL: 'readReal';
READ_STRING: 'readString';

// brackets
LCURLY: '{' ;
RCURLY: '}' ;
LPAREN: '(' ;
RPAREN: ')' ;
LBRACK: '[';
RBRACK: ']';

// comparison operators
LE: '<';
LE_EQ: '<=';
GR: '>';
GR_EQ: '>=';
EQ: '=';
NOT_EQ: '/=';

// arithmetic operators
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';

// types
INT: 'int';
REAL: 'real';
BOOL: 'bool';
STRING: 'string';
EMPTY: 'empty';
FUNC: 'func';

// identifier
IDENTIFIER: Letter LetterOrDigit*;

// literals
BOOLEAN_LITERAL: 'true' | 'false';
INTEGER_LITERAL: Digits;
REAL_LITERAL: (Digits '.' Digits?) Exponent?;
STRING_LITERAL: '"' (~["\\\r\n] | EscapeSeq)* '"';

// whitespaces & comments
WS: [ \t\u000C]+ -> channel(HIDDEN);
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
NEW_LINE: '\r'? '\n' -> channel(HIDDEN);

// fragments
fragment LetterOrDigit: Letter | [0-9];
fragment Letter: [a-zA-Z_];
fragment EscapeSeq: '\\' [btnfr"'\\];
fragment Exponent: [eE] [+-]? Digits;
fragment Digits: [0-9]+;
