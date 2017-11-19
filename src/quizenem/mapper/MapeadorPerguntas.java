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
import java.util.List;
import java.util.Random;
import quizenem.enumeration.TipoDePergunta;
import quizenem.model.Pergunta;
import quizenem.util.Multimap;

/**
 *
 * @author joaov
 */
public class MapeadorPerguntas implements Serializable {

    private final String fileName = "perguntas.dat";
    private Multimap<TipoDePergunta, Pergunta> perguntas = new Multimap();

    public MapeadorPerguntas() {
        load();
    }

    public void put(Pergunta pergunta, TipoDePergunta tipo) {
        perguntas.putOne(tipo, pergunta);
        persist();

    }

    public void remove(Pergunta pergunta, TipoDePergunta tipo) {
        perguntas.remove(tipo, pergunta);
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
            perguntas = (Multimap<TipoDePergunta, Pergunta>) in.readObject();
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

    public List<Pergunta> getPerguntas(TipoDePergunta tipo) {
        return perguntas.get(tipo);
    }

    public Pergunta getPerguntaRandom(TipoDePergunta tipo) {
        Random random = new Random();
        List<Pergunta> list = getPerguntas(tipo);
        return list.get(random.nextInt(list.size() - 1));
    }

}
