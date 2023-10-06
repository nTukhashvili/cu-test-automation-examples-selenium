package lection_5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class KeyBoardEvents {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        //Sendkeys-ს მეთოდში შეგვიძლია გადავცდეთ Keys.Shift და uppercase-ში ჩავწეროთ პირდაპირ ტექსტი
        driver.findElement(By.id("userName")).sendKeys(Keys.SHIFT,"NIKA");
        Thread.sleep(2000);
        driver.findElement(By.id("userEmail")).sendKeys("nika@gmail.com");


        //Copy Paste-ის სიმულაცია
        //ჯერ ვპულობთ ვებ ელემებტს source და target ველებისთვის
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        //Source ველში უბრალოდ sendkeys() მეთოდით შეგვყავს ტექსტი
        currentAddress.sendKeys("Paata Saakadze #1");

        //Action კლასის გამოყენებით ვაჭერთ კონტროლს შემდეგ A და C-ს უშვებთ control keyup მეთოდით
        act.moveToElement(currentAddress)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        Thread.sleep(2000);

        //Action კლასით ვაწერთ კონტროლს შემდეგ V ღილაკს და შემდეგ
        act.moveToElement(permanentAddress)
                .click()
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();



        for (int i = 0; i < 4; i++) {
            Thread.sleep(2000);
            driver.findElement(By.tagName("html")).sendKeys(Keys.SHIFT, Keys.TAB);
        }

        Thread.sleep(2000);
        driver.findElement(By.id("userName")).sendKeys(Keys.BACK_SPACE);


    }
}
