package org.example.lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

@SuppressWarnings("DuplicatedCode")
public class FluentWaits {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5));

        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Fast.com']"))).click();

    }
}
