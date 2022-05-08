public class Skip extends Comando{
    @Override
    public Comando transicao(Estado s) {
        return this;
    }

    @Override
    public String toString() {
        return "skip";
    }
}
