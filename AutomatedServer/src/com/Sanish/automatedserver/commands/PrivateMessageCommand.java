/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.commands;

import com.Sanish.automatedserver.entity.Client;
import com.Sanish.automatedserver.handlers.RequestHandler;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author gandoff
 */
public class PrivateMessageCommand extends Commands {

    public PrivateMessageCommand(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] command, Client me) throws IOException {
        if (command.length == 3) {
            Client receiver = handler.getByUserName(command[1]);
            PrintWriter printWriter = new PrintWriter(receiver.getSocket().getOutputStream());
            printWriter.write(me.getUserName() + " sent private message : " + command[2]+"\n");
            printWriter.flush();
        }

    }
}
