parser grammar DynaParser;
options {
    tokenVocab=DynaLexer;
    superClass=DynaParserBase;
}

program
    : (statement delim)* EOF
    ;

declaration
    : VAR variableDefinition (',' variableDefinition)*
    ;

variableDefinition
    : IDENTIFIER (':=' expression)?
    ;

statement
    : declaration
    | assigment
    | if
    | loop
    | return
    | print
    ;

assigment
    : reference ':=' expression
    ;

if
    : IF expression THEN body (ELSE body)? END
    ;

loop
    : WHILE expression loopBody
    | FOR IDENTIFIER IN (expression '..' expression) loopBody
    ;

return
    : RETURN expression?
    ;

print
    : PRINT expression (',' expression)*
    ;

expression
    : relation ((AND | OR | XOR) relation)?
    ;

relation
    : factor (('<' | '<=' | '>' | '>=' | '=' | '/=') factor)?
    ;

factor
    : term (('+' | '-')? term)*
    ;

term
    : unary (('*' | '/') unary)*
    ;

unary
    : reference (IS typeIndicator)?
    | ('+' | '-' | NOT)? primary
    ;

primary
    : literal
    | READ_INT | READ_REAL | READ_STRING
    | functionLiteral
    | '(' expression ')'
    | '-' expression
    ;

typeIndicator
    : INT | REAL | BOOL | STRING
    | EMPTY
    | '[' ']'
    | '{' '}'
    | FUNC
    ;

functionLiteral
    : FUNC parameters? funBody
    ;

parameters
    : '(' IDENTIFIER (',' IDENTIFIER)* ')'
    ;

funBody
    : IS body END
    | '=>' expression
    ;

reference
    : IDENTIFIER
    | reference '[' expression ']'
    | reference '(' expression (',' expression)* ')'
    | reference '.' IDENTIFIER
    | reference '.' INTEGER_LITERAL
    ;

loopBody
    : LOOP body END
    ;

literal
    : INTEGER_LITERAL
    | REAL_LITERAL
    | BOOLEAN_LITERAL
    | STRING_LITERAL
    | arrayLiteral
    | tupleLiteral
    ;

arrayLiteral
    : '[' (expression (',' expression)*)? ']'
    ;

tupleLiteral
    : '{' ((IDENTIFIER ':=')? expression (',' (IDENTIFIER ':=')? expression)*)? '}'
    ;

body
    : ((declaration | statement | expression) delim)*
    ;

delim
    : ';'
    | EOF
    | {this.newLineAhead()}?
    ;