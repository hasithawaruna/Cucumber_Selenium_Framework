package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hasitha
 * Project : AutomationProject
 * Date: 8/8/2023
 * Time: 1:19 PM
 */
public class Utilities {

    //We can use below to take screenshots manually
//    public void captureScreenshot(WebDriver driver, String screenshotName) {
//        try {
//            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String filePath = "screenshots/" + screenshotName + ".png";
//            FileUtils.copyFile(screenshotFile, new File(filePath));
//            System.out.println("Screenshot captured: " + filePath);
//        } catch (IOException e) {
//            System.out.println("Error capturing screenshot: " + e.getMessage());
//        }
//    }
}
