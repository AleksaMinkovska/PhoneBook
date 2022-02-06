package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
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
}

