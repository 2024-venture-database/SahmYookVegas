package com.SYVegas.common;

public class CurrentUser {
    private String currentUserId;
    private int chip100=0;
    private int chip50=0;
    private int chip10=0;
    private int chip5=0;
    private int chip1=0;
    private String gameResult="win";

    public CurrentUser() {
    }

    public CurrentUser(String currentUserId, int chip100, int chip50, int chip10, int chip5, int chip1) {
        this.currentUserId = currentUserId;
        this.chip100 = chip100;
        this.chip50 = chip50;
        this.chip10 = chip10;
        this.chip5 = chip5;
        this.chip1 = chip1;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }

    public int getChip100() {
        return chip100;
    }

    public void setChip100(int chip100) {
        this.chip100 = chip100;
    }

    public int getChip50() {
        return chip50;
    }

    public void setChip50(int chip50) {
        this.chip50 = chip50;
    }

    public int getChip10() {
        return chip10;
    }

    public void setChip10(int chip10) {
        this.chip10 = chip10;
    }

    public int getChip5() {
        return chip5;
    }

    public void setChip5(int chip5) {
        this.chip5 = chip5;
    }

    public int getChip1() {
        return chip1;
    }

    public void setChip1(int chip1) {
        this.chip1 = chip1;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    @Override
    public String toString() {
        return
                "==========================================================================================\n"+
                "현재 " + currentUserId + "님의 칩 보유수는" +
                "   [칩100] :" + chip100 +
                "   [칩50] :" + chip50 +
                "   [칩10] :" + chip10 +
                "   [칩5] :" + chip5 +
                "   [칩] :" + chip1 +
                "   입니다." +
                "\n==========================================================================================";

    }
}
