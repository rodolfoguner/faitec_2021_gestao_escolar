package br.edu.faitec.gestaoescolar.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import javax.security.auth.callback.TextOutputCallback;

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
        try {
            BufferedWriter gravarArquivo = new BufferedWriter(new FileWriter(new File(caminho), true));
            for (String aluno : lista) {
                gravarArquivo.write(aluno);
                gravarArquivo.write(",");
            }
            gravarArquivo.newLine();
            gravarArquivo.flush();
            gravarArquivo.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    // Retorna os objetos dos arquivos
    public List<String> leArquivo(String caminho){
        List<String> listaArquivo = new ArrayList<>();
        try {
            BufferedReader lerArquivo = new BufferedReader(new FileReader(caminho));
            
            while (lerArquivo.ready()) {
                String linha = lerArquivo.readLine();
                listaArquivo.add(linha);
                /*String texto [] = linha.split(";");
                for (int i = 0; i < texto.length; i++) {
                    String textoSeparado [] = texto[i].split(",");
                    for (int j = 0; j < 7; j++) {
                        listaArquivo.add(textoSeparado[j]);
                    }
                }*/
            }
            
            lerArquivo.close();
            
        } catch (IOException e) {
            System.out.printf("Erro na abertura do arquivo: %s. \n", e.getMessage());
        }
        
        return listaArquivo;
    }
    
    
}