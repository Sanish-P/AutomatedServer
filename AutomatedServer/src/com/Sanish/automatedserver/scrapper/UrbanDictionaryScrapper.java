/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.scrapper;

import com.Sanish.automatedserver.filter.MeaningFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gandoff
 */
public class UrbanDictionaryScrapper {
    
    public static String scrap(String content) {
        System.out.println("Commencing Srap");
        String searchReEx = "<div class='meaning'>(.*?)</div>";

        Pattern pattern = Pattern.compile(searchReEx);
        Matcher matcher = pattern.matcher(content);

        StringBuilder sb = new StringBuilder();
        matcher.find();
        String result = matcher.group(1);
        result = MeaningFilter.filter(result);
        System.out.println(result);
        return result;

    }
    
}
