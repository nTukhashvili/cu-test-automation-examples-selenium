package org.example.lection_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class TabHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // როცა ხდება ბრაუზერის ინიციალიზაცია ავტომატურად იხსნება პირველი ტაბი
        // ყველა ტაბს ენიჭება უნიკალური ID რომლის დახმარებითაც შეგვიძლია მარტივ
        String firstTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        //ახალი ტაბის შექმის შემდეგ ბრაუზერი ავტოამტურად აფოკუსირებს ახლად შექნილ ტაბს
        String secondTab = driver.getWindowHandle();

        //კონსოლზე დავბეჭდოთ პირველი და მეორე ტაბების უნიკალური handle-ები
        System.out.println("პირველი ტაბი : " + firstTab);
        System.out.println("მეორე ტაბი : " + secondTab);

        //ვამატებთ მესამე ტაბს
        driver.switchTo().newWindow(WindowType.TAB);

        //გვიბრუნებს სიას ყველა live(ცოცხალი) ტაბისთვის რომელიც გახსნილია ბრაუზერის ფანჯარაში
        Set<String> windowHandles = driver.getWindowHandles();

        //დავბეჭდოთ ყველა აქტიური ტაბი
        System.out.println(windowHandles);

        //დავუბრუნდეთ პირველ ტაბს
        Thread.sleep(3000);
        driver.switchTo().window(firstTab);

        //გადავიდეთ მეორე ტაბზე
        Thread.sleep(3000);
        driver.switchTo().window(secondTab);

        Thread.sleep(5000);
        driver.quit();


    }
}
