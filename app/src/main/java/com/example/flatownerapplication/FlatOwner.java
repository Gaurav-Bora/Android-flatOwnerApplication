package com.example.flatownerapplication;

import java.io.Serializable;

public class FlatOwner implements Serializable {


    private String flatno;
    private  String name;
    private String flatholdertype;
    private String carpet;

    public FlatOwner() {

    }

    public FlatOwner(String flatno, String name, String flatholdertype, String carpet) {
        this.flatno = flatno;
        this.name = name;
        this.flatholdertype = flatholdertype;
        this.carpet = carpet;
    }

    public String getFlatno() {
        return flatno;
    }

    public void setFlatno(String flatno) {
        this.flatno = flatno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlatholdertype() {
        return flatholdertype;
    }

    public void setFlatholdertype(String flatholdertype) {
        this.flatholdertype = flatholdertype;
    }

    public String getCarpet() {
        return carpet;
    }

    public void setCarpet(String carpet) {
        this.carpet = carpet;
    }

    @Override
    public String toString() {
        return "FlatOwner{" +
                "flatno='" + flatno + '\'' +
                ", name='" + name + '\'' +
                ", flatholdertype='" + flatholdertype + '\'' +
                ", carpet='" + carpet + '\'' +
                '}';
    }
}
