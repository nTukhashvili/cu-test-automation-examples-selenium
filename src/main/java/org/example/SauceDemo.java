package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;


import java.time.Duration;
import java.util.List;

public class SauceDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.xpath());
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@class='inventory_item']//button"));

        for (WebElement el: addToCartButtons
             ) {
            Thread.sleep(1000);
            el.click();

        }


    }
}
