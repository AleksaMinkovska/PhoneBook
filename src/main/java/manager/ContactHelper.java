package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public boolean isContactAdded() {
        return isElementPresent(By.cssSelector(".contact-page_leftdiv__yhyke"));
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
    }
}
