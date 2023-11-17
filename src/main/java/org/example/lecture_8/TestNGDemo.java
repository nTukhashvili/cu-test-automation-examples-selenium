package org.example.lecture_8;
import org.openqa.selenium.By;


import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class TestNGDemo {
    @Test
    public void BasicTest(){
        open("https://www.google.com");
        $(By.name("q"))
                .shouldBe(visible)
                .setValue("Caucasus University")
                .pressEnter();

        $$(By.cssSelector("h3[class='LC20lb MBeuO DKV0Md']"))
                .first()
                .shouldHave(Condition.text("Caucasus University"));

    }
}
