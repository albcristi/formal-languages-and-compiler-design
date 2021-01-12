%{
#include <stdio.h>
#include <stdlib.h>

#define YYDEBUG 1
%}

%token inti_dt
%token bool_dt
%token string_dt
%token giveInti
%token sayInti
%token say
%token give
%token adiosBoys
%token hmm
%token nah
%token and
%token or
%token repeatAfterMe
%token id
%token ct
%token plus
%token MINUS
%token MULTIPLY
%token DIVISION
%token REMAINDER
%token LESS
%token LESS_OR_EQUAL
%token EQUAL
%token GREATER_OR_EQUAL
%token GREATER
%token ASSIGN
%token OPEN_ACCOL
%token CLOSED_ACCOL
%token OPEN_SQUARE
%token CLOSED_SQUARE
%token OPEN_ROUND
%token CLOSED_ROUND
%token SEMI_COL
%token COMMA

%start program

%%

program: StmtList {printf(" START - 0 -")}

StmtList: Stmt StmtList {printf(" 1\n");}
        | Stmt  {printf(" 2\n");};

Stmt: Decl {printf(" 3\n");}
    | Ifstmt  {printf(" 4\n");}
    | Forstmt {printf(" 5\n");}
    | Assignstmt {printf(" 6\n");}
    | Returnstmt {printf(" 7\n");}
    | Iostmt  {printf(" 8\n");};

Decl: DType id SEMI_COL {printf(" 9\n");}
    | DType id COMMA Decl {printf(" 10\n");};

DType: inti_dt OPEN_SQUARE ct CLOSED_SQUARE {printf(" 11\n");}
     | string_dt OPEN_SQUARE ct CLOSED_SQUARE {printf(" 12\n");}
     | inti_dt {printf(" 13\n");}
     | string_dt {printf(" 14\n");}
     | bool_dt {printf(" 15\n");};

Ifstmt: hmm OPEN_ROUND Condition CLOSED_ROUND OPEN_ACCOL StmtList CLOSED_ACCOL nah OPEN_ACCOL StmtList CLOSED_ACCOL {printf(" 16\n");}
      | hmm OPEN_ROUND Condition CLOSED_ROUND OPEN_ACCOL StmtList CLOSED_ACCOL {printf(" 17\n");};

Condition: Expression Relation Expression and Condition {printf(" 18\n");}
         | Expression Relation Expression or Condition {printf(" 19\n");}
         | Expression Relation Expression {printf(" 20\n");};

Relation: LESS  {printf(" 21\n");}
        | LESS_OR_EQUAL {printf(" 22\n");}
        | EQUAL {printf(" 23\n");}
        | GREATER_OR_EQUAL {printf(" 24\n");}
        | GREATER {printf(" 25\n");};

Forstmt: repeatAfterMe ForCond ForBody {printf(" 26\n");};

ForCond: OPEN_ROUND Assignstmt Condition SEMI_COL ct CLOSED_ROUND {printf(" 27\n");};

ForBody: OPEN_ACCOL StmtList CLOSED_ACCOL {printf(" 28\n");};

Assignstmt: id ASSIGN Expression SEMI_COL {printf(" 29\n");};

Returnstmt: adiosBoys SEMI_COL {printf(" 30\n");};

Iostmt: Istmt {printf(" 31\n")}
      | Ostmt {printf(" 32\n");};
 
Istmt: IntIstmt {printf(" 33\n");}
     | StringIstmt {printf(" 34\n");};

IntIstmt: giveInti OPEN_ROUND id CLOSED_ROUND SEMI_COL {printf(" 35\n");};

StringIstmt: give OPEN_ROUND id CLOSED_ROUND SEMI_COL {printf(" 36");};

Ostmt: IntOstmt {printf(" 37");}
     | StringOstmt {printf(" 38");};

IntOstmt: sayInti OPEN_ROUND Param CLOSED_ROUND SEMI_COL {printf(" 39\n");};

StringOstmt: say OPEN_ROUND Param CLOSED_ROUND SEMI_COL {printf(" 40\n");};

Param: id {printf(" 41\n");}
     | ct {printf(" 42\n");};

Expression: ArithmExpr {printf(" 43\n");};

ArithmExpr: term {printf(" 44\n");}
           | term plus ArithmExpr {printf(" 45\n");}
           | term MINUS ArithmExpr {printf(" 46\n");}
           | term MULTIPLY ArithmExpr  {printf(" 47\n");}
           | term DIVISION ArithmExpr  {printf(" 48\n");}
           | term REMAINDER ArithmExpr {printf(" 49\n");}
           | OPEN_ROUND ArithmExpr CLOSED_ROUND {printf(" 50\n");};

term: id  {printf(" 51\n");}
| ct  {printf(" 52\n");};    

%%

yyerror(char *s)
{
  printf("%s\n", s);
}

extern FILE *yyin;

main(int argc, char **argv)
{
  if (argc > 1) 
    yyin = fopen(argv[1], "r");
  if ( (argc > 2) && ( !strcmp(argv[2], "-d") ) ) 
    yydebug = 1;
  if ( !yyparse() ) 
    fprintf(stderr,"\t No errors detected\n");
}