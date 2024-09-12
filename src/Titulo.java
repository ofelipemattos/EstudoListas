import java.util.Comparator;

public class Titulo implements Comparable, Comparator {
    private String nome;
    private int ano;

    public Titulo(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int compareTo(Object o) {
        Titulo outroTitulo = (Titulo) o;
        return this.nome.compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.ano + ")";
    }

    @Override
    public int compare(Object o1, Object o2) {
        Titulo t1 = (Titulo) o1;
        Titulo t2 = (Titulo) o2;
        return Integer.compare(t1.getAno(), t2.getAno());
    }
}
