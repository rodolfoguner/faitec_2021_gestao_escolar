package br.edu.faitec.gestaoescolar.controller;

import br.edu.faitec.gestaoescolar.model.pojo.Professor;
import java.util.Date;

public class ProfessorController {
    // CRUD professor
    public boolean createAluno(String nome, String cpf, String email, 
            String celular, String endereco, Date dataAdmissao){
        // Cria um objeto professor
        Professor professor = new Professor();
        // Passa os parâmetros da view para o objeto e seus atributos
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setEmail(email);
        professor.setCelular(celular);
        professor.setEndereco(endereco);
        
        return true;
    } 
}
