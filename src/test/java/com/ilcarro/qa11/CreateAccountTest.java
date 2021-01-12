package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignUpTabPresentInHeader()) {//sign up not present
            logOut();
        }
    }

    @Test
    public void testSignUp() {
        //wd.findElement(By.cssSelector("[href='/signup']")).click(); //click on SignUp Button
        click(By.cssSelector("[href='/signup']"));

       Assert.assertTrue(isElementPreswent(By.cssSelector("form.signup__fields")));

        //fill registration form
        //manuel@gmail.com
        type(By.cssSelector("#first_name"), "Manuel");
        type(By.cssSelector("#second_name"), "Neuer");
        type(By.cssSelector("#email"), "manuel1@gmail.com");
        type(By.cssSelector("#password"), "Manuel12345");

        //wd.findElement(By.cssSelector("#check_policy")).click();
        click(By.cssSelector("#check_policy"));

        //click Submit button
        submitForm();
        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());
//        Assert.assertTrue(isElementPreswent(By.cssSelector(".Login_login__right_block__1niYm")));

    }


}
