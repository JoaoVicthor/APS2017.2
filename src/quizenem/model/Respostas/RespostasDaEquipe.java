/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model.Respostas;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public abstract class RespostasDaEquipe implements Serializable {
    int humanas, linguagens, natureza, matematica = 0;
    
    public void addHumanas(){
        humanas++;
    }
    
    public void addLinguagens(){
        linguagens++;
    }
    
    public void addNatureza(){
        natureza++;
    }
    
    public void addMatematica(){
        matematica++;
    }

    public int getHumanas() {
        return humanas;
    }

    public int getLinguagens() {
        return linguagens;
    }

    public int getNatureza() {
        return natureza;
    }

    public int getMatematica() {
        return matematica;
    }
    
    
}
