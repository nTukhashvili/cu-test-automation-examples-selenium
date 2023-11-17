package org.example.lecture_8;
import org.openqa.selenium.By;


import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class TestStructure {

    @Test(priority = 1)
    public  void setup() {
        System.out.println("Open Browser");

    }

    @Test(priority = 2, enabled = false)
    public  void executeSteps() {
        System.out.println("Login to application");
    }

    @Test(priority = 3)
    public  void teardown() {
        System.out.println("Close browser");

    }
}
