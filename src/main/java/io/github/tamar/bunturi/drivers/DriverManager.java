package io.github.tamar.bunturi.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private WebDriver driver;

    public void startDriver (String browser){
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else{
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
