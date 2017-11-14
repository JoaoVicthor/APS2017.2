/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public class Resposta implements Serializable{
    private final boolean ehCorreta;
    private final String texto;

    public Resposta(boolean ehCorreta, String texto) {
        this.ehCorreta = ehCorreta;
        this.texto = texto;
    }

    public boolean ehCorreta() {
        return ehCorreta;
    }

    public String getTexto() {
        return texto;
    }
    
    
}
