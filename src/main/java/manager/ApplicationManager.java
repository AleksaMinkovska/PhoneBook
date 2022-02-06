package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    ContactHelper contactHelper;


    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);   // logger ex

    public void init(){
        wd = new ChromeDriver();

        logger.info("All tests start in ChromeBrowser"); // info from logger info(in console)

        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //nejavnoje ozidanije, piwetsja odin raz v kode posle otkritija stranici.

        userHelper = new UserHelper(wd);
        contactHelper = new ContactHelper(wd);
    }
    public void stop(){
        wd.quit();
    }


// *********************   Getters  *********************

    public UserHelper getUserHelper(){
        return userHelper;
    }
    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
