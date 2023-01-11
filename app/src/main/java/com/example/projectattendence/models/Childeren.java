package com.example.projectattendence.models;

public class Childeren {


    private String Childname;
    private String Regno;

    public Childeren(String childname, String regno) {
        Childname = childname;
        Regno = regno;
    }

    public String getChildname() {
        return Childname;
    }

    public void setChildname(String childname) {
        Childname = childname;
    }

    public String getRegno() {
        return Regno;
    }

    public void setRegno(String regno) {
        Regno = regno;
    }
}
