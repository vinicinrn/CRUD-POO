package Aplicar;

import Model.Pessoa;
import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        // laço pra verificar opções
        do {
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    new String[]{"Criar pessoa", "Listar pessoas", "Atualizar pessoa", "Deletar pessoa", "Sair"}, null);

            switch (opcao) {
                case 0:
                    // Criar e salvar uma pessoa
                    Pessoa pessoa = coletarInformacoesDoUsuario(scanner);
                    pessoaDAO.salvarPessoa(pessoa);
                    JOptionPane.showMessageDialog(null, "Pessoa criada e salva com sucesso!");
                    break;

                case 1:
                    // Listar todas as pessoas
                    List<Pessoa> pessoas = pessoaDAO.listarPessoas();
                    //string dinamicamente armazenando
                    StringBuilder listaPessoas = new StringBuilder("Listagem de Pessoas:\n");
                    for (Pessoa p : pessoas) {
                        listaPessoas.append("ID: ").append(p.getId()).append("\n");
                        listaPessoas.append("Nome: ").append(p.getNome()).append("\n");
                        listaPessoas.append("Endereço: ").append(p.getEndereco()).append("\n");
                        listaPessoas.append("Telefone: ").append(p.getTelefone()).append("\n");
                        listaPessoas.append("--------\n");
                    }
                    JOptionPane.showMessageDialog(null, listaPessoas.toString());
                    break;

                case 2:
                    // Atualizar uma pessoa existente (se houver)
                    pessoas = pessoaDAO.listarPessoas();
                    if (!pessoas.isEmpty()) {
                        int idPessoaAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa a ser atualizada: "));
                        Pessoa pessoaAtualizada = coletarInformacoesDoUsuario(scanner);
                        pessoaAtualizada.setId(idPessoaAtualizar);

                        pessoaDAO.atualizarPessoa(pessoaAtualizada);
                        JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há pessoas cadastradas para atualizar.");
                    }
                    break;

                case 3:
                    // Deletar uma pessoa existente (se houver)
                    pessoas = pessoaDAO.listarPessoas();
                    if (!pessoas.isEmpty()) {
                        int idPessoaDeletar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da pessoa a ser deletada: "));
                        pessoaDAO.deletarPessoa(idPessoaDeletar);
                        JOptionPane.showMessageDialog(null, "Pessoa deletada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há pessoas cadastradas para deletar.");
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa. Até mais!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        scanner.close();
    }

    // Método para coletar informações do usuário e criar um objeto Pessoa
    private static Pessoa coletarInformacoesDoUsuario(Scanner scanner) {
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa: ");
        String endereco = JOptionPane.showInputDialog("Digite o endereço da pessoa: ");
        String telefone = JOptionPane.showInputDialog("Digite o telefone da pessoa: ");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setEndereco(endereco);
        pessoa.setTelefone(telefone);

        return pessoa;
    }
}
