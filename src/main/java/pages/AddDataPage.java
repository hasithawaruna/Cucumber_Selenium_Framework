package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/8/2023
 * Time: 9:03 AM
 */
public class AddDataPage {

    WebDriver driver;

    public AddDataPage(WebDriver driver) {

        this.driver = driver;

    }

    //Elements

    WebElement inputElement;
    By title = By.tagName("h2");
    By fullNameElement = By.id("fullName");
    By ageElement = By.id("age");
    By addressElement = By.id("address");
    By birthdayElement = By.xpath("//input[@placeholder='yyyy-mm-dd']");
    By birthdayYearDropdownElement = By.xpath("//select[@title='Select year']");
    By birthdayMonthDropdownElement = By.xpath("//select[@title='Select month']");
    By countryElement = By.id("country");
    By angularElement = By.xpath("//*[contains(text(),'ANGULAR')]");
    By maleGenderElement = By.id("Male");
    By femaleGenderElement = By.id("Female");
    By submitElement = By.xpath("//input[@value='Submit']");
    By resetElement = By.xpath("//input[@value='Reset']");


    //Expected texts

    String expectedTitle = "View Data";
    String expectedBorderColor = "rgba(255, 255, 255, 1)";


    public void verifyAddDataPageTitle() {

        String titleText = driver.findElement(title).getText();
        Assert.assertEquals(titleText, expectedTitle);

    }

    public void EnterAllValues(String name, String age, String address, String birthday, String country, String expert, String gender) {

        driver.findElement(fullNameElement).sendKeys(name);
        driver.findElement(ageElement).sendKeys(age);
        driver.findElement(addressElement).sendKeys(address);
        driver.findElement(birthdayElement).sendKeys(birthday);
        selectCountry(country);
        selectExpertArea(expert);
        selectGender(gender);

    }

    public void EnterAllValuesExceptAddress(String name, String age, String birthday, String country, String expert, String gender) {

        driver.findElement(fullNameElement).sendKeys(name);
        driver.findElement(ageElement).sendKeys(age);
        driver.findElement(birthdayElement).sendKeys(birthday);
        selectCountry(country);
        selectExpertArea(expert);
        selectGender(gender);

    }

    public void selectCountry(String country) {

        WebElement dropdown = driver.findElement(countryElement);
        Select sel = new Select(dropdown);
        sel.selectByVisibleText(country);

    }

    public void selectExpertArea(String expert) {

        if (expert.equals("ANGULAR")) {

            driver.findElement(By.xpath("//label[contains(text(),'ANGULAR')]/preceding-sibling::input")).click();
        } else if (expert.equals("JAVA")) {

            driver.findElement(By.xpath("//label[contains(text(),'JAVA')]/preceding-sibling::input")).click();
        } else if (expert.equals("C#")) {

            driver.findElement(By.xpath("//label[contains(text(),'C#')]/preceding-sibling::input")).click();
        } else if (expert.equals("GIT")) {

            driver.findElement(By.xpath("//label[contains(text(),'GIT')]/preceding-sibling::input")).click();
        } else if (expert.equals("HTML")) {

            driver.findElement(By.xpath("//label[contains(text(),'HTML')]/preceding-sibling::input")).click();
        } else {

            System.out.println("Invalid expert value provided");

        }

    }

    public void selectGender(String gender) {

        if (gender.equals("MALE")) {

            driver.findElement(maleGenderElement).click();
        } else if (gender.equals("FEMALE")) {

            driver.findElement(femaleGenderElement).click();
        } else {
            System.out.println("Invalid Gender value provided");

        }
    }


    public void enterName(String name) {

        driver.findElement(fullNameElement).sendKeys(name);

    }

    public void enterAge(String age) {

        driver.findElement(ageElement).sendKeys(age);

    }

    public void enterAddress(String address) {

        driver.findElement(addressElement).sendKeys(address);

    }

    public void enterBirthday(String birthday) {

        driver.findElement(birthdayElement).click();
        Select se;
        String[] parts = birthday.split("-"); //Split given date into sections
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];

        //Interact with Year selector
        WebElement yearElement = driver.findElement(birthdayYearDropdownElement);
        se = new Select(yearElement);
        se.selectByVisibleText(year);

        //Interact with Month selector
        WebElement monthElement = driver.findElement(birthdayMonthDropdownElement);
        se = new Select(monthElement);
        se.selectByVisibleText(month);

        //Interact with Date
        driver.findElement(By.xpath("//*[contains(@aria-label,'" + day + ", " + year + "')]")).click();

    }

    public void clickSubmit() {

        driver.findElement(submitElement).click();

    }

    public void clickReset() {

        driver.findElement(resetElement).click();

    }

    public void verifyReset() {

        //input boxes

        inputElement = driver.findElement(fullNameElement);
        Assert.assertEquals(inputElement.getAttribute("value"), "");

        inputElement = driver.findElement(ageElement);
        Assert.assertEquals(inputElement.getAttribute("value"), "");

        inputElement = driver.findElement(addressElement);
        Assert.assertEquals(inputElement.getAttribute("value"), "");

        inputElement = driver.findElement(birthdayElement);
        Assert.assertEquals(inputElement.getAttribute("value"), "");

        //Radio buttons

        inputElement = driver.findElement(femaleGenderElement);
        Assert.assertFalse(inputElement.isSelected());

        inputElement = driver.findElement(maleGenderElement);
        Assert.assertFalse(inputElement.isSelected());

        //Checkboxes

        Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'ANGULAR')]/preceding-sibling::input")).isSelected());

        Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'JAVA')]/preceding-sibling::input")).isSelected());

        Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'C#')]/preceding-sibling::input")).isSelected());

        Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'GIT')]/preceding-sibling::input")).isSelected());

        Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'HTML')]/preceding-sibling::input")).isSelected());

    }

    public void verifyBorderColor() {

        String borderColor = driver.findElement(addressElement).getCssValue("background-color");
        Assert.assertEquals(borderColor, expectedBorderColor);

    }

}
