:- module(_,_,[]).
:- use_module(library(lists)).

author_data('Sanchez', 'Ferrari', 'Daniel', '200024').



board1([cell(pos(1,1),op(*,-3)),
        cell(pos(1,2),op(-,1)),
        cell(pos(1,3),op(-,4)),
        cell(pos(1,4),op(-,555)),
        cell(pos(2,1),op(-,3)),
        cell(pos(2,2),op(+,2000)),
        cell(pos(2,3),op(*,133)),
        cell(pos(2,4),op(-,444)),
        cell(pos(3,1),op(*,0)),
        cell(pos(3,2),op(*,155)),
        cell(pos(3,3),op(//,2)),
        cell(pos(3,4),op(+,20)),
        cell(pos(4,1),op(-,2)),
        cell(pos(4,2),op(-,1000)),
        cell(pos(4,3),op(-,9)),
        cell(pos(4,4),op(*,4))]).

%--------------------------------efectuar movimiento---------------------------------%
efectuar_movimiento(Pos, Dir, Pos2) :-
    Pos = pos(Row, Col),
    (Dir = n, Pos2 = pos(NewRow, Col), NewRow is Row - 1;
     Dir = s, Pos2 = pos(NewRow, Col), NewRow is Row + 1;
     Dir = e, Pos2 = pos(Row, NewCol), NewCol is Col + 1;
     Dir = o, Pos2 = pos(Row, NewCol), NewCol is Col - 1;
     Dir = no, Pos2 = pos(NewRow, NewCol), NewRow is Row - 1, NewCol is Col - 1;
     Dir = ne, Pos2 = pos(NewRow, NewCol), NewRow is Row - 1, NewCol is Col + 1;
     Dir = so, Pos2 = pos(NewRow, NewCol), NewRow is Row + 1, NewCol is Col - 1;
     Dir = se, Pos2 = pos(NewRow, NewCol), NewRow is Row + 1, NewCol is Col + 1).

%--------------------------------movimiento valido------------------------------------%

movimiento_valido(N, pos(Row, Col), Dir) :-
    efectuar_movimiento(pos(Row, Col), Dir, pos(NewRow, NewCol)),
    NewRow >= 1, NewRow =< N,
    NewCol >= 1, NewCol =< N.

%--------------------------------select cell------------------------------------%

select_cell(IPos, Op, Board, NewBoard) :-
    select(cell(IPos, Op), Board, NewBoard).

%--------------------------------select dir------------------------------------%

select_dir(Dir, Dirs, NewDirs) :-
    select(dir(Dir, Num), Dirs, RestDirs),
    (Num > 1, NewNum is Num - 1, NewDirs = [dir(Dir, NewNum) | RestDirs];
     Num = 1, NewDirs = RestDirs).

%--------------------------------aplicar op------------------------------------%

aplicar_op(op(Op, Operando), Valor, Valor2) :-
    (Op = '+', Valor2 is Valor + Operando;
     Op = '-', Valor2 is Valor - Operando;
     Op = '*', Valor2 is Valor * Operando;
     Op = '//', Operando =\= 0, Valor2 is Valor // Operando).

%--------------------------------generar recorrido------------------------------------%

generar_recorrido(Ipos, N, Board, DireccionesPermitidas, Recorrido, Valor) :-
    generar_recorrido(Ipos, N, Board, DireccionesPermitidas, [], 0, Recorrido, Valor).

generar_recorrido(Pos, N, Board, DireccionesPermitidas, RecorridoParcial2, ValorAct, Recorrido, Valor) :-
    select_cell(Pos, Op, Board, NewBoard), 
    aplicar_op(Op, ValorAct, NewValor),  
    \+ member(Pos, RecorridoParcial2),  
    append(RecorridoParcial2, [Pos], NewRecorridoParcial2), 
    length(NewRecorridoParcial2, Len),
    (Len =:= N * N ->  
        Recorrido = [(Pos, NewValor)],
        Valor = NewValor 
    ;
        select_dir(Dir, DireccionesPermitidas, NewDireccionesPermitidas),
        movimiento_valido(N, Pos, Dir),
        efectuar_movimiento(Pos, Dir, NewPos),  
        generar_recorrido(NewPos, N, NewBoard, NewDireccionesPermitidas, NewRecorridoParcial2, NewValor, RestoRecorrido, Valor),
        Recorrido = [(Pos, NewValor) | RestoRecorrido]
    ).

%--------------------------------generar recorridos------------------------------------%

generar_recorridos(N, Board, DireccionesPermitidas, Recorrido, Valor) :-
    pos_inboard(Pos, Board),
    generar_recorrido(Pos, N, Board, DireccionesPermitidas, Recorrido, Valor).

pos_inboard(Pos, Board) :-
    member(cell(Pos,_), Board).
%--------------------------------tablero------------------------------------%

tablero(N, Board, DireccionesPermitidas, ValorMinimo,NumeroDeRutasConValorMinimo) :-
    generar_recorridos(N, Board, DireccionesPermitidas, Recorrido, ValorMinimo),
    count_rutas_con_valor(Recorrido, ValorMinimo, NumeroDeRutasConValorMinimo).

count_rutas_con_valor([], _, 0).
count_rutas_con_valor([(Pos, Valor) | Resto], ValorMinimo, Count) :-
    (Valor = ValorMinimo, count_rutas_con_valor(Resto, ValorMinimo, CountResto), Count is CountResto + 1;
     Valor \= ValorMinimo, count_rutas_con_valor(Resto, ValorMinimo, Count)).

