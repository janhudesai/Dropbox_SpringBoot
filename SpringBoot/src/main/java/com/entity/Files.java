package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Files {
    @Id
    private String fileid;

    private String filename;
    private Date date;
    private String userid;
    private String parentfolder;

    public Files(String fileid, String filename, Date date, String userid, String parentfolder, String starred, String display) {
        this.fileid = fileid;
        this.filename = filename;
        this.date = date;
        this.userid = userid;
        this.parentfolder = parentfolder;
        this.starred = starred;
        this.display = display;
    }

    public Files() {

    }

    private String starred;
    private String display;

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
