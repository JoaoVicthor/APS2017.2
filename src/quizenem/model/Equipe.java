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
    private String[] alunos = new String[5];
    private String nomeDaEquipe;
    private String login;
    private String senha;
    private RespostasCorretas acertos;
    private RespostasErradas erros;
    
    public void defineLogin(String login){
        if(!login.isEmpty()){
            this.login = login;
        }
    }
    
    public void defineSenha(String senha){
        if(!senha.isEmpty()){
            this.senha = senha;
        }
    }
    
    public void defineNomeDaEquipe(String nomeDaEquipe){
        if(!nomeDaEquipe.isEmpty()){
            this.nomeDaEquipe = nomeDaEquipe;
        }
    }
    
    public void addAluno(String nome){
        if(!nome.isEmpty() && alunosCadastrados < 5){
            for(int i = 0; i < 5 ; i++){
                if(alunos[i] == null){
                    alunos[i] = nome;
                    alunosCadastrados++;
                }
            } 
        }
    }
    
    public void removeAluno(String nome){
        for(int i = 0; i < 5; i++){
            if (alunos[i].equals(nome)){
                alunos[i] = null;
                alunosCadastrados--;
            }
        }
    }
    
    public String getAluno(int i){
        return alunos[i];
    }
    
    public void registraAcerto(TipoDePergunta tipo){
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
    
    public void registraErro(TipoDePergunta tipo){
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

    public RespostasCorretas getAcertos() {
        return acertos;
    }

    public RespostasErradas getErros() {
        return erros;
    }
    
    
    
}
