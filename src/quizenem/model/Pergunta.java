/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

import java.io.Serializable;
import quizenem.enumeration.Dificuldade;
import quizenem.enumeration.TipoDePergunta;

/**
 *
 * @author joaov
 */
public class Pergunta implements Serializable {
    private final int ID;
    private final Dificuldade dificuldade;
    private final Resposta[] respostas;
    private final TipoDePergunta tipoDePergunta;

    public Pergunta(int ID, Dificuldade dificuldade, Resposta[] respostas, TipoDePergunta tipoDePergunta) {
        this.ID = ID;
        this.dificuldade = dificuldade;
        this.respostas = respostas;
        this.tipoDePergunta = tipoDePergunta;
    }

    public int getID() {
        return ID;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public Resposta[] getRespostas() {
        return respostas;
    }

    public TipoDePergunta getTipoDePergunta() {
        return tipoDePergunta;
    }
}
