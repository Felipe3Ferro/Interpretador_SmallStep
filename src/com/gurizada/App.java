package com.gurizada;

import com.gurizada.comando.Comando;
import com.gurizada.comando.filho.Atribuicao;
import com.gurizada.comando.filho.Skip;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Bool;
import com.gurizada.exp.filho.BoolExp;
import com.gurizada.exp.filho.Bop;
import com.gurizada.exp.filho.Num;
import com.gurizada.exp.filho.Soma;
import com.gurizada.exp.filho.Var;

public class App {
    public static void main(String[] args) {
        Exp exp = new Soma(new Var("x"), new Num(4));
        Comando c = new Atribuicao(new Var("x"), exp);
        Estado s = new Estado();
        NumUBool n = new NumUBool(3); 
        s.adicionar("x", n);
        System.out.println("<"+ c+","+s+">");
        /*while (!(exp instanceof Num) && !(exp instanceof Bool)) {
            c = Intepretador.smallStep(c, s);
            System.out.println("<"+ exp+","+s+">");
        }*/
        while (!(c instanceof Skip)){
            c = Intepretador.smallStep(c, s);
            System.out.println("<"+ c+","+s+">");
        }
        System.out.println("Final:" + "<"+ c+","+s+">");
    }
}
