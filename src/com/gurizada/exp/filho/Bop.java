package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;

public class Bop extends Exp {

    private String bop;

    public Bop(String bop) {
        this.bop = bop;
    }

    public String getBop() {
        return bop;
    }

    @Override
    public String toString() {
        return bop;
    }

    @Override
    public Exp transicao(Estado s) {
        return this;
    }
}
