package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestsBase{

    @BeforeMethod
    public void preConditions() {
        // if not logIn --> needs to be logIn
        if(!app.getUserHelper().isSignOutButtonPresent()){
            app.getUserHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }

        app.getContactHelper().providerOfContacts();
    }

    @Test
    public void removeOneContact(){

        app.getContactHelper().countOfContacts();
        //app.getContactHelper().removeOneContact();
    }


//    @Test
//    public void removeContactsCount(){
//
////        int count = app.getContactHelper().removeContactCount();
////        Assert.assertEquals(count, -1);                                  // mozno i tak i tak
//
//        Assert.assertEquals(app.getContactHelper().removeContactCount(),-1);
//
//    }


//    @Test
//    public void removeAllContactsNOTWORKS(){
//
//        app.getContactHelper().removeAllContactsNOTWORKS();
//        Assert.assertTrue(app.getContactHelper().isContactsListIsEmpty());
//
//    }



    @Test
    public void removeAllContactTest() {

        app.getContactHelper().removeAllContacts();
        Assert.assertTrue(app.getContactHelper().isContactsListIsEmpty());


    }

}
