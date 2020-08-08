package sample;

import javafx.scene.control.Button;

import java.time.LocalDate;

public class ApplyLeavetable {
    String fid, fname, dept, leavetype, reason, status, startdate, enddate;

    public ApplyLeavetable(String fid, String fname, String dept, String leavetype, String startdate, String enddate, String reason, String status) {
        this.fid = fid;
        this.fname = fname;
        this.dept = dept;
        this.leavetype = leavetype;
        this.enddate = enddate;
        this.startdate = startdate;
        this.reason = reason;
        this.status = status;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }


}
