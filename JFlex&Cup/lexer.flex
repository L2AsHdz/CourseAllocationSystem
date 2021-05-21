package courseallocationsystem.analizadores;

import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.Symbol;
import static courseallocationsystem.analizadores.Sym.*;

%%

%class Lexer
%public
%cup
%unicode
%line
%column

%{
    private List<String> errores = new ArrayList();

    public List<String> getErrores() {
        return this.errores;
    }

    private Symbol symbol(int type){
        return new Symbol(type, yytext());
    }

    private void addLexicError() {
        errores.add("Caracter invalido " + yytext() + ", linea: " + yyline + 1 + ", columna: " + yycolumn + 1);
    }

%}

%eofval{
    return new Symbol(EOF, "Fin de linea");
%eofval}

ENTERO = (0|([1-9][0-9]*))
NAME_ED = (\w)+{ENTERO}+
LITERAL = [^"\""]*

%state LITERALS

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
    (\s)+                       { /** Ignorar */}
}

<LITERALS> {
    "\""                        { yybegin(YYINITIAL); return symbol(QUOTE_MARK); }
}

<LITERALS> {LITERAL}            { return symbol(LITERAL); }

<YYINITIAL> {ENTERO}            { return symbol(ENTERO); }
<YYINITIAL> {NAME_ED}           { return symbol(NAME_ED); }

[^]                             { addLexicError(); }