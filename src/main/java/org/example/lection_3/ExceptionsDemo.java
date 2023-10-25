package org.example.lection_3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExceptionsDemo {
    public static void main(String[] args) throws InterruptedException {
        //NoSucheElementExcetopn - 1 როცა ელემენტი Dom-ში არ იძებნებაა
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");


        try {
            driver.findElement(By.id("john Cena"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        Thread.sleep(1000);

//      ElementNotInteractableException - როცა სამიზნე ელემენტს ფარავს სხვა webelement-ი
        try {
            driver.get("https://demoqa.com/automation-practice-form");
        } catch (ElementNotInteractableException e) {
            driver.findElement(By.xpath("//*[@id='gender-radio-1']")).click();
            System.out.println(e.getMessage());
        }

        //StaleElementException
        Thread.sleep(2000);
        driver.get("https://www.worldometers.info/");
        WebElement firstPart = driver.findElement(By.xpath(" //span[@rel='current_population']//span[contains(@class,'rts-nr-int rts-nr-')][1]"));
        Thread.sleep(2000);
        try {
            firstPart.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }


//        NoSuchWindowException
        String tab1 = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        String tab2 = driver.getWindowHandle();
        driver.close();
        driver.switchTo().window(tab2);

        //NoSuchSessionException
        driver.quit();
        driver.get("https://www.google.com");


    }
}
