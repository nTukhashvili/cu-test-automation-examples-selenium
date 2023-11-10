package org.example.lecture_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().dismiss();

        //ისეთი ალერტებისთვის რომლის გამოჩენასაც დრო ჭირდება შეგვიძლია გამოვიყენოთ webdriverwait კლასი
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("timerAlertButton")))).click();
        wait.until(ExpectedConditions.alertIsPresent()).getText();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        //accept-ით ვეთანხმებით ალერტს
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();


        //dismiss-ით არ ვეთნახმებით
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();

        //ვწერთ ტექსტს alert-ის prompt-ში
        Thread.sleep(2000);
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Some Text");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.quit();
    }
}
