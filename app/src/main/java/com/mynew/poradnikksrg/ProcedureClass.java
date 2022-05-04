package com.mynew.poradnikksrg;


public class ProcedureClass {
    int Id;
    String pNumber;
    String pDescription;
    String pForE;
    String pEffect;
    String pRelease;
    String pClothing;
    String pEvacuation;
    String pFire;
    String pEorL;
    String pFirstAid;

    public ProcedureClass() {

        this.pNumber = "000";
        this.pDescription = "0";
        this.pForE = "0";
        this.pEffect = "0";
        this.pRelease = "0";
        this.pClothing = "0";
        this.pEvacuation = "0";
        this.pFire = "0";
        this.pEorL = "0";
        this.pFirstAid = "0";
    }

    public ProcedureClass(int Id, String pNumber, String pDescription, String pForE, String pEffect, String pRelease, String pClothing, String pEvacuation, String pFire, String pEorL, String pFirstAid) {
        this.Id = Id;
        this.pNumber = pNumber;
        this.pDescription = pDescription;
        this.pForE = pForE;
        this.pEffect = pEffect;
        this.pRelease = pRelease;
        this.pClothing = pClothing;
        this.pEvacuation = pEvacuation;
        this.pFire = pFire;
        this.pEorL = pEorL;
        this.pFirstAid = pFirstAid;
    }

    @Override
    public String toString() {
        return  "pNumber= " + pNumber +"\n" ;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public void setpForE(String pForE) {
        this.pForE = pForE;
    }

    public void setpEffect(String pEffect) {
        this.pEffect = pEffect;
    }

    public void setpRelease(String pRelease) {
        this.pRelease = pRelease;
    }

    public void setpClothing(String pClothing) {
        this.pClothing = pClothing;
    }

    public void setpEvacuation(String pEvacuation) {
        this.pEvacuation = pEvacuation;
    }

    public void setpFire(String pFire) {
        this.pFire = pFire;
    }

    public void setpEorL(String pEorL) {
        this.pEorL = pEorL;
    }

    public void setpFirstAid(String pFirstAid) {
        this.pFirstAid = pFirstAid;
    }

    public int getId() {
        return Id;
    }

    public String getpNumber() {
        return pNumber;
    }

    public String getpDescription() {
        return pDescription;
    }

    public String getpForE() {
        return pForE;
    }

    public String getpEffect() {
        return pEffect;
    }

    public String getpRelease() {
        return pRelease;
    }

    public String getpClothing() {
        return pClothing;
    }

    public String getpEvacuation() {
        return pEvacuation;
    }

    public String getpFire() {
        return pFire;
    }

    public String getpEorL() {
        return pEorL;
    }

    public String getpFirstAid() {
        return pFirstAid;
    }
}
