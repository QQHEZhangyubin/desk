package qiqihaer.desk.www.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class TmpRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tmprecordid;

    private Integer tmpseatid;

    private Date starttime;

    private String status;
    private String username2;

    public Integer getTmprecordid() {
        return tmprecordid;
    }

    public void setTmprecordid(Integer tmprecordid) {
        this.tmprecordid = tmprecordid;
    }

    public Integer getTmpseatid() {
        return tmpseatid;
    }

    public void setTmpseatid(Integer tmpseatid) {
        this.tmpseatid = tmpseatid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2 == null ? null : username2.trim();
    }
}