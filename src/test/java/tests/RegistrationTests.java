package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestsBase {

    @BeforeMethod
    // if LogIn --> SignOut
    public void preconditions(){
        if(app.getUserHelper().isSignOutButtonPresent()){
            app.getUserHelper().signOut();
        }
    }

    @Test
    public void registrationSuccess(){

        int index = (int)(System.currentTimeMillis()/1000%3600);
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillRegistrationForm("marak" + index + "@mail.ru", "Mrak777$");
        app.getUserHelper().registration();

        //app.getUserHelper().pause(3000); // test passed with 'pause' and with 'implicitly' TIME METHODS
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());
    }



// *********************   Test with model  *********************

    @Test
    public void registrationSuccessModel(){
        int index = (int)(System.currentTimeMillis()/1000%3600);

        User user = new User().withEmail("masha" + index + "@mail.ru").withPassword("Mmasha12345$");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().registration();

        //app.getUserHelper().pause(3000);    //---> test passed with 'pause' and with 'implicitly' TIME METHODS
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());
    }


}
