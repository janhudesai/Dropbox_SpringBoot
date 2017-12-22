
package com.entity;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class

public class Users {

    @Id
    private String userid;

    private String password;
    private String fname;
    private String lname;
    private String work;



    private String education;
    private String contact;
    private String Music;
    private String shows;
    private String sports;

    public Users() {
    }

    public Users(String userid, String password, String fname, String lname, String work, String education, String contact, String music, String shows, String sports) {
        this.userid = userid;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.work = work;
        this.education = education;
        this.contact = contact;
        Music = music;
        this.shows = shows;
        this.sports = sports;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMusic() {
        return Music;
    }

    public void setMusic(String music) {
        Music = music;
    }

    public String getShows() {
        return shows;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }
}
