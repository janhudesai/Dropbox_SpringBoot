
package com.entity;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import java.util.Date;

@Entity
public class Useractivites {

    @Id
    private String userid;

    private String activity;
    private String filename;

    public Useractivites(String userid, String activity, String filename, Date date) {
        this.userid = userid;
        this.activity = activity;
        this.filename = filename;
        this.date = date;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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

    public Useractivites() {
    }

    private Date date;
}
