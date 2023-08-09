package stepdef;

import hooks.DriverInit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddDataPage;
import pages.HomePage;

/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/8/2023
 * Time: 8:53 AM
 */
public class AddRecordStepDefinition extends DriverInit {

    HomePage homePage = new HomePage(DriverInit.Driver);
    AddDataPage addPage = new AddDataPage(DriverInit.Driver);

    public AddRecordStepDefinition() {

    }

    @When("I click on Add New button")
    public void i_click_on_add_new_button() {

        homePage.clickOnAddRecordButton();
    }

    @When("I click on reset button")
    public void i_click_on_reset_button() {

        addPage.clickReset();
    }

    @And("I entered a name {string}")
    public void i_entered_a_name(String name) {

        addPage.enterName(name);
    }

    @And("I entered a age {string}")
    public void i_entered_a_age(String age) {

        addPage.enterAge(age);
    }

    @And("I entered a address {string}")
    public void i_entered_a_address(String address) {

        addPage.enterAddress(address);
    }

    @And("I select a birthday {string}")
    public void i_select_a_birthday(String birthday) {

        addPage.enterBirthday(birthday);
    }

    @And("I select a country {string}")
    public void i_select_a_country_sri_lanka(String country) {

        addPage.selectCountry(country);
    }

    @And("I select a expertise {string}")
    public void i_select_a_expertise(String expertise) {

        addPage.selectExpertArea(expertise);
    }

    @And("I select gender {string}")
    public void i_select_gender(String gender) {

        addPage.selectGender(gender);
    }

    @And("I click on submit")
    public void i_click_on_submit() {

        addPage.clickSubmit();
    }


    @Then("I should be able to see new record with {string} value")
    public void i_should_be_able_to_see_new_record_with_value(String name) {

        homePage.verifySearchResults(name);
    }

    @Then("I should be able to see Address field is mandatory")
    public void i_should_be_able_to_see_address_field_is_mandatory() {

        addPage.verifyBorderColor();
    }

    @Then("All filled values should erase successfully")
    public void all_filled_values_should_erase_successfully() {

        addPage.verifyReset();
    }


}
