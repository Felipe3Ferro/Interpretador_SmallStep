package com.gurizada.comando.filho;

import com.gurizada.Estado;
import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Bool;

public class While extends Comando{

    private Exp b;
    private Comando c;
    
    
    public While(Exp b, Comando c) {
        this.b = b;
        this.c = c;
    }


    public Exp getB() {
        return b;
    }

    public Comando getC() {
        return c;
    }

    @Override
    public String toString(){
        return "while " + b + " do " + c;
    }

    @Override
    public Comando transicao(Estado s){
        return new If(b,new Sequencial(c, new While(b, c)), new Skip());
    }
}
