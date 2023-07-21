package Model;

public class Pessoa {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;

    // Construtor da classe Pessoa
    public Pessoa() {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Métodos getters e setters para os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método para exibir as informações da pessoa
    public void exibirInformacoes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.exibirInformacoes();
    }
}


