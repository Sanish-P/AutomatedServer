/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.filter;

import org.apache.commons.lang3.StringEscapeUtils;


/**
 *
 * @author gandoff
 */
public class MeaningFilter {
    public static String filter(String content){
        content = StringEscapeUtils.unescapeHtml4(content);
        content = content.replace(";", "");
        content = content.replace("<br/>", "\n");
        content = content.replaceAll("<a href(.*?)>", "");
        content = content.replaceAll("</a>","");
        return content;
                    
    }
    
}
