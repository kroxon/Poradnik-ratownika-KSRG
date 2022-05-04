package com.mynew.poradnikksrg;

public class KPPData {
    String kppName;
    String kppNumber;
    int kppImage;

    public KPPData(String kppName, String kppNumber) {
        this.kppName = kppName;
        this.kppNumber = kppNumber;
        this.kppImage = 0;
    }

    public KPPData(String kppName, String kppNumber, int kppImage) {
        this.kppName = kppName;
        this.kppNumber = kppNumber;
        this.kppImage = kppImage;
    }

    public String getKppName() {
        return kppName;
    }

    public String getKppNumber() {
        return kppNumber;
    }

    public int getKppImage() {
        return kppImage;
    }

    public void setKppName(String kppName) {
        this.kppName = kppName;
    }

    public void setKppNumber(String kppNumber) {
        this.kppNumber = kppNumber;
    }

    public void setKppImage(int kppImage) {
        this.kppImage = kppImage;
    }
}
