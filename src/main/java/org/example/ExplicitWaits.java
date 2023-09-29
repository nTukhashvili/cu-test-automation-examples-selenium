package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class ExplicitWaits {
    public static void main(String[] args) {


        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //დევთულსის ბრძანებით ვზღუდავთ ჩამოტვირვთი სიჩქარეს 1000 კილობითს დაახლოებით 0.125 მეგაბაიტი წამში
        devTools.send(Network.emulateNetworkConditions(false, 1000, 2000, 5000, Optional.of(ConnectionType.CELLULAR3G)));
        driver.get("https://www.extra.ge");

        //driver.findElement(By.xpath("/html/body/app-root/app-pages-wraper/app-notification-popup-main/app-notification-popup/div/div/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-pages-wraper/app-notification-popup-main/app-notification-popup/div/div/button"))).click();
        driver.get("https://www.extra.ge");
    }
}
