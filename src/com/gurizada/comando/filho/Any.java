package com.gurizada.comando.filho;

import java.util.Random;

import com.gurizada.Estado;
import com.gurizada.comando.Comando;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Num;
import com.gurizada.exp.filho.Var;

public class Any extends Comando{

    private Var var;

    
    public Any(Var var) {
        this.var = var;
    }

    public Var getVar() {
        return var;
    }

    @Override
    public Comando transicao(Estado s) {
        Random r = new Random();
        return new Atribuicao(var, new Num(r.nextInt(100)));
    }

    @Override
    public String toString() {
        
        return "any " + var.getNome();
    }


    
    
}
