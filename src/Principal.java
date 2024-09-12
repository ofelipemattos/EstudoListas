import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o limite de compras: ");
        String input = scanner.next();

        float limite = validarValor(input);
        if (limite < 0) {
            System.out.println("Limite inválido! Por favor, digite um número maior ou igual a 0.");
            return;
        }
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);
        fazerCompras(scanner, cartaoDeCredito);
        cartaoDeCredito.ordenarCompras();

        System.out.println(cartaoDeCredito);
        cartaoDeCredito.ordenarComprasPorValorCrescente();
        System.out.println(cartaoDeCredito);
        cartaoDeCredito.ordenarComprasPorValorDecrescente();
        System.out.println(cartaoDeCredito);
    }

    private static float validarValor(String input) {
        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void fazerCompras(Scanner scanner, CartaoDeCredito cartaoDeCredito) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("O que deseja comprar?");
            String produto = scanner.next();
            System.out.println("Qual o valor do produto?");
            float valor = validarValor(scanner.next());
            if (valor > 0) {
                if (cartaoDeCredito.temLimiteDisponivel(valor)) {
                    cartaoDeCredito.adicionarCompra(new Compra (produto, valor));
                    System.out.println("Compra realizada com sucesso!");
                    System.out.println("Limite disponível: R$ " + (cartaoDeCredito.getLimite() - cartaoDeCredito.getTotal()));
                }
                else {
                    System.out.println("Limite de compras atingido.");
                    continuar = false;
                }
            }
            else {
                System.out.println("Valor inválido! Por favor, digite um número maior ou igual a 0.");
            }
        }

    }



//        List<Integer> lista = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            lista.add((int) (Math.random() * 100));
//        }
//        System.out.println(lista);
//        Collections.sort(lista);
//        System.out.println(lista);
//        List<Titulo> titulos = new ArrayList<>();
//        titulos.add(new Titulo("O Senhor dos Anéis", 2001));
//        titulos.add(new Titulo("O Poderoso Chefão III", 1990));
//        titulos.add(new Titulo("Interestelar", 2020));
//        titulos.add(new Titulo("Matrix", 1999));
//        titulos.add(new Titulo("300", 2002));
//        System.out.println(titulos);
//        titulos.sort(Comparator.comparing(Titulo::getAno));
//        System.out.println(titulos);
}
