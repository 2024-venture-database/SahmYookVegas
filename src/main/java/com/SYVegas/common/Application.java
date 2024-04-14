package com.SYVegas.common;

import com.SYVegas.check_customerInfoAndLog.Prototype;
import com.SYVegas.playgame.PlayGame;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
//        Prototype prototype=new Prototype();
//        prototype.managerPrototypeStart();
        CurrentUser currentUser=new CurrentUser("김상억",50,50,50,50,50);
        PlayGame playGame=new PlayGame();
        playGame.betting(currentUser);
        playGame.gameResult(currentUser);
    }
}