:- module(_,_,[assertions,regtypes]).

author_data('Sanchez','Ferrari','Daniel','200024').

color(o).
color(x).

rule(o,o,o,_,o). % regla nula
rule(x,o,o,r(A,_,_,_,_,_,_),A) :- color(A).
rule(o,x,o,r(_,B,_,_,_,_,_),B) :- color(B).
rule(o,o,x,r(_,_,C,_,_,_,_),C) :- color(C).
rule(x,o,x,r(_,_,_,D,_,_,_),D) :- color(D).
rule(x,x,o,r(_,_,_,_,E,_,_),E) :- color(E).
rule(o,x,x,r(_,_,_,_,_,F,_),F) :- color(F).
rule(x,x,x,r(_,_,_,_,_,_,G),G) :- color(G).


%cells([array inicial],regla seguir,[que va a devolver])
%Inicial para que se meta cuando lea o por primera vez
cells([],_,[]).

%Primera itración se hace cierta cuando el array inicial empieza por o
cells([o,R|Rt],K,[o,Z|Zt]) :- rule(o,o,R,K,Z), cellsCont([o,R|Rt],K,Zt).

%cellsCont([elemento1,elemento2,elemento3],regla a seguir,[Devolucionanterior+nuevo elemento]).
%Es la conticuancion y pasos intermedios de cells
cellsCont([R,S,Y|Rt],K,[Z|Zt]):- rule(R,S,Y,K,Z),cellsCont([S,Y|Rt],K,Zt).

%Caso final que se hace cierto cuando el array inicial termina con o
cellsCont([R,o],K,[Z,o]):- rule(R,o,o,K,Z). 



%Montamos el caso inicial de evol pasando primero el Caso [o,x,o] y
% luego al pasar a evol Inter se marcara N a 0
evol(N, RuleSet, Cells) :- evolIter(N, RuleSet, [o,x,o], Cells).

%Los siguientes son los encargados de la ejecucion iterativa del codigo 
%el primero siendo el caso inicial y luego se va
evolIter(0,_,Cells,Cells).

%Funcion que se ocupa de las iteraciones a continuación del caso inicial
evolIter(s(N),RuleSet,Cells,FinalCells) :- cells(Cells,RuleSet,NewCells),evolIter(N,RuleSet, NewCells, FinalCells).

