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
    
    public void Verifica_Tipo(){
        if(this.getInteger() == null){

        }
    }


    public Integer getInteger() {
        return integer;
    }

    public Boolean getBool() {
        return bool;
    }

    @Override
    public String toString(){
        if(this.getInteger() != null){
            return ""+this.getInteger();
        }else{
            return ""+this.getBool();
        }
    }
}
