package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;

public class Subtracao extends Exp {
    private Exp exp1;
    private Exp exp2;

    public Subtracao(Exp exp1, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public String toString() {
        return exp1 + " - " + exp2;
    }

    @Override
    public Exp transicao(Estado e) {
        if (!(exp1 instanceof Num)) {
            return new Subtracao(exp1.transicao(e), exp2);
        } else if (!(exp2 instanceof Num)) {
            return new Subtracao(exp1, exp2.transicao(e));
        } else {
            return new Num(((Num)exp1).getValor() - ((Num)exp2).getValor());
        }
    }
}