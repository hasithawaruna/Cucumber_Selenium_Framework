package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/7/2023
 * Time: 8:22 PM
 */
public class MyHooks extends DriverInit {

    public MyHooks() {

    }

    @Before
    public void InitializeTest(Scenario scenario) {

        //Access local chromedriver
        String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        DriverInit.Driver = new ChromeDriver(chromeOptions);
        DriverInit.Driver.get("https://conxillium.github.io/AddressManager/login");

        //Can use below setup if we're not using local chromedrivers

//        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        DriverInit.Driver = new ChromeDriver(chromeOptions);
//        DriverInit.Driver.get("https://conxillium.github.io/AddressManager/login");

    }

    @After
    public void afterScenario(Scenario sc) {
        boolean failed = sc.isFailed();
        System.out.println("is Failed? " + failed);
        if (!failed) {
            TakesScreenshot ts = (TakesScreenshot) DriverInit.Driver;
            byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshotAs, "image/png", "My test");
            DriverInit.Driver.close();
        } else {

            TakesScreenshot ts = (TakesScreenshot) DriverInit.Driver;
            byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshotAs, "image/png", "Screenshot attached");
            DriverInit.Driver.close();

        }
    }

}
