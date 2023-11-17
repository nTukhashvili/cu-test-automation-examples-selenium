package org.example.lecture_8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnotationsDependency {

    @Test
    public void checkInternetConnection(){
        System.out.println("Checking Internet Connection ...");
        //Assert.fail();

    }

    @Test(dependsOnMethods = {"checkInternetConnection"})
    public void openBrowser(){
        System.out.println("Opens browser");
    }

    @Test(alwaysRun = true)
    public void loginToApplication(){
        System.out.println("Logging into application");
    }


}
