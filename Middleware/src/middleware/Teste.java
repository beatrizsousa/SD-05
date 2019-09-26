/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.omg.CORBA.portable.InputStream;

/**
 *
 * @author biaso
 */
public class Teste {

    private ServerSocket server;
    private Socket client;
    private PrintWriter out;
    private String line;

    public Teste() {
        listenSocket();
    }

    public void listenSocket() {
        // Colocar o porto em escuta (Porto = 4500)
        try {
            server = new ServerSocket(8000);
        } catch (IOException e) {
            System.out.println("Could not listen on port 8000");
            System.exit(-1);
        }
        System.out.println("Listen on Port 8000");

        try {
            while (true) {
                client = server.accept();
                System.out.println("Client Accepted");
                System.out.println("IP: " + client.getInetAddress().getHostAddress() + " Conectado");

                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String output = br.readLine();

                //
                output = output.replace("[", "");
                output = output.replace("]", "");
                System.out.println(output);
                System.out.println("chegou!");

                String URL_MEDIA = "http://localhost:8080/PC01/webresources/generic/00000;" + output;
                URL obj = new URL(URL_MEDIA);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                int responseCode = con.getResponseCode();

            }
        } catch (Exception e) {
            System.out.println("erro 2");
        }
    }

    
}
