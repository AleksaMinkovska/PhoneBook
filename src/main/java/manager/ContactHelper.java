package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public boolean isContactAdded() {
        WebElement list = wd.findElement(By.cssSelector("div[class*='contact-page_leftdiv__yhyke']"));
        return list.isDisplayed();

    }

    public void openAddForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("(//input[@placeholder='Name'])"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }

    public void clickSaveButton() {
        click(By.xpath("//button[.='Save']"));
        //click(By.cssSelector("button b"));
        //click(By.cssSelector("[href='/contacts']"));
        pause(10);
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }


    public boolean isContactByName(String name) {
        List<WebElement> list =wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list) {
            if(el.getText().equals(name))
                return true;
        }
        return false;
    }


    public boolean isContactByPhone(String phone) {
        List<WebElement> list =wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list) {
            if(el.getText().equals(phone))
                return true;
        }
        return false;
    }


    public void removeOneContact() {

        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }

    public void providerOfContacts() {
        if (countOfContacts() < 3) {
            int index = (int) (System.currentTimeMillis() / 1000) % 3600;

            for (int i = 0; i < 3; i++) {
                Contact contact = Contact.builder()
                        .name("Mark")
                        .lastName("Kler")
                        .phone("+97254" + index + "731")
                        .email("mark" + index + "@gmail.com")
                        .address("none")
                        .description("none")
                        .build();
                openAddForm();
                fillContactForm(contact);
                clickSaveButton();
                pause(2000);
            }
        }
    }

    public int removeContactCount() {

        int countBefore = countOfContacts();
        logger.info("Before remove 'One contact tests' count was --->" +countBefore);

        if(!isContactsListIsEmpty()){
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The phone number of removed contact was -->" +phone);

            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            wd.findElement(By.xpath("//button[text()='Remove']")).click();
            pause(500);
        }

        int countAfter = countOfContacts();
        logger.info("After remove one contact the count is --->" +countAfter);

        return countAfter-countBefore;

    }

    public boolean isContactsListIsEmpty() {

        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();

    }


    public void removeAllContactsNOTWORKS() {
        List <WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));

        for (WebElement el:list) {
            el.click();
            wd.findElement(By.xpath("//button[text()='Remove']")).click();
            pause(500);

        }
    }


    public void removeAllContacts (){
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
            removeContactCount();
        }

    }



}



