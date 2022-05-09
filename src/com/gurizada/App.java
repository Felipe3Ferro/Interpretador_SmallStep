package com.gurizada;

import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Num;
import com.gurizada.exp.filho.Soma;
import com.gurizada.exp.filho.Var;

public class App {
    public static void main(String[] args) {
        Exp exp = new Soma(new Var("y"), new Var("x"));
        Estado s = new Estado();
        s.adicionar("x",1);
        s.adicionar("y",2);
        System.out.println("<"+ exp+","+s+">");
        exp = Intepretador.smallStep(exp, s);
        while (!(exp instanceof Num)) {
            System.out.println("<"+ exp+","+s+">");
            exp = Intepretador.smallStep(exp, s);
        }
        System.out.println("Final:");
        System.out.println(exp);
        System.out.println(s);
    }
}
