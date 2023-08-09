package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/7/2023
 * Time: 2:29 PM
 */
public class LoginPage{

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    //Expected texts
    String expectedTitle = "Welcome";

    //Elements
    By username = By.name("username");
    By password = By.name("password");
    By submit = By.xpath("//input[@value='Login']");
    By title = By.tagName("h1");


    public void enterUserName(String UN) {

        driver.findElement(username).sendKeys(UN);

    }

    public void enterPassword(String PW) {

        driver.findElement(password).sendKeys(PW);

    }

    public void clickLogin() {

        driver.findElement(submit).click();
    }

    public void verifyTitle() {

        WebElement titleElement = driver.findElement(title);
        wait.until(ExpectedConditions.visibilityOf(titleElement));
        String titleText = driver.findElement(title).getText();
        Assert.assertEquals(titleText, expectedTitle);

    }

}