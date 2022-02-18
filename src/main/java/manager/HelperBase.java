package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperBase {

    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);


// *********************   Constructor  *********************

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

// *********************   Common methods  *********************

    public void type(By locator, String text){
        if(text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }
    public void click(By locator){
        wd.findElement(locator).click();
    }
    public void pause(int millsec){
        try {
            Thread.sleep(millsec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

// *********************  Boolean check  *********************

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

}
