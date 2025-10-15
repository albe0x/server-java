package com.albe0x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManager extends Thread {
    Socket s;

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

        out.println("BenveServer 2.0");
        String clientVersion = in.readLine();
        System.out.println(clientVersion);

        while (true) {
            int n1, n2;
            try {
                n1 = Integer.parseInt(in.readLine());
                System.out.println(n1);
                n2 = Integer.parseInt(in.readLine());
                System.out.println(n2);
            } catch (NumberFormatException e) {
                return;
            }

            String opCode = in.readLine();
            System.out.println(opCode);

            double result;
            switch (opCode) {
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
                    result = (double) n1 / n2;
                    break;
                case "4":
                    // *
                    result = n1 * n2;
                    break;
                default:
                    result = 0;
                    s.close();
                    return;
            }
            out.println(result);
            System.out.println(result);
        }
    }
}
