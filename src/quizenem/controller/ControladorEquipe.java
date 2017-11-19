/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.controller;

import quizenem.enumeration.TipoDePergunta;
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

    public void iniciarPartida() throws Exception {
        if (equipe.getAlunos().size() == 6) {
            partida = new Partida(equipe);
        } else {
            throw new Exception("É NECESSÁRIO TER 6 ALUNOS CADASTRADOS ANTES DE INICIAR PARTIDA!");
        }
    }

    public String getResposta(int i) {
        return partida.getPergunta().getRespostas()[i].getTexto();
    }

    public boolean avancarRodada(String resposta) {
        partida.checkResposta(resposta, partida.getPergunta().getTipoDePergunta());
        return partida.avancarRodada();
    }

    public void finalizarPartida() {
        for (TipoDePergunta tipo : TipoDePergunta.values()) {
            if (tipo == TipoDePergunta.ING || tipo == TipoDePergunta.ESP) {
                break;
            }
            passaRespostas(tipo);
        }
        equipe.addPartida();
        MapeadorEquipes map = new MapeadorEquipes();
        map.put(equipe);
        partida = null;
    }

    public void passaRespostas(TipoDePergunta tipo) {
        equipe.addAcertos(partida.getAcertos(tipo), tipo);
        equipe.addErros(partida.getErros(tipo), tipo);
    }

    public void ignorarPergunta() throws Exception {
        partida.ignorarPergunta();
        partida.avancarRodada();
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

    public Integer getRodada() {
        return partida.getRodada();
    }

    public Integer getAcertos(TipoDePergunta tipo) {
        if (tipo == TipoDePergunta.LIN) {
            return partida.getAcertos(tipo) + partida.getAcertos(TipoDePergunta.ESP) + partida.getAcertos(TipoDePergunta.ING);
        }
        return partida.getAcertos(tipo);
    }

}
