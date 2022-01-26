package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase {

    @BeforeMethod
    // if LogIn --> SignOut
    public void preconditions(){
        if(app.getUserHelper().isSignOutButtonPresent()){
            app.getUserHelper().signOut();
        }
    }

    @Test
    public void loginSuccess(){

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        // type(By.xpath("//*[@placeholder='Email']"),"noa@gmail.com");
        // type(By.xpath("//*[@placeholder='Password']"), "Nnoa12345$");

        app.getUserHelper().clickLoginButton();
        // click(By.xpath("//button[.=' Login']"));

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }




// *********************   Test with model  *********************
    @Test
    public void loginSuccessModel(){

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().clickLoginButton();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

}
