package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//მაგალითი ფორმის შევსების

public class FormFill {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://qavalidation.com/demo-form/");

        driver.findElement(By.id("g4072-fullname")).sendKeys("Username");
        driver.findElement(By.id("g4072-email")).sendKeys("Password");
        driver.findElement(By.id("g4072-phonenumber")).sendKeys("57716651");

        //ვხსნით dropdown menu-ს
        driver.findElement(By.id("g4072-gender-button")).click();
        WebElement dropdownMenu = driver.findElement(By.xpath("//ul[@id='g4072-gender-menu']"));

        //dropdown menu-ის ელემენტებს ვინახავთ ლისტში ვიყენებთ findElements რადგან ვიცით რომ რამდენიმე option-ი გვაქ
        List<WebElement> dropDownOptions = dropdownMenu.findElements(By.className("ui-menu-item"));

        //ვაკლიკებთ პირველივე options dropdownmenu-ში
        dropDownOptions.get(0).click();

        //ვეძებთ radiobutton-ების მშობელელ ელემენტს შემდეგ კი მის შვილ ელემენტებს
        List<WebElement> radioButtons = driver
        .findElement(By.className("grunion-radio-options"))
        .findElements(By.name("g4072-yearsofexperience"));

        //ვაკლიკებთ ყველა radio ბათონს სათითაოდ მიმდევრობით
        for (WebElement el:radioButtons
             ) {
                Thread.sleep(1000);
                el.click();
        }

        //xpath ლოკატორით ვაკლიკებთ მეორე ელემენტს
        driver.findElement(By.xpath("//div[@class='grunion-checkbox-multiple-options']//label[1]")).click();

        //id ლოკატორით ვეძებთ text fields და ვწერთ ტექსტს
        driver.findElement(By.id("contact-form-comment-g4072-otherdetails")).sendKeys("SOME TEXT");

        //className ლოკატორით ვეძებთ submit ღილაკს და ვაკლიკეთ
        driver.findElement(By.className("wp-block-button__link")).click();

        driver.quit();

    }
}
