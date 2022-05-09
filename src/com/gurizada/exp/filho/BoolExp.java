package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;

public class BoolExp extends Exp {
    private Exp exp1;
    private Exp exp2;
    private Bop bop;

    public BoolExp(Exp exp1, Exp exp2, Bop bop) {
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
        if (bop.getBop().equals("!")) {
            if (!(exp1 instanceof Bool)) {
                return new BoolExp(bop, exp1.transicao(s));
            } else {
                return new Bool(!((Bool) exp1).getBool());
            }
//        } else if () {
//
//        }else {
//
//        }
        }
        return null;
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
