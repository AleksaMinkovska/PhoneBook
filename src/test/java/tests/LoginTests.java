package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase {

    @BeforeMethod(alwaysRun = true)
    // if LogIn --> SignOut
    public void preconditions() {
        if (app.getUserHelper().isSignOutButtonPresent()) {
            app.getUserHelper().signOut();
        }
    }

    @Test
    public void loginSuccess() {

        logger.info("Test starts with: email [noa@gmail.com] & password [Nnoa12345$]");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        // type(By.xpath("//*[@placeholder='Email']"),"noa@gmail.com");
        // type(By.xpath("//*[@placeholder='Password']"), "Nnoa12345$");

        app.getUserHelper().clickLoginButton();
        // click(By.xpath("//button[.=' Login']"));

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


    // *********************   Test with model  *********************
    @Test(groups = {"web"})
    public void loginSuccessModel() {

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().clickLoginButton();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

// *********************   Negative Test  *********************

    @Test
    public void loginNegativeTestWithWrongPassword() {

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().clickLoginButton();

        //Assert.assertFalse(app.getUserHelper().isLoginSuccess());  // Just FYI
        Assert.assertTrue(app.getUserHelper().isAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().isWrongEmailOrPasswordFormat());
    }


    @Test(dataProvider = "loginValidData", dataProviderClass = MyDataProvider.class)
    public void loginSuccessDataProvider(String email, String password) {

        logger.info("Test starts with 'email':" + email + " & 'password': " + password);
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().clickLoginButton();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


    @Test(dataProvider = "loginValidDataModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccessModelDataProvider(User user) {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().clickLoginButton();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


    @Test(dataProvider = "loginValidDataCSV", dataProviderClass = MyDataProvider.class)
    public void loginSuccessDataProviderCSV(String email, String password) {

        logger.info("Test starts with 'email':" + email + " & 'password': " + password);
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().clickLoginButton();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());

    }

}
