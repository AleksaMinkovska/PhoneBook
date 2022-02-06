package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;         // Listener ne sposoben vzaimodejstvovatj s WebDriverom
    EventFiringWebDriver wd;     // <-- Driver kotorij sposoben vzaimodejstvovatj s Listenerom

    UserHelper userHelper;
    ContactHelper contactHelper;


    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);   // logger ex

    public void init(){

        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());  // <--- novaja zapisj v svjazke s Chrome


        logger.info("All tests start in ChromeBrowser"); // info from logger info(in console)

        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //nejavnoje ozidanije, piwetsja odin raz v kode posle otkritija stranici.


        wd.register(new MyListener());    // registracija Listenera

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
