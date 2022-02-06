package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);


    public MyListener() {    //constructor superKlassa
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element ---> " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Element with locator ---> " + by + " was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {   // sliwit owibki, zapisivajet v logs
        super.onException(throwable, driver);
        logger.info("We have a throwable ---> " + throwable.getMessage());
        logger.info(throwable.fillInStackTrace().toString());
    }
}