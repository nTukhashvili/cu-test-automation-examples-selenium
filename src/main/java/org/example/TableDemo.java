package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TableDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.id("addNewRecordButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        driver.findElement(By.id("firstName")).sendKeys("Nika");
        driver.findElement(By.id("lastName")).sendKeys("Tukhshvili");
        driver.findElement(By.id("userEmail")).sendKeys("nika@gmail.com");

        WebElement el =  driver.findElement(By.id("salary"));
        el.sendKeys("uff bevri");

        driver.findElement(By.id("department")).sendKeys("westerosis");
        driver.findElement(By.id("submit")).click();
        String script = "return window.getComputedStyle(arguments[0]).getPropertyValue('background-image');";
        String bgColor = (String) js.executeScript(script, el);
        Thread.sleep(1000);
        System.out.println(bgColor);


    }
}
