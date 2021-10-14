package br.edu.faitec.gestaoescolar.model.dao;

import br.edu.faitec.gestaoescolar.model.pojo.Professor;
import br.edu.faitec.gestaoescolar.model.GerenciadorArquivos;
import java.util.List;
import java.util.ArrayList;

public class ProfessorDAO {
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
        List<String> listaProfessor = new ArrayList<>();
        listaProfessor.add(p.getNome());
        listaProfessor.add(p.getCpf());
        listaProfessor.add(p.getEmail());
        listaProfessor.add(p.getCelular());
        listaProfessor.add(p.getEndereco());
        // Finaliza a inserção da lista
        listaProfessor.add(";");
        aluno = String.join(",", listaProfessor);
        try {
            resultado = GerenciadorArquivos.getInstance().salvaArquivo(".//Dados//Professor.txt", aluno);
        } catch (Exception e) {
            System.out.printf("Não foi possível criar o aluno. %s", e.getMessage());
        }
        
        return resultado;
    }
    
}
