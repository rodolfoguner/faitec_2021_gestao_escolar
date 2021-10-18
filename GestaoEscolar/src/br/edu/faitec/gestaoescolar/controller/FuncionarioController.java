package br.edu.faitec.gestaoescolar.controller;

import br.edu.faitec.gestaoescolar.model.pojo.Funcionario;
import br.edu.faitec.gestaoescolar.model.dao.FuncionarioDAO;
import java.util.List;

/**
 * Aluno Controller é a classe responsável por receber controlar o fluxo de 
 * dados do programa, quando uma view precisa criar um novo aluno ou recuperar
 * um cadastro do arquivo ela deve se comunicar com a classe aluno controller.
 */

public class FuncionarioController {
    
    private FuncionarioController() {
    }
    
    private static FuncionarioController instance = null;
    
    public static  FuncionarioController getInstance() {
        if (instance == null){
            instance = new FuncionarioController();
        }
        return instance;
    }
    
    // Create do funcionario
    public boolean createFuncionario(String nome, String cpf, String email, 
            String celular, String endereco, String cargo, String salario){
        boolean resultado = true;
        // Cria um objeto funcionario
        Funcionario funcionario = new Funcionario();
        // Passa os parâmetros da view para o objeto e seus atributos
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setEmail(email);
        funcionario.setCelular(celular);
        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        // Envia o objeto para o método create do DAO
        resultado = FuncionarioDAO.getInstance().create(funcionario);
        return resultado;
    }
    
    public List<String> readAll() {
        return FuncionarioDAO.getInstance().read();
    }
    
    public boolean deleteByID (int idSelecionado) {
        return FuncionarioDAO.getInstance().deleteById(idSelecionado);
    }
}
