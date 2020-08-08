package sample;

public class FacultyDetailsTable {
    String facultyid,facultyname,age,gender,dob,dept,address,contact,pwd;

    public FacultyDetailsTable(String facultyid, String facultyname, String age, String gender, String dob, String dept, String address, String contact, String pwd) {
        this.facultyid = facultyid;
        this.facultyname = facultyname;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.dept = dept;
        this.address = address;
        this.contact = contact;
        this.pwd = pwd;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
