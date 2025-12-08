package com.appium.demo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasicsTest {
    @Test
    public void AppiumTest() throws MalformedURLException {
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554"); //emulator
        options.setApp("/Users/thoanguyen/AppiumDemo/src/test/resources/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        //automation here
        driver.quit();
        service.stop();


    }
}
