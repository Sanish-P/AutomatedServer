/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.commands;

import com.Sanish.automatedserver.entity.Client;
import com.Sanish.automatedserver.entity.Job;
import com.Sanish.automatedserver.handlers.RequestHandler;
import com.Sanish.automatedserver.scrapper.JobScrapper;
import com.Sanish.automatedserver.util.URLHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author gandoff
 */
public class JobsNepalSearch extends Commands {

    public JobsNepalSearch(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void execute(String[] command, Client me) throws IOException {
        if (command.length == 2) {
            PrintWriter pw = new PrintWriter(me.getSocket().getOutputStream());
            pw.println("Commencing search...");
            String content = URLHelper.post(command[1]);
            List<Job> jobList = JobScrapper.scrap(content);
            for (Job job : jobList) {
               pw.println(job.toString());
            }
            pw.flush();
        }
    }

}
