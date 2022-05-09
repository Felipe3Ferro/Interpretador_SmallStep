package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;

public class Soma extends Exp {
    private Exp expEsq;
    private Exp expDir;
    public Soma(Exp e, Exp d) {
        expEsq = e;
        expDir = d;
    }

    @Override
    public String toString() {
        return expEsq + " + " + expDir;
    }

    @Override
    public Exp transicao(Estado s) {
        if (!(expEsq instanceof Num)) {
            return new Soma(expEsq.transicao(s), expDir);
        } else if (!(expDir instanceof Num)) {
            return new Soma(expEsq, expDir.transicao(s));
        } else {
            return new Num(((Num)expEsq).getValor() + ((Num)expDir).getValor());
        }
    }
}
