package com.eijunn.tesbutawarna.model;

public class Tes {
    String jawaban ;
    int gamber ;
    boolean betul ;

    public Tes(String jawaban, int gamber) {
        this.jawaban = jawaban;
        this.gamber = gamber;

    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public int getGamber() {
        return gamber;
    }

    public void setGamber(int gamber) {
        this.gamber = gamber;
    }

    public boolean isBetul() {
        return betul;
    }

    public void setBetul(boolean betul) {
        this.betul = betul;
    }
}
