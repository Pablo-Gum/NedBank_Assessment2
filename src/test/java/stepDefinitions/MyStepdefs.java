package stepDefinitions;

import DataReader.ExcelReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import extentReport.Reporting;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.WebFunction;
import utilities.WebUtilities;

import java.io.IOException;

public class MyStepdefs {

    ExtentTest node;
    ExtentReports repo;
    @Before
    public void beforeTest(Scenario scenario){

        repo = report.initializeExtentReports("reporting/AssessmentReoprt.html");
        ExtentTest test = repo.createTest("Assessment").assignAuthor("Pablo");
        node = test.createNode(scenario.getName());
    }

    @After
    public void tearDown(){
        WebUtilities.getWebDriver().quit();
        repo.flush();
    }

    WebFunction assessment = new WebFunction();
    Recordset rs = ExcelReader.readExcel("Data/BookStore.xlsx","SELECT * FROM Sheet1");



    Reporting report = new Reporting();
    @Given("User launches a browser and navigates to the  webPage")
    public void userLaunchesABrowserAndNavigatesToTheBookStoreWebPage() {
       // web.getWebDriver().switchTo().frame("");
        assessment.LandingPage();
    }
    @When("user enters Username and Password and clicks on the login button")
    public void userEntersUsernameAndPasswordAndClicksOnTheLoginButton() throws InterruptedException, IOException, FilloException {
      //  web.getWebDriver().switchTo().frame("")
        while(rs.next()){
            assessment.LoginPage(WebUtilities.getWebDriver(),rs.getField("Username"),rs.getField("Password"),node);
            break;
        }
    }
    @When("user search for Book")
    public void userSearchForBook() throws IOException, InterruptedException {
       // web.getWebDriver().switchTo().frame("");
        assessment.SearchBook(WebUtilities.getWebDriver(),node);
    }
    @When("user logs out")
    public void userLogsOut() throws IOException {
        assessment.Logout(WebUtilities.getWebDriver(),node);
    }



}
