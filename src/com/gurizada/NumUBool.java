package com.gurizada;

public class NumUBool {
    private Integer integer;
    private Boolean bool;

    public NumUBool(Boolean bool) {
        this.bool = bool;
    }

    public NumUBool(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public Boolean getBool() {
        return bool;
    }
}
