package com.albe0x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(3000) ;
        Socket s = ss.accept();
        System.out.println("QUALCON OSI E' COLLEGATO");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        while (true) { 
            String input = in.readLine();
            System.out.println(input);

            if(input.compareTo("!") == 0){
                return;
            }

            out.println(input.toUpperCase());
        }
    }
}