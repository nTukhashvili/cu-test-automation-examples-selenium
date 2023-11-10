package org.example.lecture_7;

import com.codeborne.selenide.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class SelenideDemo {

    @Test
    public void googleSearchTest() throws InterruptedException {
        //Selenide-ის კონფიგურაცია
        Configuration.browser = "chrome";
        //დეფაულტად 4 წამს ელოდება
        Configuration.timeout = 5000;
        Configuration.headless = true;
//        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadTimeout = 20000;
//        Configuration.clickViaJs = true;
//        Configuration.reportsFolder = "path";


        //open ბრძანებით ვხსნით default ბრაუზერს და გადავდივართ მითითებულს ბმულზე
        open("https://www.google.com");
        //ელემენტის მოსაძებნად საშწიროა $-ის გამოყენება და მითითება თუ რომელი ტიპის ლოკატორით ვეძებთ
        //SetValue-იგივეა რაც sendKeys ბრძანებს სელენიუმში
        //შეამჩნებდით ასევე რომ შესაძლებელია ბრძანებების chaining
        $(By.name("q"))
          .setValue("nika")
          .pressEnter();
    }

    @Test
    public void fillForm() throws  InterruptedException {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        //დეფაულტად 4 წამს ელოდება
        Configuration.timeout = 5000;
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(By.id("firstName")).setValue("Nika");
        $(By.id("lastName")).setValue("Tukhashvili");
        $(By.xpath("//label[@for='gender-radio-1']")).click();
        $(By.id("userNumber")).setValue("555669070");
        $(By.id("dateOfBirthInput")).click();
                $(By.xpath("//div[@class='react-datepicker__month-container']"))
                .find(By.cssSelector("select[class='react-datepicker__month-select']"))
                .selectOption("October");

        //$(By.xpath("//div[@class='react-datepicker__month-container']//select[@class='react-datepicker__month-select']")).selectOption("October");
        $(By.xpath("//div[@class='react-datepicker__month-container']//select[@class='react-datepicker__year-select']")).selectOption("1998");

        $(By.xpath("//div[contains(@aria-label, 'October 29th')]")).click();
        Thread.sleep(1000);
        $(By.xpath("//*[@id='subjectsContainer']")).click();
        Thread.sleep(1000);
        actions().sendKeys("Math").perform();
        $(By.xpath("//*[@id='react-select-2-option-0']")).click();
        $(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1)")).click();
        $(By.cssSelector("#uploadPicture")).setValue("C:\\Users\\white\\Desktop\\Screen_Shot_2018-10-25_at_11.02.15_AM.png");
        $(By.cssSelector("#currentAddress")).setValue("Some TEXT");
//        $(By.id("state")).click();
//        $(By.id("react-select-3-input")).setValue("NCR");
//        $(By.id("react-select-3-option-0")).click();

        //Verification

    }


    //JS Click-ის მაგალითი როდესაც ვცდილობთ დავაკლიკოთ ელემნტს რომელიც არის სხვა ელემენტის შიგნით და ნაგულისმები კლიკ ფუნქცია არ მუშაობს
    @Test
    public void jsClick(){
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.clickViaJs = true;
        //დეფაულტად 4 წამს ელოდება
        Configuration.timeout = 5000;
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(byId("hobbies-checkbox-2")).click();
    }

    @Test
    public void collections(){
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        //დეფაულტად 4 წამს ელოდება
        Configuration.timeout = 5000;
        open("https://demoqa.com/selectable");
        getWebDriver().manage().window().maximize();
        ElementsCollection itemList = $$(byXpath("//*[@id='verticalListContainer']//li"));
        for (SelenideElement el: itemList
             ) {
            el.click();
        }
    }


    @Test
    public void collectionsConditions(){
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        //დეფაულტად 4 წამს ელოდება
        Configuration.timeout = 5000;
        open("https://demoqa.com/selectable");
        getWebDriver().manage().window().maximize();
        ElementsCollection itemList = $$(byXpath("//*[@id='verticalListContainer']//li"));
        itemList.shouldHave(CollectionCondition.itemWithText("Cras justo odio"));
        //itemList.shouldHave(CollectionCondition.anyMatch("items with 10 charactes or more", e -> e.getText().length() > 100));



    }

    @Test
    public void navigation() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        //დეფაულტად 4 წამს ელოდება
        Configuration.timeout = 5000;
        open("https://demoqa.com/selectable");
        open("https://google.com/");
        back();
        forward();
        switchTo().newWindow(WindowType.TAB);
        WebDriverRunner.closeWindow();
        Thread.sleep(2000);
        WebDriverRunner.closeWebDriver();

    }

    @Test
    public void alerts() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        //დეფაულტად 4 წამს ელოდება
        Configuration.timeout = 5000;
        open("https://demoqa.com/alerts");
        $(byId("alertButton")).click();
        Alert alerts = switchTo().alert();
        alerts.accept();
        }


    @Test
    public void googleSearch() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        open("https://www.google.com");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(By.name("q")).setValue("Caucasus University")
                .shouldBe()
                .pressEnter();
        $(By.id("logo")).shouldBe(visible);
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)", "");
        ElementsCollection els =  $$(By.cssSelector("[class='LC20lb MBeuO DKV0Md']"));
        System.out.println(els.size());
        els.shouldHave(CollectionCondition.sizeGreaterThan(10));
        for (SelenideElement el: els
             ) {
            System.out.println(el.getText());

        }


    }

    }

