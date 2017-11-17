/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.enumeration;

/**
 *
 * @author joaov
 */
public enum TipoDePergunta {
    MAT("Matemática"), CN("Ciências da Natureza"), CH("Ciências Humanas"), LIN("Português"), ING("Inglês"), ESP("Espanhol");

    private final String texto;

    TipoDePergunta(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public static String[] getTextos() {
        String[] textos = {MAT.getTexto(), CN.getTexto(), CH.getTexto(), LIN.getTexto(), ING.getTexto(), ESP.getTexto()};
        return textos;
    }
}
