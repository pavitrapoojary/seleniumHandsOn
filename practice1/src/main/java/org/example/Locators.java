package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        System.out.println("Title: "+driver.getTitle());
        System.out.println("Current URL : "+driver.getCurrentUrl());

        driver.findElement(By.id("inputUsername")).sendKeys("pavitra");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademyxxx");
        driver.findElement(By.className("signInBtn")).click();
        //implicit wait
        System.out.println("Error text : "+driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("pavitra");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("p@gmail.com");
//        driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9999999999");


        driver.close();
    }
}
