package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //goTo login page
        if (!isLoginFormPresent()) {
            //if user logged in, click logout, go to login
            if (userLoggedIn()) {
                logOut();
            }
            clickLoginTabOnHeader();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {

        //fill login form
        fillLoginForm(new User()
                .withEmail("manuel@gmail.com")
                .withPassword("Manuel12345"));
        //submit login
        submitForm();
        //Assert userLoggedIn
        Assert.assertTrue(userLoggedIn());
        String email = wd.findElement(By.cssSelector("[href='/account']")).getText();
        System.out.println(email);
        Assert.assertEquals(email,"manuel@gmail.com");
    }

    public void fillLoginForm(User user) {
        type(By.name("email"),user.getEmail());
        type(By.name("password"),user.getPassword());
    }

}
