package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/7/2023
 * Time: 4:05 PM
 */

@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepdef", "hooks", "pages"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        dryRun = false,
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}

