package com.albe0x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.print.DocFlavor.STRING;

public class ClientManager extends Thread {
    Socket s;
    private static ArrayList<String> lista1 = new ArrayList<>(Arrays.asList(
            "Marco Rossi", "Ivan Bruno", "Giulia Neri", "Luca Bianchi", "Sara Galli"));

    private static ArrayList<String> lista2 = new ArrayList<>(Arrays.asList(
            "Ciccio Bello", "Francesca Pini", "Giorgio Verdi", "Marta Lodi", "Claudio Benvenuti", "Pippo Baudo"));

    private static ArrayList<String> lista3 = new ArrayList<>(Arrays.asList(
            "Anna Rosa", "Paolo Conti", "Davide Leone", "Chiara Valli", "Elisa Greco"));

    private static final ArrayList<ArrayList<String>> liste = new ArrayList<>(
            Arrays.asList(lista1, lista2, lista3));

    public ClientManager(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            Myrun();
        } catch (IOException e) {
            System.out.println("Problemi problemi !!");
        }
    }

    public void Myrun() throws IOException {
        System.out.println("Connesso con successo");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("BenveServer 3.0");

        while (true) {
            String sriga = in.readLine();
            if (sriga.compareTo("!") == 0) {
                return;
            }

            int riga = Integer.parseInt(sriga) - 1;
            if(liste.size() < riga){
                out.println("KO");
                break;
            } else{
                out.println("OK");
            }

            int posizione = Integer.parseInt(in.readLine()) - 1;
            if((liste.get(riga)).size() < posizione){
                out.println("KO");
                break;
            }
            out.println("OK");
            out.println(liste.get(riga).get(posizione));

        }
    }
}
