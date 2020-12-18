grammar Day18Part2Grammar;

expression : expr;

expr
    : primary
    | expr (ADDITION) expr
    | expr (MULTIPLICATION) expr
    ;

primary
    : '(' expr ')'
    | NUMBER
    ;

NUMBER : [0-9]+;

ADDITION : '+';

MULTIPLICATION : '*';

WS : [ \t\n\r\f]+ -> skip;