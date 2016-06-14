/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sanish.automatedserver.entity;

/**
 *
 * @author gandoff
 */
public class Job {
    private String jobTitle,company,type,deadline;

    public Job() {
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Job Title :" + jobTitle +"\r\n"+ 
                "Company :" + company +"\r\n"+
                "Type :" + type + "\r\n"+
                "Deadline :" + deadline+"\r\n";
    }
    
    
    

}