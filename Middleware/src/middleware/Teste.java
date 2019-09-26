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
import java.net.ServerSocket;
import java.net.Socket;
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
    
    public Teste(){
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

                DataInputStream in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                char dataType = in.readChar();
                System.out.println(in.readByte());
                System.out.println(in.readChar());
                int length = in.readInt();
                if (dataType == 's') {
                    byte[] messageByte = new byte[length];
                    boolean end = false;
                    StringBuilder dataString = new StringBuilder(length);
                    int totalBytesRead = 0;
                    while (!end) {
                        int currentBytesRead = in.read(messageByte);
                        totalBytesRead = currentBytesRead + totalBytesRead;
                        if (totalBytesRead <= length) {
                            dataString
                                    .append(new String(messageByte, 0, currentBytesRead, StandardCharsets.UTF_8));
                        } else {
                            dataString
                                    .append(new String(messageByte, 0, length - totalBytesRead + currentBytesRead,
                                                    StandardCharsets.UTF_8));
                        }
                        if (dataString.length() >= length) {
                            end = true;
                        }
                    }
                    System.out.println(dataString);
                }
            }
        } catch (Exception e) {
            System.out.println("erro 2");
        }
    }
}
