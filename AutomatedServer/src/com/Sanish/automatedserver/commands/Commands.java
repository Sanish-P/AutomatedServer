/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.commands;

import com.Sanish.automatedserver.entity.Client;
import com.Sanish.automatedserver.handlers.RequestHandler;
import java.io.IOException;

/**
 *
 * @author gandoff
 */
public abstract class Commands {
    protected RequestHandler handler;

    public Commands(RequestHandler handler) {
        this.handler = handler;
    }
    
    
    public abstract void execute(String[] command,Client me) throws IOException;
}
