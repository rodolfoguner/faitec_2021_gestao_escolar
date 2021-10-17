package br.edu.faitec.gestaoescolar.model.dao;

import br.edu.faitec.gestaoescolar.model.GerenciadorArquivos;
import br.edu.faitec.gestaoescolar.model.pojo.Aluno;
import java.util.List;
import java.util.ArrayList;

/**
 * AlunoDAO é a classe responsável por se comunicar com o arquivo para gravar os
 * atributos ou recuperar os atributos disponíveis no arquivo.
 */

// Classe que vai conter as instruções para faze o CRUD
public class AlunoDAO {
    // Caminho para o arquivo
    private static final String caminho = ".//Dados//Alunos.dat";
    
    // Inicio do singleton
    private static AlunoDAO instance = null;
    public static AlunoDAO getInstance() {
        if (instance == null) {
            instance = new AlunoDAO();
        }
        return instance;
    }    
    
    // Insere o aluno para o arquivo
    public boolean create(Aluno a){
        boolean resultado =  true;
        String aluno;
        List<String> listaAlunos = new ArrayList<>();
        listaAlunos.add(a.getNome());
        listaAlunos.add(a.getCpf());
        listaAlunos.add(a.getEmail());
        listaAlunos.add(a.getCelular());
        listaAlunos.add(a.getEndereco());
        listaAlunos.add(a.getCurso());
        listaAlunos.add(a.getMatricula());
        listaAlunos.add(";");
        // Finaliza a inserção da lista
        try {
            resultado = GerenciadorArquivos.getInstance().salvaArquivo(caminho, listaAlunos);
        } catch (Exception e) {
            System.out.println("Não foi possível criar o aluno." + e.getMessage());
        }
        
        return resultado;
    }
    // Lista todos os os cadastros do Aluno
    public List<String> read() {
        return GerenciadorArquivos.getInstance().leArquivo(caminho);
    }
    // Apaga o aluno selecionado
    public boolean deleteById(int idSelecionado) {
        boolean resultado = true;
        List<String> lista = this.read();
        lista.remove(idSelecionado);
        try {
            GerenciadorArquivos.getInstance().limpaArquivo(caminho);
            for (String aluno: lista) {
                resultado = GerenciadorArquivos.getInstance().deleteByID(aluno, caminho);
            }
        } catch (Exception e) {
            System.out.println("Não foi possível deletar o aluno." + e.getMessage());
        }
        return resultado;
    }
}
