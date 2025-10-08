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
        System.out.println("Connesso con successo");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        
        out.println("BenveServer 1.0");
        in.readLine();

        int n1 = Integer.parseInt(in.readLine());
        int n2 = Integer.parseInt(in.readLine());
        String opCode = in.readLine();

        int result;
        switch(opCode) {
            case "1":
              // +
              result = n1 + n2;
              break;
            case "2":
              // -
              result = n1 - n2;
              break;
            case "3":
              // /
              result = n1 / n2;
              break;
            case "4":
              // *
              result = n1 * n2;
              break;
            default:
                result = 0;
          }
        out.println(result);
    }
}