/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model.Respostas;

import quizenem.enumeration.TipoDePergunta;

/**
 *
 * @author joaov
 */
public class RespostasCorretas extends RespostasDaEquipe {

    public void add(TipoDePergunta tipo) {
        switch (tipo) {
            case MAT:
                addMatematica();
                break;
            case CH:
                addHumanas();
                break;
            case CN:
                addNatureza();
                break;
            default:
                addLinguagens();
                break;
        }
    }

}
