package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.LoggerHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.*;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import utils.base64;
import utils.Screenshot;
import uistore.locators;
import utils.excelReadFile;
import utils.Reporter;
public class homepage  {

    private Map<String, String> testData; 

    java.util.logging.Logger log = LoggerHandler.getLogger();
    base64 screenshotHandler = new base64();
    ExtentReports reporter = Reporter.generateExtentReport();
    Screenshot screenshot = new Screenshot();
    excelReadFile file = new excelReadFile();

    @BeforeMethod
    public void loadData() {
        try {
            testData = excelReadFile.readTestData("/home/coder/project/workspace/Project/testdata/Testdata.xlsx", "Sheet1");
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    public void Valid_Login_TC(WebDriver driver)throws IOException {
    
            Map<String, String> testData = excelReadFile.readTestData("/home/coder/project/workspace/Project/testdata/Testdata.xlsx", "Sheet1");
            String username = testData.get("username");
            String password = testData.get("password");

            driver.findElement(locators.username).sendKeys(username);
            driver.findElement(locators.password).sendKeys(password);
            driver.findElement(locators.submit).click();
            Screenshot.getScreenShot("Login Test_Screenshot");


    }
    public void Register(WebDriver driver)throws IOException {
            
            Map<String, String> testData = excelReadFile.readTestData("/home/coder/project/workspace/Project/testdata/Testdata.xlsx", "Sheet1");
            String username = testData.get("username");
            String password = testData.get("password");
            String depositAmount = testData.get("depositAmount");

            driver.findElement(locators.username).sendKeys(username);
            driver.findElement(locators.password).sendKeys(password);
            driver.findElement(locators.submit).click();
            Duration timeout = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            WebElement depositLink = wait.until(ExpectedConditions.elementToBeClickable(locators.depositLink));
            depositLink.click();
            Select accType=new Select(driver.findElement(locators.accType));
            log.info("Account Type has been selected");
            accType.selectByVisibleText("Individual Checking (Standard Checking)");
            driver.findElement(locators.amount).sendKeys(depositAmount);
            log.info("Amount has been sent");
            driver.findElement(By.xpath(locators.submitAcc)).click();

        
    }
    public void WithdrawTest(WebDriver driver)throws IOException {
            Map<String, String> testData = excelReadFile.readTestData("/home/coder/project/workspace/Project/testdata/Testdata.xlsx", "Sheet1");
            String username = testData.get("username");
            String password = testData.get("password");
            String withdrawAmount = testData.get("withdrawAmount");

            driver.findElement(locators.username).sendKeys(username);
            driver.findElement(locators.password).sendKeys(password);
            driver.findElement(locators.submit).click();
            Duration timeout = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            WebElement depositLink = wait.until(ExpectedConditions.elementToBeClickable(locators.Withdrawlink));
            depositLink.click();
            Select accType=new Select(driver.findElement(locators.accType));
            log.info("Account Type has been selected");
            accType.selectByVisibleText("Individual Checking (Standard Checking)");
            driver.findElement(locators.amount).sendKeys(withdrawAmount);
            log.info("Amount has been sent");
            driver.findElement(By.xpath(locators.submitAcc)).click();

        
    }
}



