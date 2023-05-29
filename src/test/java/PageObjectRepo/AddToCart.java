package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.xml.xpath.XPath;

public class AddToCart {
    protected WebDriver driver;
    public AddToCart( WebDriver _driver){
        this.driver = _driver;
        PageFactory.initElements(_driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(_driver,10),this);
    }

    @FindBy (xpath = "//*[@class='text-right fullButton']//child::button ")
    public WebElement AddToCart;

    @FindBy(xpath = "//*[@class='text-left fullButton']//child::button")
    public WebElement BackToBookStore;
}
