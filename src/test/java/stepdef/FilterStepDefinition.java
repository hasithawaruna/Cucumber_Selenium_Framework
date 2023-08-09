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
public class FilterStepDefinition extends DriverInit {

    HomePage homePage = new HomePage(DriverInit.Driver);
    LoginPage loginPage = new LoginPage(DriverInit.Driver);


    public FilterStepDefinition() {

    }

    @Given("I enter a valid username {string} and a password {string}")
    public void i_entered_a_valid_username_and_a_password_1(String username, String password) {

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @Given("I entered a {string} to the Filter Full Name input field")
    public void i_entered_a_to_the_input_field(String string) {
        homePage.EnterValues(string);

    }

    @When("I click on the Filter button")
    public void i_click_on_the_filter_button() {
        homePage.clickOnFilterButton();

    }

    @When("I entered a {string} to the input box of Full Name table header")
    public void i_entered_a_to_the_input_box_of_full_name_table_header(String name) {
        homePage.openTableHeaderInputBox();
        homePage.fillTableHeaderInputBox(name);

    }

    @Then("I should be able to see results which contain {string} value")
    public void i_should_be_able_to_see_valid_records_for_the_given_input(String name) {
        homePage.verifySearchResults(name);

    }


}
