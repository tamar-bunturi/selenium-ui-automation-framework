package io.github.tamar.bunturi.tests;

import io.github.tamar.bunturi.config.ConfigReader;
import io.github.tamar.bunturi.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader config;
    private DriverManager driverManager;

    @BeforeMethod
    public void setUp(){
        config = new ConfigReader();
        driverManager = new DriverManager();
        driverManager.startDriver();
        driver = driverManager.getDriver();
        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
