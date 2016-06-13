/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver;

import com.Sanish.automatedserver.handlers.ClientListener;
import com.Sanish.automatedserver.handlers.RequestHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gandoff
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 9000;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server running at port "+port);
            RequestHandler handler = new RequestHandler();
            while(true){
                Socket client = server.accept();
                System.out.println("Connected Client "+client.getInetAddress().getHostAddress());
                ClientListener clientListener = new ClientListener(client,handler);
                clientListener.start();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}
