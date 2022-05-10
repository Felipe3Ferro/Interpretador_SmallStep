package com.gurizada.exp.filho;

import com.gurizada.Estado;
import com.gurizada.exp.Exp;

public class Bool extends Exp {

    private Boolean bool;

    public Bool(Boolean bool) {
        this.bool = bool;
    }

    
    public Boolean getValor() {
        return bool;
    }
    

    @Override
    public String toString() {
        return ""+ bool;
    }

    @Override
    public Exp transicao(Estado s) {
        return this;
    }
}
