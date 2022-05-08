public class Var extends Exp {
    private String nome;
    public Var(String n) {
        nome = n;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return nome;
    }

    @Override
    public Exp transicao(Estado s) {
        return new Num(s.ler(nome));
    }
}
