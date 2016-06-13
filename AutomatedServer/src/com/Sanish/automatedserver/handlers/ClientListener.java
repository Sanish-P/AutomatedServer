/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.handlers;

import com.Sanish.automatedserver.DAO.Impl.UserDAOImpl;
import com.Sanish.automatedserver.DAO.UserDAO;
import com.Sanish.automatedserver.entity.Client;
import com.Sanish.automatedserver.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author gandoff
 */
public class ClientListener extends Thread {

    private Socket client;
    private PrintStream ps;
    private BufferedReader br;
    private UserDAO uDAO = new UserDAOImpl();
    private RequestHandler handler;

    public ClientListener(Socket client, RequestHandler handler) throws IOException {
        this.client = client;
        this.handler = handler;
        this.ps = new PrintStream(client.getOutputStream());
        this.br = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    @Override
    public void run() {
        try {
            ps.println("Welcome to the Jungle Server");
            while (!doLogin()) {
                ps.println("Invalid User");
            }
            ps.println("Successful Login");
            doChat();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean doLogin() throws IOException {
        ps.println("UserName :");
        String userName = br.readLine();
        ps.println("Password :");
        String password = br.readLine();
        System.out.println(userName);
        User u = uDAO.getUserByUserName(userName);
        if (u != null) {
            if (u.getPassword().equals(password)) {
                Client me = new Client(client, userName);
                handler.addClient(me);
                return true;
            }
        }
        return false;
    }

    private void doChat() throws IOException {
        while (true) {
            Client me = handler.getBySocket(client);
            ps.print(">");
            ps.flush();
            String line = br.readLine();
            if (line.contains("::")) {
                String[] command = line.split("::");
                handler.executeRequest(command, me);
            } 
            else {
                handler.broadcastMessage(me, me.getUserName() + " says :" + line);
            }
        }

    }

}
