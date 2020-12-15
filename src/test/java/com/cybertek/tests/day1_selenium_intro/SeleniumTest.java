package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        //1-set up the web driver manager
        WebDriverManager.chromedriver().setup();
        //System.setProperty ("chrome", "path of driver")



        //2-Create instance of webdriver

        WebDriver driver = new ChromeDriver();

        //3-and use the instance to get the URL we want
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        System.out.println("Current title: "+ driver.getTitle());

        System.out.println("Current title: "+ driver.getCurrentUrl());

        driver.close();


        //we are using navigate.back method from SELENIUM LIBRARY
        Thread.sleep(3000); // freeses the code

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh();

        driver.navigate().to("https://www.tesla.com");

        System.out.println("Current title: "+ driver.getTitle());

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current title: "+ currentUrl);
        System.out.println("Current title: "+ driver.getPageSource());

        driver.quit();





    }
}
