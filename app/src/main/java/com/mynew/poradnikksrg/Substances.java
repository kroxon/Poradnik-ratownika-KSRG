package com.mynew.poradnikksrg;


public class Substances {
    int Id;
    String onzNumber;
    String procNum;
    String substName;

    public Substances(int id, String onzNumber, String procNum, String substName) {
        Id = id;
        this.onzNumber = onzNumber;
        this.procNum = procNum;
        this.substName = substName;
    }

    public Substances(int Id) {
        this.Id = Id;
        this.onzNumber = "0";
        this.procNum = "0";
        this.substName = "0";
    }

    public Substances() {
        this.Id = 0;
        this.onzNumber = "0";
        this.procNum = "0";
        this.substName = "0";
    }

    @Override
    public String toString() {
        return "onzNumber= " + onzNumber +
                " procNum= " + procNum +
                " substName= " + substName + "\n";
    }

    public void setId(int id) {
        Id = id;
    }

    public void setOnzNumber(String onzNumber) {
        this.onzNumber = onzNumber;
    }

    public void setProcNum(String procNum) {
        this.procNum = procNum;
    }

    public void setSubstName(String substName) {
        this.substName = substName;
    }

    public int getId() {
        return Id;
    }

    public String getOnzNumber() {
        return onzNumber;
    }

    public String getProcNum() {
        return procNum;
    }

    public String getSubstName() {
        return substName;
    }
}

