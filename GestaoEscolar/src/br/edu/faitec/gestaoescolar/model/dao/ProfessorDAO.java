package br.edu.faitec.gestaoescolar.model.dao;

import br.edu.faitec.gestaoescolar.model.GerenciadorArquivos;
import br.edu.faitec.gestaoescolar.model.pojo.Professor;     
import java.util.List;
import java.util.ArrayList;

// Classe que vai conter as instruções para faze o CRUD
public class ProfessorDAO {
    // Caminho para o arquivo
    private static final String caminho = ".//Dados//Professor.txt";
    
    // Inicio do singleton
    private static ProfessorDAO instance = null;
    public static ProfessorDAO getInstance() {
        if (instance == null) {
            instance = new ProfessorDAO();
        }
        return instance;
    }    
    
    // Insere o aluno para o arquivo
    public boolean create(Professor p){
        boolean resultado =  true;
        String aluno;
        List<String> professorLista = new ArrayList<>();
        professorLista.add(p.getNome());
        professorLista.add(p.getCpf());
        professorLista.add(p.getEmail());
        professorLista.add(p.getCelular());
        professorLista.add(p.getEndereco());
        professorLista.add(";");
        // Finaliza a inserção da lista
        try {
            resultado = GerenciadorArquivos.getInstance().salvaArquivo(caminho, professorLista);
        } catch (Exception e) {
            System.out.printf("Não foi possível criar o aluno. %s", e.getMessage());
        }
        return resultado;
    }
    
    public List<String> read() {
        return GerenciadorArquivos.getInstance().leArquivo(caminho);
    }
    
}
