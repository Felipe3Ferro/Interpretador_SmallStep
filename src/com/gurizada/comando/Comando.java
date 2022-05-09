package com.gurizada.comando;

import com.gurizada.Estado;

public abstract class Comando {
    public abstract Comando transicao(Estado s);
}
