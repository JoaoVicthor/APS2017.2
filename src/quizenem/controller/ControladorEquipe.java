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
    
    public ControladorEquipe(Equipe equipe){
        this.equipe = equipe;
    }
    
    public void incluirAluno(String aluno) throws Exception{
        MapeadorEquipes map = new MapeadorEquipes();
        equipe.addAluno(aluno);
        map.put(equipe);
    }
    
    public void removerAluno(String aluno){
        MapeadorEquipes map = new MapeadorEquipes();
        equipe.removeAluno(aluno);
        map.put(equipe);
    }
    
    public String[] getAlunos(){
        return equipe.getAlunos();
    }
    
    public void iniciarPartida(){
        partida = new Partida();
    }
    
    public String getResposta(int i){
        return partida.getPergunta().getRespostas()[i].getTexto();
    }
    
    public void avancarRodada(String resposta) throws Exception{
        if(resposta != null){
            resposta.equals(partida.getPergunta().getRespostaCorreta().getTexto());    
        }
        else{
            partida.ignorarPergunta();
        }
        if(partida.avancarRodada()){
            refreshTela();
        }
        else{
            getTelaEstatisticas();
        }
    }
    
    public void desistir(){
        getTelaEstatisticas();
    }
    
}
