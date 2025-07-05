package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Klijent {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Unesite dva broja: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            out.println(a);
            out.println(b);
            System.out.println("Zbir: " + in.readLine());
        } catch (IOException e) {
            System.out.println("Greška na klijentu.");
        }
    }
}
