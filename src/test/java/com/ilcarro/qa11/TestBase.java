package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver wd;

    @BeforeSuite
    public void setUp() {
        //System.setProperty("webdriver.driver.chrome","");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    @AfterSuite(enabled = false)
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

    public void type(By locator, String text) {
       click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isLoginFormPresent() {
        return isElementPreswent(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPreswent(By.cssSelector("[href='/signup']"));
    }

    public void logOut() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean userLoggedIn() {
        return isElementPreswent(By.xpath("//a[contains(.,'logOut')]"));
    }
}
