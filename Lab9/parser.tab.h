
/* A Bison parser, made by GNU Bison 2.4.1.  */

/* Skeleton interface for Bison's Yacc-like parsers in C
   
      Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */


/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     inti_dt = 258,
     bool_dt = 259,
     string_dt = 260,
     giveInti = 261,
     sayInti = 262,
     say = 263,
     give = 264,
     adiosBoys = 265,
     hmm = 266,
     nah = 267,
     and = 268,
     or = 269,
     repeatAfterMe = 270,
     id = 271,
     ct = 272,
     plus = 273,
     MINUS = 274,
     MULTIPLY = 275,
     DIVISION = 276,
     REMAINDER = 277,
     LESS = 278,
     LESS_OR_EQUAL = 279,
     EQUAL = 280,
     GREATER_OR_EQUAL = 281,
     GREATER = 282,
     ASSIGN = 283,
     OPEN_ACCOL = 284,
     CLOSED_ACCOL = 285,
     OPEN_SQUARE = 286,
     CLOSED_SQUARE = 287,
     OPEN_ROUND = 288,
     CLOSED_ROUND = 289,
     SEMI_COL = 290,
     COMMA = 291
   };
#endif


#define inti_dt 258
#define bool_dt 259
#define string_dt 260
#define giveInti  261
#define sayInti 262
#define say 263
#define give 264
#define adiosBoys 265
#define hmm 266
#define nah 267
#define  and  268
#define  or 269
#define repeatAfterMe  270
#define id 271
#define ct 272
#define plus 273
#define MINUS 274
#define MULTIPLY 275
#define DIVISION 276
#define REMAINDER 277
#define LESS 278
#define LESS_OR_EQUAL 279
#define EQUAL 280
#define GREATER_OR_EQUAL 281
#define GREATER 282
#define ASSIGN 283
#define OPEN_ACCOL 284
#define CLOSED_ACCOL 285
#define OPEN_SQUARE 286
#define CLOSED_SQUARE 287
#define OPEN_ROUND 288
#define CLOSED_ROUND 289
#define SEMI_COL 290
#define COMMA 291

#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;


