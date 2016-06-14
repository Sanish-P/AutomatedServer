/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.handlers;

import com.Sanish.automatedserver.commands.CommandFactory;
import com.Sanish.automatedserver.commands.Commands;
import com.Sanish.automatedserver.entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author gandoff
 */
public class RequestHandler {

    List<Client> clients = new Vector<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getByUserName(String userName) {
        for (Client client : clients) {
            if (client.getUserName().equals(userName)) {
                return client;
            }

        }
        return null;
    }

    public Client getBySocket(Socket clientSocket) {
        for (Client client : clients) {
            if (client.getSocket().equals(clientSocket)) {
                return client;
            }

        }
        return null;
    }

    public void broadcastMessage(Client c, String message) throws IOException {
        for (Client client : clients) {
            if (c != client) {
                PrintWriter printWriter = new PrintWriter(client.getSocket().getOutputStream());
                printWriter.write(message);
                printWriter.flush();
            }
        }
    }

    public void executeRequest(String[] command, Client me) throws IOException {
        Commands c = CommandFactory.getInstance(command,this);
        System.out.println("Command is executing");
        PrintWriter ps = new PrintWriter(me.getSocket().getOutputStream());
        ps.flush();
        if (c != null) {
            c.execute(command, me);
        }
    }

}
