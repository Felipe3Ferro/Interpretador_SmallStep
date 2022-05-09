package com.gurizada;

import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.*;

public class App {
    public static void main(String[] args) {
        Exp exp = new BoolExp(new Bop("!"), new Bool(true));
        Estado s = new Estado();
        s.adicionar("x",1);
        System.out.println("<"+ exp+","+s+">");
        exp = Intepretador.smallStep(exp, s);
        while (!(exp instanceof Num) && !(exp instanceof Bool)) {
            System.out.println("<"+ exp+","+s+">");
            exp = Intepretador.smallStep(exp, s);
        }
        System.out.println("Final:");
        System.out.println(exp);
        System.out.println(s);
    }
}