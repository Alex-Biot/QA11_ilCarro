package com.ilcarro.qa11;

import org.openqa.selenium.By;
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
    public void loginRegisteredUserPosiveTest() {

        //fill login form
        type(By.name("email"),"manuel@gmail.com");
        type(By.name("password"),"Manuel12345");
        //submit login
        submitForm();
        //Assert userLoggedIn
    }

}
