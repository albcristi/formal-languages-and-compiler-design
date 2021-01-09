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

program: StmtList;

StmtList: Stmt StmtList
        | Stmt;

Stmt: Decl 
    | Ifstmt
    | Forstmt
    | Assignstmt
    | Returnstmt 
    | Iostmt;

Decl: DType id SEMI_COL
    | DType id COMMA Decl;

DType: inti_dt OPEN_SQUARE ct CLOSED_SQUARE
     | string_dt OPEN_SQUARE ct CLOSED_SQUARE
     | inti_dt
     | string_dt
     | bool_dt;

Ifstmt: hmm OPEN_ROUND Condition CLOSED_ROUND OPEN_ACCOL StmtList CLOSED_ACCOL nah OPEN_ACCOL StmtList CLOSED_ACCOL
      | hmm OPEN_ROUND Condition CLOSED_ROUND OPEN_ACCOL StmtList CLOSED_ACCOL;

Condition: Expression Relation Expression and Condition
         | Expression Relation Expression or Condition
         | Expression Relation Expression;

Relation: LESS
        | LESS_OR_EQUAL
        | EQUAL
        | GREATER_OR_EQUAL
        | GREATER;

Forstmt: repeatAfterMe ForCond ForBody;

ForCond: OPEN_ROUND Assignstmt Condition SEMI_COL ct CLOSED_ROUND;

ForBody: OPEN_ACCOL StmtList CLOSED_ACCOL;

Assignstmt: id ASSIGN Expression SEMI_COL;

Returnstmt: adiosBoys SEMI_COL;

Iostmt: Istmt
      | Ostmt;

Istmt: IntIstmt
     | StringIstmt;

IntIstmt: giveInti OPEN_ROUND id CLOSED_ROUND SEMI_COL;

StringIstmt: give OPEN_ROUND id CLOSED_ROUND SEMI_COL;

Ostmt: IntOstmt
     | StringOstmt;

IntOstmt: sayInti OPEN_ROUND Param CLOSED_ROUND SEMI_COL;

StringOstmt: say OPEN_ROUND Param CLOSED_ROUND SEMI_COL;

Param: id | ct;

Expression: ArithmExpr;

ArithmExpr : term
           | term plus ArithmExpr
           | term MINUS ArithmExpr 
           | term MULTIPLY ArithmExpr 
           | term DIVISION ArithmExpr 
           | term REMAINDER ArithmExpr
           | OPEN_ROUND ArithmExpr CLOSED_ROUND ;

term : id | ct ;    

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