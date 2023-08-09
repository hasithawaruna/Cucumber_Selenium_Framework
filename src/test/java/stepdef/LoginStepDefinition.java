package stepdef;

import hooks.DriverInit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/7/2023
 * Time: 3:29 PM
 */
public class LoginStepDefinition extends DriverInit {

    HomePage homePage = new HomePage(DriverInit.Driver);
    LoginPage loginPage = new LoginPage(DriverInit.Driver);


    @Given("I entered a valid {string} and a {string}")
    public void i_entered_a_valid_and_a(String un, String pw) {

        loginPage.enterUserName(un);
        loginPage.enterPassword(pw);

    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {

        loginPage.clickLogin();

    }

    @Then("I should be able logged in successfully")
    public void i_should_be_able_logged_in_successfully() {

        homePage.verifyHomePageTitle();

    }
}
