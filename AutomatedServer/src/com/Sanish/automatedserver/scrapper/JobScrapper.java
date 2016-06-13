/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.scrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gandoff
 */
public class JobScrapper {

    public static String scrap(String content) {
        String searchReEx = "<a href='(.*?)'(.*?)<h4(.*?)>(.*?)<";

        Pattern pattern = Pattern.compile(searchReEx);
        Matcher matcher = pattern.matcher(content);

        StringBuilder sbFile = new StringBuilder();
        while (matcher.find()) {
            String jobTitle = matcher.group(4);
            String jobLink = matcher.group(1);
            sbFile.append(jobTitle.trim() + "," + jobLink.trim() + "," + "\r\n");
        }
        return sbFile.toString();

    }

}
