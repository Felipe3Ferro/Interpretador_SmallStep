package com.gurizada.comando.filho;

import com.gurizada.Estado;
import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Num;
import com.gurizada.exp.filho.Var;

public class Atribuicao extends Comando {
    private Var variavel;
    private Exp expressao;

    public Atribuicao(Var variavel, Exp expressao) {
        this.variavel = variavel;
        this.expressao = expressao;
    }

    @Override
    public String toString() {
        return variavel + " := " + expressao;
    }

    @Override
    public Comando transicao(Estado s) {
        if (expressao instanceof Num) {
            s.atualizar(variavel.getNome(), ((Num)expressao).getValor());
            return new Skip();
        } else {
            Exp exp = expressao.transicao(s);
            return new Atribuicao(variavel, exp);
        }
    }
}
