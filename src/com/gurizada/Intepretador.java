package com.gurizada;

import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;

public class Intepretador {
    public static Exp smallStep(Exp expInicial, Estado estadoInicial) {
        return expInicial.transicao(estadoInicial);
    }
    public static Comando smallStep(Comando c,Estado s){
        return c.transicao(s);
    }
}
