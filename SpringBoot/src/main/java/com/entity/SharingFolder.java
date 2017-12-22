package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class SharingFolder {
    @Id
    private String folderid;

    private String name;
    private Date date;
    private String userid;
    private String parentfolder;

    private String childfolder;

    private String starred;
    private String display;

    public SharingFolder() {
    }

    public SharingFolder(String folderid, String name, Date date, String userid, String parentfolder, String childfolder, String starred, String display) {
        this.folderid = folderid;
        this.name = name;
        this.date = date;
        this.userid = userid;
        this.parentfolder = parentfolder;
        this.childfolder = childfolder;
        this.starred = starred;
        this.display = display;

    }



    public String getFolderid() {
        return folderid;
    }

    public void setFolderid(String folderid) {
        this.folderid = folderid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentfolder() {
        return parentfolder;
    }

    public void setParentfolder(String parentfolder) {
        this.parentfolder = parentfolder;
    }

    public String getChildfolder() {
        return childfolder;
    }

    public void setChildfolder(String childfolder) {
        this.childfolder = childfolder;
    }

    public String getStarred() {
        return starred;
    }

    public void setStarred(String starred) {
        this.starred = starred;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}