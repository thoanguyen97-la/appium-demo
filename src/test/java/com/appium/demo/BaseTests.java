package com.appium.demo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTests {
    AndroidDriver driver;
    AppiumDriverLocalService service;
    @BeforeClass
    public void TestConfigure() throws MalformedURLException {
        //code start server
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
        //AndroidDriver/iOSDriver
        //Appium > Appium server > Mobile
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554"); //emulator
        options.setApp("/Users/thoanguyen/AppiumDemo/src/test/resources/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void LongPressAction(WebElement ele) throws InterruptedException {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),"duration",2000
        ));
        Thread.sleep(2000);
    }
    @AfterClass
    public void Teardown(){
        driver.quit();
        service.stop();
        //stop server
    }
}
