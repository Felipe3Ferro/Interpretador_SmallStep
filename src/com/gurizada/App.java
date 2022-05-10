package com.gurizada;

import com.gurizada.comando.Comando;
import com.gurizada.comando.filho.Atribuicao;
import com.gurizada.comando.filho.If;
import com.gurizada.comando.filho.Sequencial;
import com.gurizada.comando.filho.Skip;
import com.gurizada.exp.Exp;
import com.gurizada.exp.filho.Bool;
import com.gurizada.exp.filho.BoolExp;
import com.gurizada.exp.filho.Bop;
import com.gurizada.exp.filho.Multiplicacao;
import com.gurizada.exp.filho.Num;
import com.gurizada.exp.filho.Soma;
import com.gurizada.exp.filho.Subtracao;
import com.gurizada.exp.filho.Var;

public class App {
    public static void main(String[] args) {
        Exp exp = new Soma(new Var("x"), new Num(4));
        Comando c1 = new If(new BoolExp(new Bop(">"),new Var("x"),new Var("y")), new Atribuicao(new Var("x"),new Soma(new Var("x"),new Var("y"))));
        Estado s = new Estado();
        NumUBool n = new NumUBool(3); 
        NumUBool n1 = new NumUBool(2);
        s.adicionar("x", n);
        s.adicionar("y", n1);
        System.out.println("<"+ c1+","+s+">");
        /*while (!(exp instanceof Num) && !(exp instanceof Bool)) {
            c = Intepretador.smallStep(c, s);
            System.out.println("<"+ exp+","+s+">");
        }*/
        while (!(c1 instanceof Skip)){
            c1 = Intepretador.smallStep(c1, s);
            System.out.println("<"+ c1+","+s+">");
        }
        System.out.println("Final:" +  "<"+ c1+","+s+">");
    }

    /*
    Teste; <x := 5 * x;y := x - y,[x -> 3, y -> 2]>
    Exp exp = new Soma(new Var("x"), new Num(4));
        Comando c1 = new Atribuicao(new Var("x"), new Multiplicacao(new Num(5), new Var("x")));
        Comando c2 = new Atribuicao(new Var("y"), new Subtracao(new Var("x"), new Var("y")));
        Comando c = new Sequencial(c1, c2);
        Estado s = new Estado();
        NumUBool n = new NumUBool(3); 
        NumUBool n1 = new NumUBool(2);
        s.adicionar("x", n);
        s.adicionar("y", n1);
        System.out.println("<"+ c+","+s+">");
        /*while (!(exp instanceof Num) && !(exp instanceof Bool)) {
            c = Intepretador.smallStep(c, s);
            System.out.println("<"+ exp+","+s+">");
        }
        while (!(c instanceof Skip)){
            c = Intepretador.smallStep(c, s);
            System.out.println("<"+ c+","+s+">");
        }
        System.out.println("Final:" + "<"+ c+","+s+">"); 
        */

}
