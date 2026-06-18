package io.github.tamar.bunturi.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private WebDriver driver;

    public void startDriver (){
        driver = new ChromeDriver();
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
