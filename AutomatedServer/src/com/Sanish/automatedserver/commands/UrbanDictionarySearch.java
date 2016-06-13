/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.commands;
//Remember to flush when uing PrintWriter explore more on concept of flush

import com.Sanish.automatedserver.entity.Client;
import com.Sanish.automatedserver.handlers.RequestHandler;
import com.Sanish.automatedserver.scrapper.UrbanDictionaryScrapper;
import com.Sanish.automatedserver.util.URLHelper;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author gandoff
 */
public class UrbanDictionarySearch extends Commands {

    public UrbanDictionarySearch(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] command, Client me) throws IOException {
       if(command.length==2){
           PrintWriter pw = new PrintWriter(me.getSocket().getOutputStream());
           pw.println("Commencing search...");
           String content = URLHelper.get(command[1]);
           String meaning = UrbanDictionaryScrapper.scrap(content);
           pw.println(meaning);
           pw.flush();
       }
    }
    
}
