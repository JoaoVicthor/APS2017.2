/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.view;

import java.awt.Dimension;

/**
 *
 * @author joaov
 */
public class Moldura extends javax.swing.JFrame {

    /**
     * Creates new form Moldura
     */
    public Moldura() {
        super();
        initComponents();
        getTelaLogin();
        setMinimumSize(new Dimension(600, 600));
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public void getTelaLogin(){
        LoginPanel loginPanel = new LoginPanel();
        add(loginPanel);
        loginPanel.setVisible(true);
        revalidate();
        repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
