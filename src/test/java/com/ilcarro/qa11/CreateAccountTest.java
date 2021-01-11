package com.ilcarro.qa11;

import com.ilcarro.qa11.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isElementPreswent(By.cssSelector("[href='/signup']"))) {//sign up not present
            wd.findElement(By.xpath("//a[contains(.,'logOut')]")).click(); //click on logout form
        }
    }

    @Test
    public void testSignUp() {
        wd.findElement(By.cssSelector("[href='/signup']")).click(); //click on SignUp Button

       Assert.assertTrue(isElementPreswent(By.cssSelector("form.signup__fields")));

        //fill registration form
       wd.findElement(By.cssSelector("#first_name")).click();
       wd.findElement(By.cssSelector("#first_name")).clear();
       wd.findElement(By.cssSelector("#first_name")).sendKeys("Manuel");

        wd.findElement(By.cssSelector("#second_name")).click();
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("Neuer");

        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("manuel@gmail.com");

        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("Manuel12345");

        wd.findElement(By.cssSelector("#check_policy")).click();

        //click Submit button
        //check login form displayed

    }


}
