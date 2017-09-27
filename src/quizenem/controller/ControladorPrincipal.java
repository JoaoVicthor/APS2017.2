/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.controller;

/**
 *
 * @author joaov
 */
public class ControladorPrincipal {
    private static ControladorPrincipal INSTANCE = null;
    private ControladorJogo controladorJogo = new ControladorJogo();
    private ControladorAdm controladorAdm = new ControladorAdm();
    
    public static synchronized ControladorPrincipal getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ControladorPrincipal();
        }
        return INSTANCE;
    }
}
