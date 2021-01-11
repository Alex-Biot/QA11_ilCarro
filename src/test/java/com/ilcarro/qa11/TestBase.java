package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver wd;

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.driver.chrome","");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        wd.quit();
    }

    public boolean isFindCarFromPresent() {
        return wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form")).size()>0;
    }

    public boolean isElementPreswent(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public boolean isFindCarFromPresent2(By by) {
        try{
            wd.findElement(by);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }
}
