/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author gandoff
 */
public class URLHelper {
    public static String get(String param) throws IOException {
        String link ="http://www.urbandictionary.com/define.php?";
        URL url = new URL(link + "term=" + param);

        URLConnection connect = url.openConnection();
        connect.setDoOutput(true);
        
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));

        StringBuilder content = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
        bufferedReader.close();
        return content.toString();
    }
        public static String post(String param) throws IOException {
        String link ="http://www.jobsnepal.com/simple-job-search";
        URL url = new URL(link);

        URLConnection connect = url.openConnection();
        connect.setDoOutput(true);
        if(!(param.equalsIgnoreCase(""))){
        OutputStream os = connect.getOutputStream();
        byte[] data = ("keywords="+param).getBytes();

        os.write(data);
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));

        StringBuilder content = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
        bufferedReader.close();

        return content.toString();

    }
}
