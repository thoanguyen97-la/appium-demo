package com.appium.demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTests {
    AndroidDriver driver;
    //AppiumDriverLocalService service;
    WebDriverWait wait;
    @BeforeMethod
    public void TestConfigure() throws MalformedURLException {

        //AndroidDriver/iOSDriver
        //Appium > Appium server > Mobile
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554"); //emulator
        //options.setChromedriverExecutable("/Users/thoanguyen/chromedriver-mac-arm64/chromedriver");
        options.setCapability("browserName", "Chrome");
        //options.setCapability("appium:chromedriverExecutableDir", "/Users/thoanguyen/appium_chromedrivers");
       // options.setCapability("appium:chromedriverChromeMappingFile", "/Users/thoanguyen/appium_chromedrivers/mapping.json");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void Teardown(){
        driver.quit();
    }
}
