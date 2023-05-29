package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LogoutPage {
    protected WebDriver driver;
    public LogoutPage(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,10),this);
    }

    @FindBy(xpath ="//*[@class='text-right col-md-4 col-sm-12']//child::button")
    public WebElement logoutBtn;

    @FindBy(xpath = "//*[@id='userForm']//descendant::h5")
    public WebElement WelcomeTologinPage;
}
