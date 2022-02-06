package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


// *********************   Alerts  *********************

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());

        if(alert == null){
            return false;
        }
        else{
            wd.switchTo().alert();
            alert.getText();  // get message from alert
            alert.accept();   // click Ok button
            //alert.dismiss();  // click cancel button
            //alert.sendKeys("email");  // send key
            //alert.getText();  // get message from alert
            return true;
        }
    }

    public boolean isErrorWrongPasswordOrEmailFormat() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();

        String error = alert.getText();
        alert.accept();
        return error.contains("Wrong email or password format");
    }
}
