#!/bin/bash

echo Compilando Lexer...
jflex lexer.flex
echo ---------------------

echo Compilando Parser...
cup -parser Parser -symbols Sym parser.cup

mv Lexer.java /home/asael/NetBeansProjects/CourseAllocationSystem/src/main/java/courseallocationsystem/analizadores/
mv Parser.java Sym.java /home/asael/NetBeansProjects/CourseAllocationSystem/src/main/java/courseallocationsystem/analizadores/