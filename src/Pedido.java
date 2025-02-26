import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private String nomeCliente;
    private ArrayList<ItemCardapio> itemPedidoList;
    private float valortotal;
    public float percenttaxa = 0.10F;
    public float valorfinal = 0;
    public float troco;
    Map<String, Integer> contador1 = new HashMap<>();

    // Construtor
    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.itemPedidoList = new ArrayList<>();
    }

    // Método para exibir os detalhes do pedido
    public void exibirPedido(float pagamento) {
        System.out.println("Pedido de: " + nomeCliente);
        System.out.println("Valor da Compra: R$ " + valortotal);
        System.out.println("Itens comprados:");

        System.out.println(contador1);

        System.out.println("Taxa de serviço: " + (percenttaxa * 100) + "% sobre o valor da compra");
        valorfinal = valortotal + (valortotal * percenttaxa);
        System.out.println("Valor final com taxa: R$ " + valorfinal);
        System.out.println("Seu pagamento: R$ " + pagamento);

        troco = pagamento - valorfinal;
        if (troco >= 0) {
            System.out.println("Troco: R$ " + troco);

        } else {
            System.out.println("Saldo insuficiente! Ainda falta R$ " + (-troco));

        }
    }
    public void exibirvalorfinal() {
        System.out.println("Pedido de: " + nomeCliente);
        System.out.println("Valor da Compra: R$ " + valortotal);
        System.out.println("Itens comprados:");

        for (ItemCardapio item : itemPedidoList) {
            contador1.put(item.getNome(), contador1.getOrDefault(item.getNome(), 0) + 1);
        }
        System.out.println(contador1);

        System.out.println("Taxa de serviço: " + (percenttaxa * 100) + "% sobre o valor da compra");
        valorfinal = valortotal + (valortotal * percenttaxa);
        System.out.println("Valor final com taxa: R$ " + valorfinal);
    }

    public void adicionarItem(ItemCardapio itemEscolhido) {
        this.itemPedidoList.add(itemEscolhido);
        this.valortotal += itemEscolhido.getPreco();
    }

    public float getprecototal() {
        return valortotal;
    }
}
