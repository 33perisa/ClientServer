package org.example;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server čeka klijenta...");
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            int a = Integer.parseInt(in.readLine());
            int b = Integer.parseInt(in.readLine());
            out.println(a + b);

            socket.close();
        } catch (IOException e) {
            System.out.println("Greška na serveru.");
        }
    }
}