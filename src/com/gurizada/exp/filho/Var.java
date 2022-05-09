package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;

public class Var extends Exp {
    private String nome;
    public Var(String n) {
        nome = n;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public Exp transicao(Estado s) {
        if(s.ler(this.nome).getInteger() != null){
            return new Num(s.ler(nome).getInteger());
        }else{
            return new Bool(s.ler(nome).getBool());
        }
            
    }
}
