/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.controller;

import java.awt.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import quizenem.enumeration.TipoDePergunta;
import quizenem.mapper.MapeadorEquipes;
import quizenem.mapper.MapeadorPerguntas;
import quizenem.model.Equipe;
import quizenem.model.Pergunta;
import quizenem.model.Resposta;

/**
 *
 * @author joaov
 */
public class ControladorDiretor {

    Equipe equipe;

    public void cadastrarEquipe(String nome, String login, String senha, String confirmacao) throws Exception {
        MapeadorEquipes mapEquipes = new MapeadorEquipes();
        if (!nome.isEmpty() && !login.isEmpty() && !senha.isEmpty() && !confirmacao.isEmpty()) {
            if (!mapEquipes.verificaLogin(login)) {
                if (senha.equals(confirmacao)) {
                    Equipe equipe = new Equipe();
                    equipe.defineLogin(login);
                    equipe.defineNomeDaEquipe(nome);
                    equipe.defineSenha(senha);
                    mapEquipes.put(equipe);
                    System.out.println("EQUIPE CADASTRADA COM SUCESSO.");
                } else {
                    throw new Exception("SENHA E CONFIRMAÇÃO NAO BATEM!");
                }
            } else {
                throw new Exception("LOGIN JÁ UTILIZADO");
            }
        } else {
            throw new Exception("É NECESSÁRIO PREENCHER TODOS OS CAMPOS!");
        }
    }

    public void cadastrarPergunta(String tipoTexto, String texto, String errada1,
            String errada2, String errada3, String errada4, String certa) throws Exception {
        if (!texto.isEmpty() && !errada1.isEmpty() && !errada2.isEmpty() && !errada3.isEmpty()
                && !errada4.isEmpty() && !certa.isEmpty()) {
            MapeadorPerguntas map = new MapeadorPerguntas();

            Resposta resposta1 = new Resposta(false, errada1);
            Resposta resposta2 = new Resposta(false, errada2);
            Resposta resposta3 = new Resposta(false, errada3);
            Resposta resposta4 = new Resposta(false, errada4);
            Resposta resposta5 = new Resposta(true, certa);

            TipoDePergunta tipo = TipoDePergunta.MAT;
            for (TipoDePergunta area : TipoDePergunta.values()) {
                if (area.getTexto().equals(tipoTexto)) {
                    tipo = area;
                }
            }
            Resposta[] respostas = {resposta1, resposta2, resposta3, resposta4, resposta5};
            respostas = shuffleRespostas(respostas);
            
            Pergunta pergunta = new Pergunta(texto, respostas, tipo);
            map.put(pergunta, tipo);

            System.out.println("PERGUNTA CADASTRADA COM SUCESSO.");

        } else {
            throw new Exception("É NECESSÁRIO PREENCHER TODOS OS CAMPOS!");
        }
    }

    public Vector getEquipes() {
        MapeadorEquipes map = new MapeadorEquipes();
        Vector vector = new Vector();
        for (String key : map.getEquipes().keySet()) {
            vector.add(key);
        }
        return vector;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        MapeadorEquipes map = new MapeadorEquipes();
        this.equipe = map.getEquipe(equipe);
    }

    public float getPercentual(TipoDePergunta tipo) {
        int total = equipe.getAcertos(tipo) + equipe.getErros(tipo);
        if(total > 0){
            return equipe.getAcertos(tipo) / total;
        }
        else{
            return 0;
        }
        
    }

    public Integer getPartidasJogadas() {
        return equipe.getPartidas();
    }

    public Integer getDesistencias() {
        return equipe.getDesistencias();
    }

    private Resposta[] shuffleRespostas(Resposta[] respostas) {
        int index;
        Resposta temp;
        Random random = new Random();
        for (int i = respostas.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = respostas[index];
            respostas[index] = respostas[i];
            respostas[i] = temp;
        }
        return respostas;

    }

}
