package br.edu.faitec.gestaoescolar.model.pojo;

/**
 * Classe usuario é a classe abstrata que contém os atributos que serão utilizados
 * pelas outras classes filho.
 */

public abstract class Usuario {
    // Criando uma classe base que tera os atributos de todos usuarios
    private String nome;
    private String cpf;
    private String email;
    private String celular;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}

