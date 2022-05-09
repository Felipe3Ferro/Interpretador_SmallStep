package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;

public class Num extends Exp {
    private int valor;
    public Num(int v) {
        valor = v;
    }
    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return Integer.toString(valor);
    }

    @Override
    public Exp transicao(Estado s) {
        return this;
    }
}
