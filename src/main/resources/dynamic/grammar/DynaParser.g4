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
    | assignment
    | if
    | loop
    | return
    | print
    | functionCall
    ;

assignment
    : reference ':=' expression
    ;

if
    : IF expression THEN ifBlock=body (ELSE elseBlock=body)? END
    ;

loop
    : WHILE cond=expression loopBody
    | FOR param=IDENTIFIER IN (from=expression '..' to=expression) loopBody
    | FOR (label=IDENTIFIER ',')? value=IDENTIFIER IN iterable=expression loopBody
    ;

return
    : RETURN expression?
    ;

print
    : PRINT expression (',' expression)*
    ;

expression
    : relation (sign+=(AND | OR | XOR) relation)*
    ;

relation
    : factor (sign=('<' | '<=' | '>' | '>=' | '=' | '/=' | '==' | '/==') factor)?
    ;

factor
    : term (sign+=('+' | '-') term)*
    ;

term
    : unary (sign+=('*' | '/' | '%') unary)*
    ;

unary
    : reference (IS typeIndicator)?
    | sign=('+' | '-' | NOT)? primary
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
    : '(' (IDENTIFIER (',' IDENTIFIER)*)? ')'
    ;

funBody
    : IS body END
    | '=>' expression
    ;

reference
    : IDENTIFIER
    | reference '[' expression ']'
    | reference '(' (expression (',' expression)*)? ')'
    | reference '.' IDENTIFIER
    | reference '.' INTEGER_LITERAL
    ;

// Cant write this rule in reference, cause ANTLR says it's left-rec
functionCall
    : reference '(' (expression (',' expression)*)? ')'
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
    : '{' (tupleElem (',' tupleElem)*)? '}'
    ;

tupleElem
    : (IDENTIFIER ':=')? expression
    ;

body
    : (statement delim)*
    ;

delim
    : ';'
    | EOF
    | {this.newLineAhead()}?
    ;