%{
	#include "lex.yy.c"
%}

%language "c"
%define api.value.type {int}
%token <int> INT

%% /* Grammar rules and actions follow. */
exp:
	INT
;
%%

