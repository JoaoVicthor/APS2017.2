/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

import java.io.Serializable;
import quizenem.enumeration.TipoDePergunta;
import quizenem.model.Respostas.RespostasCorretas;
import quizenem.model.Respostas.RespostasErradas;

/**
 *
 * @author joaov
 */
public class Equipe implements Serializable{
    private int alunosCadastrados = 0;
    private int partidas = 0;
    private int desistencias = 0;
    private String[] alunos = new String[6];
    private String nomeDaEquipe;
    private String login;
    private String senha;
    private RespostasCorretas acertos;
    private RespostasErradas erros;
    
    public void defineLogin(String login){
            this.login = login;
    }
    
    public void defineSenha(String senha){
            this.senha = senha;
    }
    
    public void defineNomeDaEquipe(String nomeDaEquipe){
            this.nomeDaEquipe = nomeDaEquipe;
    }
    
    public void addAluno(String nome){
        if(alunosCadastrados < 6){
            for(int i = 0; i < 6 ; i++){
                if(alunos[i] == null){
                    alunos[i] = nome;
                    alunosCadastrados++;
                }
            } 
        }
    }
    
    public void removeAluno(String nome){
        for(int i = 0; i < 6; i++){
            if (alunos[i].equals(nome)){
                alunos[i] = null;
                alunosCadastrados--;
            }
        }
    }
    
    public String getAluno(int i){
        return alunos[i];
    }
    
    public void addAcerto(TipoDePergunta tipo){
        switch (tipo) {
            case MAT:
                acertos.addMatematica();
                break;
            case CH:
                acertos.addHumanas();
                break;
            case CN:
                acertos.addNatureza();
                break;
            default:
                acertos.addLinguagens();
                break;
        }
    }
    
    public void addErro(TipoDePergunta tipo){
        switch (tipo) {
            case MAT:
                erros.addMatematica();
                break;
            case CH:
                erros.addHumanas();
                break;
            case CN:
                erros.addNatureza();
                break;
            default:
                erros.addLinguagens();
                break;
        }
    }

    public int getAlunosCadastrados() {
        return alunosCadastrados;
    }

    public String[] getAlunos() {
        return alunos;
    }

    public String getNomeDaEquipe() {
        return nomeDaEquipe;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getAcertos(TipoDePergunta tipo) {
        switch (tipo) {
            case MAT:
                return acertos.getMatematica();
            case CH:
                return acertos.getHumanas();
            case CN:
                return acertos.getNatureza();
            default:
                 return acertos.getLinguagens();
        }
    }

    public int getErros(TipoDePergunta tipo) {
        switch (tipo) {
            case MAT:
                return erros.getMatematica();
            case CH:
                return erros.getHumanas();
            case CN:
                return erros.getNatureza();
            default:
                 return erros.getLinguagens();
        }
    }
    
    public void addPartida(){
        partidas ++;
    }
    
    public void addDesistencia(){
        desistencias ++;
    }

    public int getPartidas() {
        return partidas;
    }

    public int getDesistencias() {
        return desistencias;
    }
    
    
    
    
    
}
