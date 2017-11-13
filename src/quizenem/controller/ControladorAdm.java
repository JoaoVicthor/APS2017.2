/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.controller;

import javax.security.auth.login.LoginException;
import quizenem.enumeration.TipoDePergunta;
import quizenem.mapper.MapeadorEquipes;
import quizenem.mapper.MapeadorPerguntas;
import quizenem.model.Diretor;
import quizenem.model.Equipe;

/**
 *
 * @author joaov
 */
public class ControladorAdm {

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
            }
        }
        else{
            throw new Exception("É NECESSÁRIO PREENCHER TODOS OS CAMPOS!");
        }
    }
    
    public void cadastrarPergunta(TipoDePergunta tipo, String pergunta, String errada1,
            String errada2, String errada3, String errada4, String certa){
        
        
    }
}
