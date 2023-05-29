package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    protected WebDriver driver;
    public LoginPage(WebDriver _driver){
        this.driver= _driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,10),this);
    }

    @FindBy(xpath="//*[@placeholder='UserName'] ")
    public WebElement username;

    @FindBy(xpath="//*[@placeholder='Password'] ")
    public WebElement password;

    @FindBy(xpath="//*[@class='books-wrapper']//descendant::button[contains(.,'Login')]")
    public WebElement intialloginBtn;

    @FindBy(xpath="//*[@id='login']")
    public WebElement secloginBtn;

    @FindBy(xpath = "//*[@id='userForm']//descendant::h5")
    public WebElement WelcomeTologinPage;

    // Validation


}
