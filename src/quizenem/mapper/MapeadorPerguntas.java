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
import quizenem.model.Pergunta;

/**
 *
 * @author joaov
 */
public class MapeadorPerguntas implements Serializable{
    private HashMap<Integer, Pergunta> perguntas = new HashMap();
    private final String fileName = "perguntas.dat";

    public MapeadorPerguntas() {
        load();
    }

    public void put(Pergunta pergunta) {
        if(!perguntas.containsKey((Integer)pergunta.getID())){
            perguntas.put(pergunta.getID(), pergunta);
            persist();
        }
        else{
            System.out.println("ID USADO");
        }
    }
    
    public void remove(Pergunta pergunta) {
            perguntas.remove(pergunta.getID());
            persist();
    }

    public void persist() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(perguntas);
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
            perguntas = (HashMap<Integer, Pergunta>) in.readObject();
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

    public Pergunta getPergunta(int ID) {
        if (perguntas.containsKey(ID)) {
            return perguntas.get(ID);
        } else {
            return null;
        }
    }
    
    public HashMap<Integer, Pergunta> getPerguntas(){
        return perguntas;
    }
    
    public void setPerguntas(HashMap perguntas){
        this.perguntas = perguntas;
        System.err.println("Perguntas salvas.");
        persist();
    }
    
}
