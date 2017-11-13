/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizenem.mapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import quizenem.model.Equipe;
/**
 *
 * @author joaov
 */
public class MapeadorEquipes implements Serializable{
    private HashMap<String, Equipe> equipes = new HashMap();
    private final String fileName = "equipes.dat";

    public MapeadorEquipes() {
        load();
    }

        public void put(Equipe equipe) {
                equipes.put(equipe.getLogin(), equipe);
                persist();
    }
    
    public void remove(Equipe equipe) {
            equipes.remove(equipe.getLogin());
            persist();
    }

    public void persist() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(equipes);
            fileOut.flush();
            out.flush();
            fileOut.close();
            out.close();
            System.out.printf("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            System.err.print("Something went wrong with the saving I/O");
        }
    }

    private void load() {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            equipes = (HashMap<String, Equipe>) in.readObject();
            in.close();
            fileIn.close();
            in = null;
            fileIn = null;
        } catch (FileNotFoundException a) {
            System.err.println("Arquivo nao achado");
        } catch (IOException i) {
            System.err.print("Algo de errado ocorreu I/O");
        } catch (ClassNotFoundException c) {
            System.err.println("Algo de errado ocorreu Class not found");
        }
    }

    public Equipe getEquipe(String login) {
        if (equipes.containsKey(login)) {
            return equipes.get(login);
        } else {
            return null;
        }
    }
    
    public HashMap<String, Equipe> getEquipes(){
        return equipes;
    }
    
    public void setEquipes(HashMap equipes){
        this.equipes = equipes;
        System.err.println("equipes salvas.");
        persist();
    }

    public boolean verificaLogin(String login) throws Exception {
        if(equipes.containsKey(login)){
            return equipes.containsKey(login);
        }
        else{
            throw new Exception("LOGIN JÁ UTILIZADO");
        }
    }
    
}
