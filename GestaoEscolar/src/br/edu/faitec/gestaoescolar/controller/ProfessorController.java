package br.edu.faitec.gestaoescolar.controller;

import br.edu.faitec.gestaoescolar.model.dao.ProfessorDAO;
import br.edu.faitec.gestaoescolar.model.pojo.Professor;

public class ProfessorController {
    // Inicio do singleton
    private ProfessorController(){
    }
    private static ProfessorController instance = null;
    public static ProfessorController getInstance(){
        if (instance == null) {
            instance = new ProfessorController();
        }
        return instance;
    }
    
    // CRUD professor
    public boolean createProfessor(String nome, String cpf, String email, 
            String celular, String endereco){
        boolean resultado = true;
        // Cria um objeto professor
        Professor professor = new Professor();
        // Passa os parâmetros da view para o objeto e seus atributos
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setEmail(email);
        professor.setCelular(celular);
        professor.setEndereco(endereco);
        
        resultado = ProfessorDAO.getInstance().create(professor);
        
        return true;
    } 
}
