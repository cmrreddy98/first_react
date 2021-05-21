package com.transaction.first;

import java.util.Objects;

public class LoginDetails {

    private String Uname;
    private String Pword;

    public LoginDetails() {
    }

    public LoginDetails(String uname, String pword) {
        Uname = uname;
        Pword = pword;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getPword() {
        return Pword;
    }

    public void setPword(String pword) {
        Pword = pword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginDetails)) return false;
        LoginDetails that = (LoginDetails) o;
        return getUname().equals(that.getUname()) && getPword().equals(that.getPword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUname(), getPword());
    }

    @Override
    public String toString() {
        return "LoginDetails{" +
                "Uname='" + Uname + '\'' +
                ", Pword='" + Pword + '\'' +
                '}';
    }
}
