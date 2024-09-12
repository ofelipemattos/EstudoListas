import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartaoDeCredito {

    private final List<Compra> compras;
    private float total;
    private final float limite;

    public CartaoDeCredito(float limite) {
        this.compras = new ArrayList<>();
        this.total = 0;
        this.limite = limite;
    }

    public boolean temLimiteDisponivel(float valor) {
        return !(this.total + valor > this.limite);
    }

    public void adicionarCompra(Compra compra) {
        if (temLimiteDisponivel(compra.getValor())) {
            compras.add(compra);
            this.total += compra.getValor();
        } else {
            System.out.println("Limite de compras atingido.");
        }
    }

    public void ordenarComprasPorValorCrescente() {
        compras.sort(Comparator.comparing(Compra::getValor));
    }

    public void ordenarComprasPorValorDecrescente() {
        compras.sort(Comparator.comparing(Compra::getValor).reversed());
    }

    public float getLimite() {
        return this.limite;
    }

    public float getTotal() {
        return this.total;
    }

    public void ordenarCompras() {
        Collections.sort(this.compras);
    }

    public String toString() {
        StringBuilder lista = new StringBuilder();
        for (Compra compra : compras) {
            lista.append(compra).append("\n");
        }
        return lista.toString();
    }
}
