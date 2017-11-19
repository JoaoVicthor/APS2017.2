/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import quizenem.enumeration.TipoDePergunta;
import quizenem.mapper.MapeadorPerguntas;
import quizenem.model.Respostas.RespostasCorretas;
import quizenem.model.Respostas.RespostasErradas;

/**
 *
 * @author joaov
 */
public class Partida {

    private int rodada = 1;
    private Pergunta[] perguntas = new Pergunta[12];
    private List<String> alunos = new ArrayList<>();
    private RespostasCorretas respostasCorretas = new RespostasCorretas();
    private RespostasErradas respostasErradas = new RespostasErradas();
    private boolean perguntaIgnorada;

    public Partida(Equipe equipe) {
        MapeadorPerguntas map = new MapeadorPerguntas();

        List<Pergunta> perguntas = map.getPerguntas(TipoDePergunta.CN);
        Collections.shuffle(perguntas);
        for (int i = 0; i < 3; i++) {
            this.perguntas[i] = perguntas.get(i);
        }

        perguntas = map.getPerguntas(TipoDePergunta.CH);
        Collections.shuffle(perguntas);
        for (int i = 3; i < 6; i++) {
            this.perguntas[i] = perguntas.get(i - 3);
        }

        perguntas = map.getPerguntas(TipoDePergunta.MAT);
        Collections.shuffle(perguntas);
        for (int i = 6; i < 9; i++) {
            this.perguntas[i] = perguntas.get(i - 6);
        }

        Random random = new Random();
        this.perguntas[9] = map.getPerguntaRandom(TipoDePergunta.LIN);
        this.perguntas[10] = map.getPerguntaRandom(TipoDePergunta.ING);
        this.perguntas[11] = map.getPerguntaRandom(TipoDePergunta.ESP);
        this.alunos = equipe.getAlunos();
        Collections.shuffle(alunos);
    }

    public boolean avancarRodada() {
        if (rodada < 12) {
            rodada++;
            return true;
        } else {
            return false; //fim da partida
        }
    }

    public Pergunta getPergunta() {
        return perguntas[rodada - 1];
    }

    public boolean checkResposta(String resposta, TipoDePergunta tipo) {
        if (getPergunta().getRespostaCorreta().getTexto() == resposta) {
            respostasCorretas.add(tipo);
            return true;
        } else {
            respostasErradas.add(tipo);
            return false;
        }
    }

    public void ignorarPergunta() throws Exception {
        if (!perguntaIgnorada) {
            perguntaIgnorada = true;
        } else {
            throw new Exception("VOCÊ JÁ IGNOROU UMA PERGUNTA NESSA PARTIDA!");
        }
    }

    public Integer getAcertos(TipoDePergunta tipo) {
        return respostasCorretas.get(tipo);
    }

    public int getErros(TipoDePergunta tipo) {
        return respostasErradas.get(tipo);
    }

    public void setAlunos(List alunos) {
        Collections.shuffle(alunos);
        this.alunos = alunos;
    }

    public String getAluno() {
        return alunos.get((rodada - 1) % 6);
    }

    public Integer getRodada() {
        return rodada;
    }
}
