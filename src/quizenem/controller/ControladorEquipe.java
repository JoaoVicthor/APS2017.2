/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.controller;

import quizenem.mapper.MapeadorEquipes;
import quizenem.model.Equipe;
import quizenem.model.Partida;

/**
 *
 * @author joaov
 */
public class ControladorEquipe {

    Partida partida;
    Equipe equipe;

    public ControladorEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void incluirAluno(String aluno) throws Exception {
        if (!aluno.isEmpty()) {
            MapeadorEquipes map = new MapeadorEquipes();
            equipe.addAluno(aluno);
            map.put(equipe);
        } else {
            throw new Exception("PREENCHA COM O NOME DO ALUNO!");
        }

    }

    public void removerAluno(String aluno) {
        MapeadorEquipes map = new MapeadorEquipes();
        equipe.removeAluno(aluno);
        map.put(equipe);
    }

    public String[] getAlunos() {
        if (equipe.getAlunos().size() > 0) {
            String[] alunos = new String[equipe.getAlunos().size()];
            for (int i = 0; i <= alunos.length - 1; i++) {
                alunos[i] = equipe.getAluno(i);
            }
            return alunos;
        } else {
            return new String[0];
        }

    }

    public void iniciarPartida() {
        partida = new Partida();
    }

    public String getResposta(int i) {
        return partida.getPergunta().getRespostas()[i].getTexto();
    }

    public void avancarRodada(String resposta) throws Exception {
        if (resposta != null) {
            resposta.equals(partida.getPergunta().getRespostaCorreta().getTexto());
        } else {
            ignorarPergunta();
        }
        if (partida.avancarRodada()) {
            refreshTela();
        } else {
            getTelaEstatisticas();
        }
    }

    public void desistir() {
        getTelaEstatisticas();
    }

    public void ignorarPergunta() throws Exception {
        avancarRodada(null);
    }

    public String getAluno() {
        return partida.getAluno();
    }

    public String getTextoPergunta() {
        return partida.getPergunta().getTexto();
    }

    public String getTipoPergunta() {
        return partida.getPergunta().getTipoDePergunta().getTexto();
    }

    public Equipe getEquipe() {
        return equipe;
    }

}
