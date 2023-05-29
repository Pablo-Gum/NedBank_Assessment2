package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchBook {
    protected WebDriver driver;
    public SearchBook(WebDriver _driver){
        this.driver= _driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,10),this);
    }

    @FindBy(xpath="//*[@id='searchBox']")
    public WebElement searchBox;


    @FindBy(xpath="//*[@id='see-book-Programming JavaScript Applications']")
    public WebElement bookName;

    @FindBy(xpath="//*[@id='ISBN-label']")
    public WebElement IBSN_number;

    //Validation
    @FindBy(xpath="//*[@id='userForm']//descendant::p[contains(text(),'Invalid')]")
    public WebElement InvalidCreds;

    @FindBy(xpath = "//*[@class='books-wrapper']//child::label[@id='userName-label']")
    public WebElement loginSuccessful;



}
