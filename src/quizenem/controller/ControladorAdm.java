/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.controller;

import quizenem.mapper.MapeadorEquipes;
import quizenem.mapper.MapeadorPerguntas;
import quizenem.model.Diretor;
import quizenem.model.Equipe;

/**
 *
 * @author joaov
 */
public class ControladorAdm {
    private MapeadorEquipes mapEquipes = new MapeadorEquipes();
    private MapeadorPerguntas mapPerguntas = new MapeadorPerguntas();
    
    public boolean cadastrarEquipe(String nome, String login, String senha, String confirmacao){
        if (!mapEquipes.verificaLogin(login) && senha.equals(confirmacao)){
            Equipe equipe = new Equipe();
            equipe.defineLogin(login);
            equipe.defineNomeDaEquipe(nome);
            equipe.defineSenha(senha);
            mapEquipes.put(equipe);
            return true;
        }
        else{
            return false;
        }
    }
    
}
