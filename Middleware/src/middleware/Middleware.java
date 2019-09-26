/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Tiago
 */
public class Middleware {
    
    public Middleware(){
        //escutar();
        getMedia();
        //getsoma();
    }
    
    public void escutar(){
        
    }
    
    public void getMedia(){
        //PC Daniel
        try {
            String URL_MEDIA = "http://192.168.43.47:8080/PC01/webresources/generic/get/media/00000;1;2;3";
            URL obj = new URL(URL_MEDIA);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println("Erro de requisição");
        }
        // 10.0.0.104
        
    }
    
    
    public void getsoma(){
        //PC Thiago
        try {
            String URL_SOMA = "http://192.168.43.214:8080/PC02/webresources/generic/get/soma/00000;1;2;3";
            URL obj = new URL(URL_SOMA);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println("Erro de requisição");
        }
        // 10.0.0.104
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Middleware();
    }
    
}
