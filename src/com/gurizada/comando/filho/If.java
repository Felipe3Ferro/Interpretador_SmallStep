package com.gurizada.comando.filho;

import com.gurizada.Estado;
import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Bool;

public class If extends Comando{
    private Exp b;
    private Comando c1;
    private Comando c2;

    public If(Exp b, Comando c1) {
        this.b = b;
        this.c1 = c1;
    }
    public If(Exp b, Comando c1, Comando c2) {
        this.b = b;
        this.c1 = c1;
        this.c2 = c2;
    }
    public Exp getB() {
        return b;
    }
    public Comando getC1() {
        return c1;
    }
    public Comando getC2() {
        return c2;
    }

    @Override
    public Comando transicao(Estado s){
        Bool t = new Bool(true);
        Bool f = new Bool(false);
        if(!(b instanceof Bool)){
            return new If(b.transicao(s), c1, c2);
        }else if(b.equals(t)){
            if((c1 instanceof Skip)) 
                return new Skip();
            else 
                return new If(b, c1.transicao(s), c2);
        }else if(b.equals(f)){
            if((c2 instanceof Skip)) 
                return new Skip();
            else 
                return new If(b, c1, c2.transicao(s));
        }
        return this;

    }

    @Override
    public String toString(){
        if(c2 != null)
            return "if " + b + " then " + c1 + " else " + c2;
        else
            return "if " + b + " then " + c1;
    }
}


    

