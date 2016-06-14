/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.scrapper;

import com.Sanish.automatedserver.entity.Job;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author gandoff
 */
public class JobScrapper {

    public static List<Job> scrap(String content) {
        Document doc = Jsoup.parse(content);
        List<Job> jobList = new ArrayList<>();
        for (Element table : doc.select("table[class=gridx]")) {
            for (Element row : table.select("tr")) {
                Job job = new Job();
                StringBuilder sb = new StringBuilder();
                for (Element data : row.select("td")) {
                    sb.append(data.text());
                    sb.append(",");
                }
                StringTokenizer st = new StringTokenizer(sb.toString(), ",");
                if (st.countTokens() != 0) {
                    job.setJobTitle(st.nextToken());
                    job.setCompany(st.nextToken());
                    job.setType(st.nextToken());
                    job.setDeadline(st.nextToken());
                }
                if (job.getJobTitle() != null) {
                    jobList.add(job);
                }
            }
        }
        return jobList;

    }

}
