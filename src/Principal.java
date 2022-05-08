public class Principal {
    public static void main(String[] args) {
        //Montar uma árvore de sintaxe abstrata
        //1+x
        Exp exp = new Soma(new Num(1), new Var("x"));
        //Montar o estado inicial
        Estado s = new Estado();
        s.adicionar("x",1);
        //Executar o interpretador bigstep
        System.out.println(exp);
        System.out.println(s);
        exp = Intepretador.smallStep(exp, s);
        while (!(exp instanceof Num)) {
            System.out.println(exp);
            System.out.println(s);
            exp = Intepretador.smallStep(exp, s);
        }
        System.out.println("Final:");
        System.out.println(exp);
        System.out.println(s);
    }
}
