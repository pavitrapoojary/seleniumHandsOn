package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumIntroduction {
    public static void main(String[] args){
//        System.setProperty("webdriver.edge.driver","C:/HANDS ON/SELENIUM PRACTICE/seleniumHandsOn/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println("Title: "+driver.getTitle());
        System.out.println("Current URL : "+driver.getCurrentUrl());
        driver.close();
//        driver.quit();


    }
}
