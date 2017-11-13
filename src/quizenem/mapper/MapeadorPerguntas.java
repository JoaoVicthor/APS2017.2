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
import java.util.ArrayList;
import java.util.HashMap;
import quizenem.model.Pergunta;

/**
 *
 * @author joaov
 */
public class MapeadorPerguntas implements Serializable{
    private ArrayList<Pergunta> perguntas = new ArrayList<>();
    private final String fileName = "perguntas.dat";

    public MapeadorPerguntas() {
        load();
    }

    public void put(Pergunta pergunta) {
            perguntas.add(pergunta);
            persist();

    }
    
    public void remove(Pergunta pergunta) {
            perguntas.remove(pergunta);
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
            perguntas = (ArrayList<Pergunta>) in.readObject();
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
        return perguntas.get(ID);
    }
    
    public ArrayList<Pergunta> getPerguntas(){
        return perguntas;
    }
    
    public void setPerguntas(ArrayList<Pergunta> perguntas){
        this.perguntas = perguntas;
        System.err.println("Perguntas salvas.");
        persist();
    }
    
}
