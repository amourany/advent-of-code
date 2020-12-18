grammar Day18Part1Grammar;

expression : expr;

expr
    : primary
    | expr (ADDITION | MULTIPLICATION) expr
    ;

primary
    : '(' expr ')'
    | NUMBER
    ;

NUMBER : [0-9]+;

ADDITION : '+';

MULTIPLICATION : '*';

WS : [ \t\n\r\f]+ -> skip;