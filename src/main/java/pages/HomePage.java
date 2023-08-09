package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/7/2023
 * Time: 3:40 PM
 */
public class HomePage {

    WebDriver driver;

    WebDriverWait wait;

    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    //Elements

    By title = By.tagName("h2");
    By fullName = By.xpath("//input[@placeholder='Filter Full Name']");
    By filterButton = By.xpath("//input[@value='Filter']");
    By tableHeader = By.xpath("//span[@class='ag-icon ag-icon-menu']");
    By tableHeaderInputBox = By.xpath("//input[@placeholder='Filter...']");
    By addButton = By.linkText("Add New");


    //Expected texts

    String expectedTitle = "View Data";


    public void verifyHomePageTitle() {

        String titleText = driver.findElement(title).getText();
        Assert.assertEquals(titleText, expectedTitle);

    }

    public void EnterValues(String name) {

        driver.findElement(fullName).sendKeys(name);

    }

    public void clickOnFilterButton() {

        driver.findElement(filterButton).click();

    }

    public void openTableHeaderInputBox() {

        driver.findElement(tableHeader).click();

    }

    public void fillTableHeaderInputBox(String name) {

        driver.findElement(tableHeaderInputBox).sendKeys(name);

    }

    public void verifySearchResults(String name) {
        try {
            Thread.sleep(500);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'" + name + "')]")));
            Assert.assertTrue(element.isDisplayed());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickOnAddRecordButton() {

        driver.findElement(addButton).click();

    }

}
