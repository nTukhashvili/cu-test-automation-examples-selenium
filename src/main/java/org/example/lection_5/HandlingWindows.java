package org.example.lection_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        //ტაბების და window-ების შემთხვევაში hanling ძალაინ გავს ერთმანეთს და იდენტური პროცესია
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(By.id("windowButton")).click();
        String newWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(newWindowHandle);
        driver.get("https:www.google.com");

    }
}
