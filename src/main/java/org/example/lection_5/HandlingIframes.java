package org.example.lection_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingIframes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.tagName("body")).getText());

        Thread.sleep(2000);
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
}
