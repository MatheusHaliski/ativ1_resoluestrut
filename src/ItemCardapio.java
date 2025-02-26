public class ItemCardapio {
    private int numero;
    private String nome;
    private double preco;

    // Construtor
    public ItemCardapio(int numero, String nome, double preco) {
        this.numero = numero;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Método para exibir informações do item
    public void exibirItem() {
        System.out.println(numero + " - " + nome + " - R$ " + preco);
    }
}
