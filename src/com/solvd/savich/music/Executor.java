package com.solvd.savich.music;

import com.solvd.savich.music.menu.Menu;
import com.solvd.savich.music.exceptions.MyExceptions;


public class Executor {

    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.showMenu();
        } catch (MyExceptions myExceptions) {
            myExceptions.printStackTrace();
        }

    }

}




