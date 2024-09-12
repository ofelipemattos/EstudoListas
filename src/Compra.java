import java.util.Comparator;

public class Compra implements Comparable, Comparator {

    private String produto;
    private float valor;

    public Compra(String produto, float valor) {
        this.produto = produto;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public float getValor() {
        return valor;
    }

    public String toString() {
        return this.produto + " (R$ " + this.valor + ")";
    }

    public int compareTo(Object o) {
        Compra outraCompra = (Compra) o;
        return this.produto.compareTo(outraCompra.getProduto());
    }

    public int compare(Object o1, Object o2) {
        Compra c1 = (Compra) o1;
        Compra c2 = (Compra) o2;
        return Float.compare(c1.getValor(), c2.getValor());
    }
}
