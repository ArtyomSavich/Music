package com.solvd.savich.music;

import com.solvd.savich.music.menu.Menu;
import com.solvd.savich.music.exceptions.MyExceptions;
import com.solvd.savich.music.properties.Util;


public class Executor {

    public static void main(String[] args) {
        /*Menu menu = new Menu();
        try {
            menu.showMenu();
        } catch (MyExceptions myExceptions) {
            myExceptions.printStackTrace();
        }*/
        String test = Util.getPropertiesValue("test");
        String test1 = Util.getPropertiesValue("GGF");
        System.out.println(test);
        System.out.println(test1);
        Util.setPropertiesValueWithResources("t8909435rgggg434443455", "HHHHHH");
        Util.printAll();


    }

}




