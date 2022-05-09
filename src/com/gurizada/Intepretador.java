package com.gurizada;

import com.gurizada.exp.Exp;

public class Intepretador {
    public static Exp smallStep(Exp expInicial, Estado estadoInicial) {
        return expInicial.transicao(estadoInicial);
    }
}
