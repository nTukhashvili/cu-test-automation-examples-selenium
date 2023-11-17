package org.example.lecture_8;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Parameters {

    @BeforeClass
    @org.testng.annotations.Parameters({"browserWindowSize","url"})
    public void setup(String browserWindowSize, String url){
        Configuration.browserSize = browserWindowSize;
        open(url);

    }

    @Test
    public void simpleTest(){
        Assert.assertEquals(1,1);
    }
}
