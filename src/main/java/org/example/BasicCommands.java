package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


/* გამოსადეგი shortcut-ები
   psvm - ქმნის main მეთოდს
   sout - პრინტ მეთოდი კონსოლში დასაბეჭდად
 */

public class BasicCommands {
    public static void main(String[] args) throws InterruptedException {
        //ვუთითებთ ქრომის დრაივერის ლოკაციას
        System.setProperty("webdriver.chrome.driver", "path to driver");

        //ვქმნით chrome ბრაუზერის ინსტანს, ავტომატურად იხსნება ცარიელი ფანჯარა
        WebDriver driver = new ChromeDriver();
        //ვამატებთ ლოდინს იმსითვის რომ დავჰელნდოთ შესაძლო exception throws InterruptedException უნდა დავუმატოთ main methods
        Thread.sleep(1000);
        //ერთდროულად შესაძლებელია რამდენიმე სხვადასხვა ბრაუზერის ინსტანსის შექმნა თუ დაინსტალირებულია firefox ავტომატურად გაეშვება
        //WebDriver firefoxDriver = new FirefoxDriver();

        //ბრაუზერი გაეშვება დიდი ზომით მთლიანად ფანჯარაში
        driver.manage().window().maximize();

        Thread.sleep(1000);

        //ბრაუზერის ფანჯარა დაპატარავდება
        driver.manage().window().minimize();

        Thread.sleep(1000);
        //შესაძლებელია ბრაუზერის ფანჯრისთვის კონკრეტული ზომების მითითება
        //setSize მეთოდი იღებს პარამატერად Dimmension კლასის ობიექტს სადაც უნდა გავდეთ ორი პარამეტრი x/y ზომები
        driver.manage().window().setSize(new Dimension(1280,720));

        Thread.sleep(1000);
        //ბრაუზერით კონკრეტულ მისამართზე გადასვლა
        driver.get("https://www.google.com");

        Thread.sleep(1000);
        //driver.get და navigate().to() ერთი და იგივე ბრძანებებია და არანაიი განსხვავება არაა მათ შორის
        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(1000);
        //ბრაუზერის back ღილაკი
        driver.navigate().back();

        Thread.sleep(1000);
        //ბრაუზერის forward ღილაკი
        driver.navigate().forward();

        Thread.sleep(1000);
        //ფანჯრის განახლება/დარეფრეშება
        driver.navigate().refresh();

        Thread.sleep(1000);
        //ახალი ტაბის გახსნა
        driver.switchTo().newWindow(WindowType.TAB);
        driver.manage().window().maximize();

        Thread.sleep(1000);
        //მეორე ტაბში გადავდივართ ვიკიპედიის გვერდზე
        driver.get("https://www.wikipedia.org");

        //შეგვიძლია ავიღოთ ტაბის title (იმ ტაბის რომელიცაა ამ წუთას დაფოსირებული)
        String title = driver.getTitle();
        //ვიღებთ URL იმ გვერდის რომელზეც ვიმყოფებით
        String currentURL = driver.getCurrentUrl();

        System.out.println(title);
        System.out.println(currentURL);

        //ვეძებთ ელემენტს id-ით
        WebElement searchInput =  driver.findElement(By.id("searchInput"));
        //ვწერთ სასურველ ტექსტს საძიებო ველსი
        searchInput.sendKeys("Georgia");

        //ვეძებთ ელემემენტს xpath-ით
        WebElement searchIcon = driver.findElement(By.xpath("//i[@data-jsl10n = 'search-input-button']"));
        searchIcon.click();

        Thread.sleep(1000);
        //ვიღებთ ტექსტს კონრეტული ელემენტიდან ვეძებთ კლასის სახელით
        String searchResultTitle =  driver.findElement(By.className("mw-page-title-main")).getText();
        System.out.println(searchResultTitle);

        Thread.sleep(1000);
        //ბრაუზერის ტაბის დახურვა
        driver.close();

        //ბრაუზერის ფანჯრის(ყველა ტაბის) დახურვა
        driver.quit();
        Thread.sleep(1000);


    }
}
