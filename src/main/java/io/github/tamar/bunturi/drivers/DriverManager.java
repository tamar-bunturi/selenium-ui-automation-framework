package io.github.tamar.bunturi.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private WebDriver driver;

    public void startDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            // On a CI server there is no screen, so run Chrome headless.
            if (System.getenv("CI") != null) {
                options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
            }
            driver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
    }
    public WebDriver getDriver(){
        return driver;
    }

    public void quitDriver(){
        if(driver!= null){
            driver.quit();
        }
    }
}
