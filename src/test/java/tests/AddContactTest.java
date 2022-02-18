package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestsBase{

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        // if not logIn --> needs to be logIn
        if(!app.getUserHelper().isSignOutButtonPresent()){
            app.getUserHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }

    }

    @Test(groups = {"web"})
        public void addContactSuccess(){
            // open add --> fill form --> click save button

            int countStart = app.getContactHelper().countOfContacts();

            int numIndex = (int)(System.currentTimeMillis()/1000%3600);
            Contact contact = Contact.builder()
                    .name("Leo")
                    .lastName("Bug")
                    .phone("+3712"+numIndex+"737")
                    .email("leo"+numIndex+"@fb.com")
                    .address("Luton, Build street 5 - 8")
                    .description("friend from UK")
                    .build();

            app.getContactHelper().openAddForm();
            app.getContactHelper().fillContactForm(contact);
            app.getContactHelper().clickSaveButton();


            int countEnd = app.getContactHelper().countOfContacts();

            Assert.assertEquals(countEnd-countStart, 1);
        //Assert.assertTrue(app.getContactHelper().isContactAdded());

        Assert.assertTrue(app.getContactHelper().isContactByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactByPhone(contact.getPhone()));
    }




    @Test(dataProvider = "addContactValidDataCSV",dataProviderClass = MyDataProvider.class, enabled = false)
    public void addContactSuccessDataProvider(Contact contact){

        int countStart = app.getContactHelper().countOfContacts();

        app.getContactHelper().openAddForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().clickSaveButton();

        int countEnd = app.getContactHelper().countOfContacts();

        //Assert.assertEquals(countEnd-countStart, 1);
        Assert.assertTrue(app.getContactHelper().isContactByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactByPhone(contact.getPhone()));
    }




    @Test (dataProvider = "addContactValidDataModel",dataProviderClass = MyDataProvider.class,enabled = false)
    public void addNewContactSuccessDT(Contact contact){


        int countStart = app.getContactHelper().countOfContacts();

        logger.info("The test 'Add new contact' start with count of contact in start --->"+countStart);

        logger.info("The test 'Add new contact' start with data ---->" +contact.toString());
        app.getContactHelper().openAddForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().clickSaveButton();


        int countEnd = app.getContactHelper().countOfContacts();

        logger.info("The test 'Add new contact' end with count of contact in the end --->"+countEnd);

        // if countStart - countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        // if list contact with name + phone

        Assert.assertTrue(app.getContactHelper().isContactByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactByPhone(contact.getPhone()));
    }

}






