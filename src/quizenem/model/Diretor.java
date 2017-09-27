/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.model;

/**
 *
 * @author joaov
 */
public abstract class Diretor {
    private static final String LOGIN = "diretor";
    private static final String SENHA = "99443322";

    public static String getLogin() {
        return LOGIN;
    }

    public static String getSenha() {
        return SENHA;
    }
}
