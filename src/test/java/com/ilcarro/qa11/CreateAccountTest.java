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
    public void testSignUp() throws InterruptedException {
        //wd.findElement(By.cssSelector("[href='/signup']")).click(); //click on SignUp Button
        click(By.cssSelector("[href='/signup']"));

        Assert.assertTrue(isElementPreswent(By.cssSelector("form.signup__fields")));

        //fill registration form
        //manuel@gmail.com
        fillRegistraitionForm(new User()
                .withFirstName("Manuel")
                .withSecondName("Neuer")
                .withEmail("manuel6@gmail.com")
                .withPassword("Manuel12345"));

        //wd.findElement(By.cssSelector("#check_policy")).click();
        click(By.cssSelector("#check_policy"));

        //  Thread.sleep(2000);

        //click Submit button
        submitForm();
        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());
//        Assert.assertTrue(isElementPreswent(By.cssSelector(".Login_login__right_block__1niYm")));

    }

    @Test
    public void testSignUpWithoutPassword() {
        click(By.cssSelector("[href='/signup']"));

        Assert.assertTrue(isElementPreswent(By.cssSelector("form.signup__fields")));

        fillRegistraitionForm(new User()
                .withFirstName("Manuel1")
                .withSecondName("Neuer1")
                .withEmail("manuel51@gmail.com"));

        click(By.cssSelector("#check_policy"));

        submitForm();
        Assert.assertTrue(isLoginFormPresent());
    }

    public void fillRegistraitionForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }


}
