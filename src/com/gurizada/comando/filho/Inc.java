package com.gurizada.comando.filho;

import com.gurizada.Estado;
import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Num;
import com.gurizada.exp.filho.Soma;
import com.gurizada.exp.filho.Var;

public class Inc extends Comando{
    private Var var;

   

    public Inc(Var var) {
        this.var = var;
    }


    public Exp getVar() {
        return var;
    }


    @Override
    public Comando transicao(Estado s) {
        return new Atribuicao(var, new Soma(var,new Num(1)));
    }

    @Override
    public String toString(){
        return "inc " + var.getNome();
    }
}
