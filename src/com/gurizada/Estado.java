package com.gurizada;

import java.util.HashMap;
import java.util.Map;

public class Estado {
    private Map<String, NumUBool> mapeamento = new HashMap<>();
    public void atualizar(String variavel, NumUBool valor) {
        mapeamento.replace(variavel,valor);
    }
    public void adicionar(String variavel, NumUBool valor) {
        mapeamento.put(variavel,valor);
    }
    public NumUBool ler(String variavel) {
        NumUBool valor = mapeamento.get(variavel);
        if (valor == null) return null;
        return valor;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        var iterador = mapeamento.entrySet().iterator();
        while (iterador.hasNext()) {
            var e = iterador.next();
            s.append(e.getKey());
            s.append(" -> ");
            s.append(e.getValue());
            if (iterador.hasNext()) {
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
