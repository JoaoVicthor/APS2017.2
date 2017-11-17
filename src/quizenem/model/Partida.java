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

/**
 *
 * @author joaov
 */
public class Partida {
    private int[] rodada  = {1,1};
    private Pergunta[] perguntas = new Pergunta[12];
    private List<String> alunos = new ArrayList<>();
    private int respostas;
    private int acertos;
    private boolean perguntaIgnorada;
    
    public Partida(){
        MapeadorPerguntas map = new MapeadorPerguntas();
        
        List<Pergunta> perguntas = map.getPerguntas(TipoDePergunta.CN);
        Collections.shuffle(perguntas);
        for(int i = 0; i < 3; i++){
            this.perguntas[i] = perguntas.get(i);
        }
        
        perguntas = map.getPerguntas(TipoDePergunta.CH);
        Collections.shuffle(perguntas);
        for(int i = 3; i < 6; i++){
            this.perguntas[i] = perguntas.get(i);
        }
        
        perguntas = map.getPerguntas(TipoDePergunta.MAT);
        Collections.shuffle(perguntas);
        for(int i = 6; i < 9; i++){
            this.perguntas[i] = perguntas.get(i);
        }
        
        Random random = new Random();
        this.perguntas[9] = map.getPerguntaRandom(TipoDePergunta.LIN);
        this.perguntas[10] = map.getPerguntaRandom(TipoDePergunta.ING);
        this.perguntas[11] = map.getPerguntaRandom(TipoDePergunta.ESP);
    }
    
    public boolean avancarRodada(){
        if(rodada[0] < 3 && rodada[1] < 4){
            if(rodada[1] < 4){
                rodada[1]++;
            }
            else{
                rodada[0]++;
                rodada[1] = 1;
            }
            return true;
        }
        else{
            return false; //fim da partida
        }
    }
    
    public Pergunta getPergunta(){
        return perguntas[(rodada[0]-1)* 3 + rodada[1]];
    }
    
    public boolean checkResposta(String resposta){
        if(getPergunta().getRespostaCorreta().getTexto().equals(resposta)){
            acertos++;
            respostas++;
            return true;
        }
        else{
            respostas++;
            return false;
        }
    }
    
    public void ignorarPergunta() throws Exception{
        if(!perguntaIgnorada){
            perguntaIgnorada = true;
        }
        else{
            throw new Exception("VOCÊ JÁ IGNOROU UMA PERGUNTA NESSA PARTIDA!");
        }
    }

    public int getRespostas() {
        return respostas;
    }

    public int getAcertos() {
        return acertos;
    }
    
    public void setAlunos(List alunos){
        Collections.shuffle(alunos);
        this.alunos = alunos;
    }
    
    public String getAluno(){
        return alunos.get(((rodada[0]-1)* 3 + rodada[1]) % 6);
    }
}
