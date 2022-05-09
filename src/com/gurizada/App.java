package com.gurizada;

import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Bool;
import com.gurizada.exp.filho.BoolExp;
import com.gurizada.exp.filho.Bop;
import com.gurizada.exp.filho.Num;
import com.gurizada.exp.filho.Soma;
import com.gurizada.exp.filho.Var;

public class App {
    public static void main(String[] args) {
        Exp exp = new BoolExp(new Bop("||"), (new BoolExp(new Bop("!"), new Var("x"))), new Bool(true));
        Estado s = new Estado();
        NumUBool n = new NumUBool(true); 
        s.adicionar("x", n);
        System.out.println("<"+ exp+","+s+">");
        while (!(exp instanceof Num) && !(exp instanceof Bool)) {
            exp = Intepretador.smallStep(exp, s);
            System.out.println("<"+ exp+","+s+">");
        }
        System.out.println("Final:" + "<"+ exp+","+s+">");
    }
}
