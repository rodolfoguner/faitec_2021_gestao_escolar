package br.edu.faitec.gestaoescolar.controller;

import br.edu.faitec.gestaoescolar.model.pojo.Aluno;
import br.edu.faitec.gestaoescolar.model.dao.AlunoDAO;
import java.util.List;

/**
 * Aluno Controller é a classe responsável por receber controlar o fluxo de 
 * dados do programa, quando uma view precisa criar um novo aluno ou recuperar
 * um cadastro do arquivo ela deve se comunicar com a classe aluno controller.
 */

public class AlunoController {
    
    private AlunoController() {
    }
    
    private static AlunoController instance = null;
    
    public static  AlunoController getInstance() {
        if (instance == null){
            instance = new AlunoController();
        }
        return instance;
    }
    
    // Create do aluno
    public boolean createAluno(String nome, String cpf, String email, 
            String celular, String endereco, String curso, String matricula){
        boolean resultado = true;
        // Cria um objeto aluno
        Aluno aluno = new Aluno();
        // Passa os parâmetros da view para o objeto e seus atributos
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setCelular(celular);
        aluno.setEndereco(endereco);
        aluno.setCurso(curso);
        aluno.setMatricula(matricula);
        // Envia o objeto para o método create do DAO
        resultado = AlunoDAO.getInstance().create(aluno);
        return resultado;
    }
    
    public List<String> readAll() {
        return AlunoDAO.getInstance().read();
    }
    
    public boolean deleteByID (int idSelecionado) {
        return AlunoDAO.getInstance().deleteById(idSelecionado);
    }
}
