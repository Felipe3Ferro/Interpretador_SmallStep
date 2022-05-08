public class Intepretador {
    public static Exp smallStep(Exp expInicial, Estado estadoInicial) {
        return expInicial.transicao(estadoInicial);
    }
}
