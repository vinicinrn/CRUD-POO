package Aplicar;

import Model.Pessoa;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Atualizar pessoa");
            System.out.println("4 - Deletar pessoa");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner após a leitura do inteiro

            switch (opcao) {
                case 1:
                    // Criar e salvar uma pessoa
                    Pessoa pessoa = coletarInformacoesDoUsuario(scanner);
                    pessoaDAO.salvarPessoa(pessoa);
                    System.out.println("Pessoa criada e salva com sucesso!");
                    break;

                case 2:
                    // Listar todas as pessoas
                    List<Pessoa> pessoas = pessoaDAO.listarPessoas();
                    System.out.println("Listagem de Pessoas:");
                    for (Pessoa p : pessoas) {
                        System.out.println("ID: " + p.getId());
                        System.out.println("Nome: " + p.getNome());
                        System.out.println("Endereço: " + p.getEndereco());
                        System.out.println("Telefone: " + p.getTelefone());
                        System.out.println("--------");
                    }
                    break;

                case 3:
                    // Atualizar uma pessoa existente (se houver)
                    pessoas = pessoaDAO.listarPessoas();
                    if (!pessoas.isEmpty()) {
                        System.out.println("Digite o ID da pessoa a ser atualizada: ");
                        int idPessoaAtualizar = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer do scanner após a leitura do inteiro

                        Pessoa pessoaAtualizada = coletarInformacoesDoUsuario(scanner);
                        pessoaAtualizada.setId(idPessoaAtualizar);

                        pessoaDAO.atualizarPessoa(pessoaAtualizada);
                        System.out.println("Pessoa atualizada com sucesso!");
                    } else {
                        System.out.println("Não há pessoas cadastradas para atualizar.");
                    }
                    break;

                case 4:
                    // Deletar uma pessoa existente (se houver)
                    pessoas = pessoaDAO.listarPessoas();
                    if (!pessoas.isEmpty()) {
                        System.out.println("Digite o ID da pessoa a ser deletada: ");
                        int idPessoaDeletar = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer do scanner após a leitura do inteiro

                        pessoaDAO.deletarPessoa(idPessoaDeletar);
                        System.out.println("Pessoa deletada com sucesso!");
                    } else {
                        System.out.println("Não há pessoas cadastradas para deletar.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Método para coletar informações do usuário e criar um objeto Pessoa
    private static Pessoa coletarInformacoesDoUsuario(Scanner scanner) {
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o endereço da pessoa: ");
        String endereco = scanner.nextLine();

        System.out.println("Digite o telefone da pessoa: ");
        String telefone = scanner.nextLine();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setEndereco(endereco);
        pessoa.setTelefone(telefone);

        return pessoa;
    }
}
