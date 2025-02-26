import java.util.HashMap;
import java.util.Scanner;


public class SistemaVendas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando o cardápio
        ItemCardapio[] cardapio = {
                new ItemCardapio(1, "Hamburguer", 15.00),
                new ItemCardapio(2, "Pizza", 30.00),
                new ItemCardapio(3, "Salada", 12.00),
                new ItemCardapio(4, "Refrigerante", 5.00),
                new ItemCardapio(5, "Lasanha", 10.00)
        };

        while (true) {
            // Exibir menu principal
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Fazer Pedido");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            if (opcao == 2) {
                System.out.println("Saindo... Obrigado!");
                break;
            } else if (opcao == 1) {
                System.out.print("Digite seu nome: ");
                String nome = scanner.nextLine();
                Pedido pedido = new Pedido(nome);

                // Exibir cardápio
                System.out.println("\n=== CARDÁPIO ===");
                for (ItemCardapio item : cardapio) {
                    item.exibirItem();
                }

                // Adicionar itens ao pedido
                while (true) {
                    System.out.print("Digite o número do item para adicionar (0 para finalizar): ");
                    int numeroEscolhido = scanner.nextInt();

                    if (numeroEscolhido == 0) {
                        break; // Sai do loop e finaliza o pedido
                    }

                    // Procurar o item no cardápio
                    ItemCardapio itemEscolhido = null;
                    for (ItemCardapio item : cardapio) {
                        if (item.getNumero() == numeroEscolhido) {
                            itemEscolhido = item;
                            break;
                        }
                    }

                    if (itemEscolhido != null) {
                        pedido.adicionarItem(itemEscolhido);
                    } else {
                        System.out.println("Número inválido! Escolha um item válido.");
                    }
                }

                pedido.exibirvalorfinal();
                System.out.print("Digite o valor do pagamento: ");
                float pagamento = scanner.nextFloat();
                pedido.exibirPedido(pagamento);
            } else {
                System.out.println("Opção inválida! Escolha 1 para Fazer Pedido ou 2 para Sair.");
            }
        }

        scanner.close();
    }
}
