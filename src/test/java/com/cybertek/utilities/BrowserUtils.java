package com.cybertek.utilities;

public class BrowserUtils {
    //create method name: wait
    //converting mili second tp seconds
    // handle checked exception

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("Something happened in sleep method");
            //e.printStackTrace();
        }
    }

}
