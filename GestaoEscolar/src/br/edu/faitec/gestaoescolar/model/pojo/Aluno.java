package br.edu.faitec.gestaoescolar.model.pojo;

/**
 * Classe filha que contém os atributos específicos.
 */

// Classe que contém os atributos e as regras de negócio do sistema
public class Aluno extends Usuario{
    private String curso;
    private String matricula;
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }  
    
}
