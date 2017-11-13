/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.controller;

import javax.security.auth.login.LoginException;
import quizenem.mapper.MapeadorEquipes;
import quizenem.model.Diretor;
import quizenem.model.Equipe;
import quizenem.view.Moldura;

/**
 *
 * @author joaov
 */
public class ControladorPrincipal {
    private static ControladorPrincipal INSTANCE = null;
    private ControladorJogo controladorJogo;
    private ControladorAdm controladorAdm;
    private Moldura moldura = new Moldura();
    
    public static synchronized ControladorPrincipal getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ControladorPrincipal();
        }
        return INSTANCE;
    }
    
    public void login(String login, String senha) throws LoginException{
        if(login.equals(Diretor.getLogin()) && senha.equals(Diretor.getSenha())){
            controladorAdm = new ControladorAdm();
            moldura.getTelaDiretor();
        }
        MapeadorEquipes map = new MapeadorEquipes();
        Equipe equipe = map.getEquipe(login);
        if(equipe != null && equipe.getSenha().equals(senha)){
            controladorJogo = new ControladorJogo();
            moldura.getTelaEquipe();
        }
        else{
            throw new LoginException("LOGIN E/OU SENHA INVÁLIDOS");
        }
    }
    
    public void logout(){
        controladorAdm = null;
        controladorJogo = null;
        moldura.getTelaLogin();
    }
}
