package org.example.lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;

import java.time.Duration;
import java.util.Optional;

public class ImplicitWaits {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver();
        pageLoad(driver);
        //implicitWaitForElement(driver);
        driver.quit();

    }

    static void pageLoad(ChromeDriver driver){
        //სელენიუმის ეს ნაწილი არ შედის სილაბუსში თუმცა დემონსტრაციისთვის საკმაოდ სასარგებლოა
        //ვქმნით devtools-ის სესიას რაც გვაძლევს საშუალებას ვაკონტროლოთ ტრაფიკი
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //დევთულსის ბრძანებით ვზღუდავთ ჩამოტვირვთი სიჩქარეს 1000 კილობითს დაახლოებით 0.125 მეგაბაიტი წამში
        devTools.send(Network.emulateNetworkConditions(false, 1000, 1300, 1300, Optional.of(ConnectionType.CELLULAR3G)));
        //page time-ით ვუთითებთ დროს მაქსიმუმ რამდენ ხანს დაელოდება გვერდის მთლიანად ჩატვირთვას
        //pageLoad(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://www.vendoo.ge");

        driver.findElement(By.xpath("//div[@id='product_card'][1]"));
        driver.quit();
    }

    static void implicitWaitForElement(ChromeDriver driver) throws InterruptedException {
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //დევთულსის ბრძანებით ვზღუდავთ ჩამოტვირვთი სიჩქარეს 1000 კილობითს დაახლოებით 0.125 მეგაბაიტი წამში
        devTools.send(Network.emulateNetworkConditions(false, 1000, 2000, 5000, Optional.of(ConnectionType.CELLULAR3G)));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get("https://www.extra.ge");
        driver.findElement(By.xpath("/html/body/app-root/app-pages-wraper/app-notification-popup-main/app-notification-popup/div/div/button")).click();
        Thread.sleep(1000);
    }


}
