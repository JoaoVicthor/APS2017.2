/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

import java.io.Serializable;
import quizenem.enumeration.TipoDePergunta;

/**
 *
 * @author joaov
 */
public class Pergunta implements Serializable {
    private final String texto;
    private final Resposta[] respostas;
    private final TipoDePergunta tipoDePergunta;

    public Pergunta(String texto, Resposta[] respostas, TipoDePergunta tipoDePergunta) {
        this.texto = texto;
        this.respostas = respostas;
        this.tipoDePergunta = tipoDePergunta;
    }

    public Resposta[] getRespostas() {
        return respostas;
    }

    public TipoDePergunta getTipoDePergunta() {
        return tipoDePergunta;
    }
}
