/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pro.escolamusica.modelo;

/**
 *
 * @author paulo
 */
public enum TipoCurso {
    
    CORDAS("Cordas"),
    MADEIRAS("Madeiras"),
    METAIS("Metais"),
    PERCUSSAO("Percussão");
    
    private String label;
    
    private TipoCurso(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
}
