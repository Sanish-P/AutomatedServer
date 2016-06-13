/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.commands;

import com.Sanish.automatedserver.handlers.RequestHandler;

/**
 *
 * @author gandoff
 */
public class CommandFactory {
    public static Commands getInstance(String[] command,RequestHandler handler){
     if(command[0].equalsIgnoreCase("pm")){
         return new PrivateMessageCommand(handler);
     }
     else if(command[0].equalsIgnoreCase("UD")){
         return new UrbanDictionarySearch(handler);
     } 
    return null;
    }
    
}
