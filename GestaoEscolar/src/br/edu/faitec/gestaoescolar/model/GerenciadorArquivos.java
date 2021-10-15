package br.edu.faitec.gestaoescolar.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// Gerencia o arquivo para fazer o CRUD
public class GerenciadorArquivos{
    //Singleton
    private GerenciadorArquivos() {}

    private static GerenciadorArquivos instance = null;

    public static GerenciadorArquivos getInstance() {
        if (instance == null) {
            instance = new GerenciadorArquivos();
        }
        return instance;
    }
    
    // Abre e cria o arquivo para salvar os dados
    public boolean salvaArquivo(String caminho, List<String> lista) throws IOException{
        boolean resultado = true;
        try {
            BufferedWriter gravarArquivo = new BufferedWriter(new FileWriter(new File(caminho), true));
            for (String aluno : lista) {
                gravarArquivo.write(aluno);
                gravarArquivo.write(",");
            }
            gravarArquivo.newLine();
            gravarArquivo.flush();
            gravarArquivo.close();
            resultado = false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    
    // Retorna os objetos dos arquivos
    public List<String> leArquivo(String caminho){
        List<String> listaArquivo = new ArrayList<>();
        try {
            BufferedReader lerArquivo = new BufferedReader(new FileReader(caminho));
            
            while (lerArquivo.ready()) {
                String linha = lerArquivo.readLine();
                listaArquivo.add(linha);
            }
            
            lerArquivo.close();
            
        } catch (IOException e) {
            System.out.printf("Erro na abertura do arquivo: %s. \n", e.getMessage());
        }
        
        return listaArquivo;
    }
    
    
}