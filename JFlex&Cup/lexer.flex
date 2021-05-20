package package courseallocationsystem.analizadores;


%%

%class StorageLexer
%public
%cup
%unicode
%line
%column

%{

    private Symbol symbol(int type){
        return new Symbol(type, yytext());
    }

%}

%eofval{
    return new Symbol(EOF, "Fin de linea");
%eofval}

ENTERO = (0|([1-9][0-9]*))
NAME_ED = (\w){ENTERO}
LITERAL = [\w][\w ]*

%LITERALS

%%

<YYINITIAL> "Usuario"           { return symbol(USUARIO); }
<YYINITIAL> "Estudiante"        { return symbol(ESTUDIANTE); }
<YYINITIAL> "Edificio"          { return symbol(EDIFICIO); }
<YYINITIAL> "Salon"             { return symbol(SALON); }
<YYINITIAL> "Catedratico"       { return symbol(CATEDRATICO); }
<YYINITIAL> "Curso"             { return symbol(CURSO); }
<YYINITIAL> "Horario"           { return symbol(HORARIO); }
<YYINITIAL> "Asignar"           { return symbol(ASIGNAR); }

<YYINITIAL> "estudiante"        { return symbol(USR_ESTUDIANTE); }
<YYINITIAL> "colaborador"       { return symbol(USR_COLABORADOR); }

<YYINITIAL> {
    "("                         { return symbol(OPEN_ROUND_BRACKET); }
    ")"                         { return symbol(CLOSE_ROUND_BRACKET); }
    ","                         { return symbol(COMMA); }
    ";"                         { return symbol(SEMI); }
    "\""                        { yybegin(LITERALS); return symbol(QUOTE_MARK); }
}

<LITERALS> {
    "\""                        { yybegin(YYINITIAL); return symbol(QUOTE_MARK); }
}

<LITERALS> {LITERAL}            { return symbol(LITERAL); }

<YYINITIAL> {ENTERO}            { return symbol(ENTERO); }
<YYINITIAL> {NAME_ED}           { return symbol(NAME_ED); }
