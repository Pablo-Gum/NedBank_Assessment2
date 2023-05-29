package utilities;

import DataReader.ExcelReader;
import PageObjectRepo.LoginPage;
import PageObjectRepo.LogoutPage;
import PageObjectRepo.SearchBook;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import extentReport.Reporting;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class WebFunction extends WebActions {
    WebUtilities web = new WebUtilities();


    public void LandingPage() {
        web.setWebDriver(web.initializeWebDriver("chrome"));
        web.navigate(" https://demoqa.com/books");
    }

    public void LoginPage(WebDriver driver,String Username,String Password,ExtentTest node) throws InterruptedException, IOException {
        LoginPage loginOBJ = new LoginPage(driver);
        String Testname = Reporting.CaptureScreenShot(driver);
        node.pass("Landing Page loaded successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(Testname).build());

        ClickObject(loginOBJ.intialloginBtn,driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try{
            String filename = Reporting.CaptureScreenShot(driver);
            if(loginOBJ.WelcomeTologinPage.isDisplayed()){
                node.pass("Welcome to Login Page",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                try{
                    SendKeysObject(loginOBJ.username,driver,Username);
                    SendKeysObject(loginOBJ.password,driver,Password);
                    ClickObject(loginOBJ.secloginBtn,driver);

                }catch(Exception e){
                    System.out.println(e.getMessage());
                    Assert.fail();
                }
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }

    }

    public void  SearchBook(WebDriver driver, ExtentTest node) throws IOException, InterruptedException {
        SearchBook searchBookOBJ = new SearchBook(driver);
        String loginValidation = Reporting.CaptureScreenShot(driver);

        //Login Validation
        if( searchBookOBJ.loginSuccessful.isDisplayed()){
            Thread.sleep(2);
            node.pass("Login successful",MediaEntityBuilder.createScreenCaptureFromBase64String(loginValidation).build());
            Assert.assertTrue(searchBookOBJ.loginSuccessful.isDisplayed());
        }else{
            if(searchBookOBJ.InvalidCreds.isDisplayed()){
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                node.fail("Invalid username or password",MediaEntityBuilder.createScreenCaptureFromBase64String(loginValidation).build());
                Assert.fail();
            }
        }
        try {
            ClickObject(searchBookOBJ.searchBox, driver);
            SendKeysObject(searchBookOBJ.searchBox, driver, "Programming JavaScript Applications");
            ClickObject(searchBookOBJ.bookName, driver);

        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        String filename = Reporting.CaptureScreenShot(driver);
        // validation
        if(searchBookOBJ.IBSN_number.isDisplayed()){
            node.pass("Book selected successfully and IBSN", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
        }else{
            node.fail("Failed to select the requested book",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
        }

    }

    public void Logout(WebDriver driver, ExtentTest node) throws IOException {
        LogoutPage logoutObj = new LogoutPage(driver);
        ClickObject(logoutObj.logoutBtn,driver);

        String filename = Reporting.CaptureScreenShot(driver);
        //Validation
        if(logoutObj.WelcomeTologinPage.isDisplayed()){
            node.pass("Logged out successful",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
        }else{
            node.fail("Failed to logout",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
        }
    }


}








