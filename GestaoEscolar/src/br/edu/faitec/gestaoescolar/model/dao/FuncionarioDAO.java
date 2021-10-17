package br.edu.faitec.gestaoescolar.model.dao;

import br.edu.faitec.gestaoescolar.model.GerenciadorArquivos;
import br.edu.faitec.gestaoescolar.model.pojo.Funcionario;
import java.util.List;
import java.util.ArrayList;

/**
 * AlunoDAO é a classe responsável por se comunicar com o arquivo para gravar os
 * atributos ou recuperar os atributos disponíveis no arquivo.
 */

// Classe que vai conter as instruções para faze o CRUD
public class FuncionarioDAO {
    // Caminho para o arquivo
    private static final String caminho = ".//Dados//Funcionario.dat";
    
    // Inicio do singleton
    private static FuncionarioDAO instance = null;
    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAO();
        }
        return instance;
    }    
    
    // Insere o aluno para o arquivo
    public boolean create(Funcionario f){
        boolean resultado =  true;
        String aluno;
        List<String> listaFuncionario = new ArrayList<>();
        listaFuncionario.add(f.getNome());
        listaFuncionario.add(f.getCpf());
        listaFuncionario.add(f.getEmail());
        listaFuncionario.add(f.getCelular());
        listaFuncionario.add(f.getEndereco());
        listaFuncionario.add(f.getCargo());
        listaFuncionario.add(f.getSalario());
        listaFuncionario.add(";");
        // Finaliza a inserção da lista
        try {
            resultado = GerenciadorArquivos.getInstance().salvaArquivo(caminho, listaFuncionario);
        } catch (Exception e) {
            System.out.printf("Não foi possível criar o aluno. %s", e.getMessage());
        }
        
        return resultado;
    }
    
    public List<String> read() {
        return GerenciadorArquivos.getInstance().leArquivo(caminho);
    }
    
}
