package com.group6.placementportal.DatabasePackage;

import com.group6.placementportal.DatabasePackage.job;
import java.io.Serializable;
import java.util.ArrayList;

public class company implements Serializable {
    private String company_name;
    private String compnany_id;
    private String sector;
    private String contact_no;
    private String email_address;
    private String headoffice;
    private ArrayList<job> jobs;
/*    public company() {
    }*/

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompnany_id() {
        return compnany_id;
    }

    public void setCompnany_id(String compnany_id) {
        this.compnany_id = compnany_id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getHeadoffice() {
        return headoffice;
    }

    public void setHeadoffice(String headoffice) {
        this.headoffice = headoffice;
    }

    public ArrayList<job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<job> jobs) {
        this.jobs = jobs;
    }

    public company(String company_name, String compnany_id, String sector, String contact_no, String email_address, String headoffice, ArrayList<job> jobs) {
        this.company_name = company_name;
        this.compnany_id = compnany_id;
        this.sector = sector;
        this.contact_no = contact_no;
        this.email_address = email_address;
        this.headoffice = headoffice;
        this.jobs = jobs;
    }
}
