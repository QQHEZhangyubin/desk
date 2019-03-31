package qiqihaer.desk.www.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Soft2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsoft;

    private Integer versioncode;

    private String versionname;

    private String versiondescription;

    private String versionurl;

    public Integer getIdsoft() {
        return idsoft;
    }

    public void setIdsoft(Integer idsoft) {
        this.idsoft = idsoft;
    }

    public Integer getVersioncode() {
        return versioncode;
    }

    public void setVersioncode(Integer versioncode) {
        this.versioncode = versioncode;
    }

    public String getVersionname() {
        return versionname;
    }

    public void setVersionname(String versionname) {
        this.versionname = versionname == null ? null : versionname.trim();
    }

    public String getVersiondescription() {
        return versiondescription;
    }

    public void setVersiondescription(String versiondescription) {
        this.versiondescription = versiondescription == null ? null : versiondescription.trim();
    }

    public String getVersionurl() {
        return versionurl;
    }

    public void setVersionurl(String versionurl) {
        this.versionurl = versionurl == null ? null : versionurl.trim();
    }
}