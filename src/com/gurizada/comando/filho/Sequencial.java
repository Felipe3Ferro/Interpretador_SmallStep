package com.gurizada.comando.filho;

import javax.lang.model.util.ElementScanner14;

import com.gurizada.Estado;
import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;

public class Sequencial extends Comando{
    private Comando c1;
    private Comando c2;

    public Sequencial(Comando c1, Comando c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    public Comando getC1() {
        return c1;
    }

    public Comando getC2() {
        return c2;
    }
    
    @Override
    public Comando transicao(Estado s){
        if(!(c1 instanceof Skip)){
            return new Sequencial(c1.transicao(s), c2);
        }else if(!(c2 instanceof Skip)){
            return new Sequencial(c1, c2.transicao(s));
        }else{
            return new Skip();
        }
    }

    @Override
    public String toString(){
        return c1 + ";" + c2;
    }
}
