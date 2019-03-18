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
}