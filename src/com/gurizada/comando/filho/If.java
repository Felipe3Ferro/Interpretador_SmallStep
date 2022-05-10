package com.gurizada.comando.filho;

import com.gurizada.Estado;
import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Bool;

public class If extends Comando{
    private Exp b;
    private Comando c1;
    private Comando c2;
    private Bool bool;

    public If(Exp b, Comando c1) {
        this.b = b;
        this.c1 = c1;
    }
    public If(Exp b, Comando c1, Comando c2) {
        this.b = b;
        this.c1 = c1;
        this.c2 = c2;
    }
    public If(Exp b, Comando c1, Comando c2,Bool bool) {
        this.b = b;
        this.c1 = c1;
        this.c2 = c2;
        this.bool = bool;
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
    public Bool getBool(){
        return bool;
    }

    @Override
    public Comando transicao(Estado s){
        if(!(b instanceof Bool)){
            while(!(b instanceof Bool)){
                System.out.println("<"+ this + " , " + s + ">");
                b = b.transicao(s);
            }
            bool = (Bool)b;
            return new If(b, c1, c2, bool);
        
        }else{
           bool = (Bool) b; 
        }if(bool.getValor() == true){
            if(c1 instanceof Skip){
                return new Skip();
            }else{
                return new If(b, c1.transicao(s), c2,bool);
            }
        }else if(bool.getValor() == false){
            if(c2 instanceof Skip){
                return new Skip();
            }else{
                return new If(b, c1, c2.transicao(s),bool);
            }
        }
        return new If(b.transicao(s), c1, c2);

    }

    @Override
    public String toString(){
        if(c2 != null)
            return "if " + b + " then " + c1 + " else " + c2;
        else
            return "if " + b + " then " + c1;
    }
}


    

