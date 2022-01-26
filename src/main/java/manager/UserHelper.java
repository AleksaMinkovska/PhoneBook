package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd){
        super(wd);
    }


//  *********************   LOGIN methods  *********************

    public void openLoginForm(){
        click(By.cssSelector("a[href='/login']"));
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//*[@placeholder='Email']"),email);
        type(By.xpath("//*[@placeholder='Password']"), password);
    }
    public void fillLoginForm(User user){
        type(By.xpath("//*[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//*[@placeholder='Password']"), user.getPassword());
    }
    public void clickLoginButton() {
        click(By.xpath("//button[.=' Login']"));
    }

// *********************   Registration methods  *********************

    public void fillRegistrationForm(String email, String password){
        type(By.xpath("//*[@placeholder='Email']"),email);
        type(By.xpath("//*[@placeholder='Password']"), password);
    }
    public void fillRegistrationForm(User user){
        type(By.xpath("//*[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//*[@placeholder='Password']"), user.getPassword());
    }
    public void registration() {
        click(By.cssSelector("button:last-child"));
    }

// *********************   Boolean check  *********************

    public boolean isRegistrationSuccess() {
        WebElement addButton = wd.findElement(By.cssSelector("a[href='/add']"));
        return addButton.isDisplayed();
    }
    public boolean isLoginSuccess() {
        WebElement signOut = wd.findElement(By.cssSelector("button"));
        return signOut.isEnabled();
    }
    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

// *********************   Buttons  *********************

    public void signOut() {
        click(By.xpath("//*[.='Sign Out']"));
    }
    public void login(User user){
        openLoginForm();
        fillLoginForm(user);
        clickLoginButton();
    }
}
