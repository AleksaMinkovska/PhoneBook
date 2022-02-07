package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestsBase{

    @BeforeMethod
    public void preConditions() {
        // if not logIn --> needs to be logIn
        if(!app.getUserHelper().isSignOutButtonPresent()){
            app.getUserHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }

    }

    @Test
    public void removeOneContact(){

        app.getContactHelper().countOfContacts();
        //app.getContactHelper().removeOneContact();
    }


    @Test
    public void removeAllContacts(){

    }

}
