/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model.Respostas;

import java.io.Serializable;
import quizenem.enumeration.TipoDePergunta;

/**
 *
 * @author joaov
 */
public abstract class RespostasDaEquipe implements Serializable {

    int humanas, linguagens, natureza, matematica = 0;

    public int get(TipoDePergunta tipo) {
        switch (tipo) {
            case MAT:
                return matematica;
            case CH:
                return humanas;
            case CN:
                return natureza;
            default:
                return linguagens;
        }
    }
    
    public void add(TipoDePergunta tipo) {
        switch (tipo) {
            case MAT:
                matematica++;
                break;
            case CH:
                humanas++;
                break;
            case CN:
                natureza++;
                break;
            default:
                linguagens++;
                break;
        }
    }

}
