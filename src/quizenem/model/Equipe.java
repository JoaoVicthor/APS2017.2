/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

import java.io.Serializable;
import java.util.ArrayList;
import quizenem.enumeration.TipoDePergunta;
import quizenem.model.Respostas.RespostasCorretas;
import quizenem.model.Respostas.RespostasErradas;

/**
 *
 * @author joaov
 */
public class Equipe implements Serializable {

    private int partidas = 0;
    private int desistencias = 0;
    private ArrayList<String> alunos = new ArrayList();
    private String nomeDaEquipe;
    private String login;
    private String senha;
    private RespostasCorretas acertos = new RespostasCorretas();
    private RespostasErradas erros = new RespostasErradas();

    public void defineLogin(String login) {
        this.login = login;
    }

    public void defineSenha(String senha) {
        this.senha = senha;
    }

    public void defineNomeDaEquipe(String nomeDaEquipe) {
        this.nomeDaEquipe = nomeDaEquipe;
    }

    public void addAluno(String nome) throws Exception {
        if (alunos.size() < 6) {
            alunos.add(nome);
        } else {
            throw new Exception("NÚMERO MÁXIMO DE ALUNOS ALCANÇADO!");
        }
    }

    public void removeAluno(String nome) {
        for (String aluno : alunos) {
            if (aluno == nome) {
                alunos.remove(aluno);
                break;
            }
        }
    }

    public String getAluno(int i) {
        return alunos.get(i);
    }

    public ArrayList getAlunos() {
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

    public void addPartida() {
        partidas++;
    }

    public void addDesistencia() {
        desistencias++;
    }

    public int getPartidas() {
        return partidas;
    }

    public int getDesistencias() {
        return desistencias;
    }

    public void addAcertos(int acertos, TipoDePergunta tipo) {
        for (int i = 0; i < acertos; i++) {
            this.acertos.add(tipo);
        }
    }

    public void addErros(int erros, TipoDePergunta tipo) {
        for (int i = 0; i < erros; i++) {
            this.erros.add(tipo);
        }
    }

}
