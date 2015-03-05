package pt.projecttransporter;

import java.util.Date;

/**
 * Created by JuLIANG on 4/03/15.
 */
public class uq9db {

    public enum Gender {
        Male, Female
    }

    private static int id;
    private String firstname;
    private String lastname;
    private Gender gender;
    private String address;
    private Number Tel;
    private Date DoB;
    private String email;
    private String fblink;
    private String nationality;
    private String work_stat;

    public uq9db() {

    }
//not used for now
//    public UQ9database(int id, String firstname, String lastname, Gender gender, String address, Number Tel, Date DoB, String email, String fblink, String nationality, String workstat ) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.gender = gender;
//        this.address = address;
//        this.Tel = Tel;
//        this.DoB = DoB;
//        this.email = email;
//        this.fblink = fblink;
//        this.nationality = nationality;
//        this.work_stat = workstat;
//    }//

    public uq9db(String firstname, String lastname, Gender gender, String address, Number Tel, Date DoB, String email, String fblink, String nationality, String workstat) {
        this.id = id++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.Tel = Tel;
        this.DoB = DoB;
        this.email = email;
        this.fblink = fblink;
        this.nationality = nationality;
        this.work_stat = workstat;
    }

    public int getID() {
        return this.id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public Gender getGender() {
        return this.gender;
    }

    public String getAddress() {
        return this.address;
    }

    public Number getTel() {
        return this.Tel;
    }

    public Date getDoB() {
        return this.DoB;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFblink() {
        return this.fblink;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getWork_stat() {
        return this.work_stat;
    }
}



