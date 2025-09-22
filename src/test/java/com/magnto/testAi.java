package com.magnto;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testAi extends Base {

    @Test(dataProvider = "invalidLoginData")
    public void TC02_Invalid_login(String username, String password) {
        // Arrange
        loginPage.enterEmail(username);   // Enter invalid username
        loginPage.enterPasword(password);  // Enter invalid password

        // Act
        loginPage.clickSignIn();  // Click the Login button

        // Assert
        Assert.assertTrue(loginPage.getErrorMessgae(), "Verifying error message is displayed");      
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return new Object[][] {
            {"abc", "123"},  // Invalid username, valid password
            {"", ""},         // Blank username and password
            {" ", " "}       // Username with space and password with space
        };
    }
}