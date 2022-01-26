package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestsBase{

    @BeforeMethod
    public void preConditions() {
        // if not logIn --> needs to be logIn
        if(!app.getUserHelper().isSignOutButtonPresent()){
            app.getUserHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }

    }

    @Test
    public void addContactSuccess(){
        // open add --> fill form --> click save button

        int numIndex = (int)(System.currentTimeMillis()/1000%3600);
        Contact contact = Contact.builder()
                .name("Alex")
                .lastName("Kex")
                .phone("0545"+numIndex+"737")
                .email("alex@google.com")
                .address("Luton, Build street 5 - 8")
                .description("friend from UK")
                .build();

        app.getContactHelper().openAddForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().clickSaveButton();

        //Assert.assertTrue(app.getContactHelper().isContactAdded());
    }
}
