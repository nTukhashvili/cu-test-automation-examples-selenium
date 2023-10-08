package Solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HeadlessExecution {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //ეს პარამატერი აღარ მუშაობს უსაფრთხოების გამო
        options.addArguments("disable-infobars");

        WebDriver driver = new ChromeDriver(options);



        Actions act = new Actions(driver);
        driver.get("C:\\Users\\white\\Desktop\\cu-quiz\\quiz-index.html");

        //სელენიუმ VS javascripexecutor-ის ეკვივალენტი ბრძანებები

    }
}
