package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebUtilities {

    protected static  WebDriver driver;
    public void setWebDriver(WebDriver _driver){
       this.driver =_driver;
    }
    public static WebDriver getWebDriver(){
        return driver;
    }

    public WebDriver initializeWebDriver(String Browser){
        switch(Browser.toUpperCase()){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public void navigate(String Url){
        driver.get(Url);
    }


}
