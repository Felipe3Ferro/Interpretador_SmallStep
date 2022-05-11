package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;


public class BoolExp extends Exp {
    private Exp exp1;
    private Exp exp2;
    private Bop bop;

    public BoolExp(Bop bop,Exp exp1, Exp exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.bop = bop;
    }

    public BoolExp(Bop bop, Exp exp1) {
        this.bop = bop;
        this.exp1 = exp1;
    }


    @Override
    public Exp transicao(Estado s) {

        switch(bop.getBop()){
            case "!":
                if (!(exp1 instanceof Bool)) {
                    return new BoolExp(bop, exp1.transicao(s));
                } else {
                    return new Bool(!((Bool) exp1).getValor());
                }
            case "&&":
                if (!(exp1 instanceof Bool)) {
                    return new BoolExp(bop, exp1.transicao(s),exp2);
                } else if(!(exp2 instanceof Bool)){
                    return new BoolExp(bop,exp1,exp2.transicao(s));
                }else {
                    return new Bool(((Bool) exp1).getValor() && ((Bool) exp2).getValor());
                }
            case "||":
                if (!(exp1 instanceof Bool)) {
                    return new BoolExp(bop, exp1.transicao(s),exp2);
                } else if(!(exp2 instanceof Bool)){
                    return new BoolExp(bop,exp1,exp2.transicao(s));
                }else {
                    return new Bool(((Bool) exp1).getValor() || ((Bool) exp2).getValor());
                }
            case ">":
                if (!(exp1 instanceof Num)) {
                    return new BoolExp(bop, exp1.transicao(s),exp2);
                } else if(!(exp2 instanceof Num)){
                    return new BoolExp(bop,exp1,exp2.transicao(s));
                }else {
                    return new Bool(((Num) exp1).getValor() > ((Num) exp2).getValor());
                }
            case "<":
                if (!(exp1 instanceof Num)) {
                    return new BoolExp(bop, exp1.transicao(s),exp2);
                } else if(!(exp2 instanceof Num)){
                    return new BoolExp(bop,exp1,exp2.transicao(s));
                }else {
                    return new Bool(((Num) exp1).getValor() < ((Num) exp2).getValor());
                }
            case "==":
                if (!(exp1 instanceof Num)) {
                    return new BoolExp(bop, exp1.transicao(s),exp2);
                } else if(!(exp2 instanceof Num)){
                    return new BoolExp(bop,exp1,exp2.transicao(s));
                }else {
                    return new Bool(((Num) exp1).getValor() == ((Num) exp2).getValor());
                }
        }
        return this;
    }

    @Override
    public String toString() {
        if(exp2 == null){
            return bop + " " + exp1;
        }else {
            return exp1 + " " + bop + " " + exp2;
        }

    }


}
