package org.example.lecture_6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoJavascriptExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        driver.get("C:\\Users\\white\\Desktop\\cu-quiz\\quiz-index.html");

        //სელენიუმ VS javascripexecutor-ის ეკვივალენტი ბრძანებები
        //სტანდარტული selenium-ის კოდი
        WebElement el = driver.findElement(By.xpath("//*[@id='customForm']/div[1]/a[1]"));
        WebElement el2 = driver.findElement(By.xpath("//*[@id='customForm']/div[1]/a[2]"));
        el.click();

        //Javascript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", el2);

        //Entering Text
        // Selenium example
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("Sent from selenium command");

        //Entering Text
        //Javascript variant
        Thread.sleep(3000);
        js.executeScript("arguments[0].value = 'Hello from the javascript executor'", emailField);


        //Scroll to/move to element
        //Selenium method
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id='customForm']/button"));
        act.moveToElement(submitBtn);


        //Scroll to/move to element
        //Javascript executor
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        //Getting attribute from element
        //Using Selenium method
        System.out.println("Getting Attribute value from Selenium method" + emailField.getAttribute("id"));
        //Getting attribute from element
        //Using javascript executor

        String value = (String) js.executeScript("return arguments[0].getAttribute('id');", emailField);
        System.out.println("Value from JS executor" + value);

        //Changing Attribs using javascript executor
        js.executeScript("arguments[0].setAttribute('style', 'background-color: yellow;');", emailField);






    }
}
