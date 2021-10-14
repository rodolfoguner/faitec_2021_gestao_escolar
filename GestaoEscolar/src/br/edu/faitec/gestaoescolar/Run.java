package br.edu.faitec.gestaoescolar;

import javax.swing.JFrame;
import br.edu.faitec.gestaoescolar.view.ViewPrincipal;

/**
 * Projeto Faitec: Gestão escolar.
 * <p>
 * Autores: Anilson de Cássia, Enthony Eduardo e Rodolfo Mamud.
 * <p>
 * Objetivo: O objetivo do projeto é criar um sistema que seja confiável para
 * uma escola registrar os dados dos alunos, professores e cursos de maneira 
 * fácil de consulta e utilização. 
 * 
 */
public class Run {
    public static void main(String[] args) {
        // Inicia a tela principal do sistema
        ViewPrincipal vPrincipal = new ViewPrincipal();
        vPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
        
    }
    
}
