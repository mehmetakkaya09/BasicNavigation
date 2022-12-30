package com.cydeo.tests;

import com.cydeo.utilities.BrowserFactory;
import com.cydeo.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigationTests {
    public static void main(String[] args) {
        browserType("chrome");
        browserType("edge");
        browserType("firefox");
    }

    public static void browserType(String browser) {
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = BrowserFactory.getDriver("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = BrowserFactory.getDriver("firefox");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = BrowserFactory.getDriver("edge");
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = BrowserFactory.getDriver("safari");
        }

        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String googleTitle1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle1 = driver.getTitle();
        driver.navigate().back();
        String googleTitle2 = driver.getTitle();
        StringUtility.verifyEquals(googleTitle1,googleTitle2);
        driver.navigate().forward();
        String etsyTitle2 = driver.getTitle();
        StringUtility.verifyEquals(etsyTitle1,etsyTitle2);
        driver.close();

    }

}
