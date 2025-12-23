package com.appium.demo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class IOSBaseTests {
    IOSDriver driver;
    //AppiumDriverLocalService service;
    WebDriverWait wait;
    @BeforeMethod
    public void TestConfigure() throws MalformedURLException {

        //Appium > Webdriver Agent > iOS App
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 17 Pro"); //simulator
        options.setPlatformVersion("26.2");
        options.setApp("/Users/thoanguyen/AppiumDemo/src/test/resources/UIKitCatalog.app");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void TouchAndHoldAction(WebElement ele, int duration){
        driver.executeScript("mobile: touchAndHold", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",duration));
    }
    public void ScrollAction(WebElement ele,String direction){
        Map<String,Object> params = new HashMap<>();
        params.put("direction",direction);
        params.put("elementId",((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll",params);
    }
    @AfterMethod
    public void Teardown(){
        driver.quit();
        //stop server
    }
}
