package Aplicar;
import Model.Pessoa;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PessoaDAO pessoaDAO = new PessoaDAO();

        // Criar e salvar uma pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Thaina");
        pessoa.setEndereco("Rua das Flores, 123");
        pessoa.setTelefone("(11) 99999-9999");
        pessoaDAO.salvarPessoa(pessoa);

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

        // Atualizar uma pessoa existente (se houver)
        if (!pessoas.isEmpty()) {
            Pessoa pessoaAtualizada = pessoas.get(0);
            pessoaAtualizada.setNome("Maria");
            pessoaAtualizada.setEndereco("Av. das Palmeiras, 456");
            pessoaAtualizada.setTelefone("(11) 88888-8888");
            pessoaDAO.atualizarPessoa(pessoaAtualizada);
            System.out.println("Pessoa atualizada com sucesso!");
        } else {
            System.out.println("Não há pessoas cadastradas para atualizar.");
        }

        // Deletar uma pessoa existente (se houver)
        if (!pessoas.isEmpty()) {
            int idPessoaParaDeletar = pessoas.get(0).getId();
            pessoaDAO.deletarPessoa(idPessoaParaDeletar);
            System.out.println("Pessoa deletada com sucesso!");
        } else {
            System.out.println("Não há pessoas cadastradas para deletar.");
        }

        // Listar novamente após a exclusão
        pessoas = pessoaDAO.listarPessoas();
        System.out.println("Listagem de Pessoas após a exclusão:");
        for (Pessoa p : pessoas) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Endereço: " + p.getEndereco());
            System.out.println("Telefone: " + p.getTelefone());
            System.out.println("--------");
        }
    }
}
