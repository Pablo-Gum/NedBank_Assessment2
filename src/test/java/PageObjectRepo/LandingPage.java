package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LandingPage {
    protected WebDriver driver;

    public LandingPage(WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,10),this);
    }
    @FindBy(xpath="//*[@class='pattern-backgound playgound-header']//child::div[contains(.,'Book Store')]")
    public WebElement title;

}
