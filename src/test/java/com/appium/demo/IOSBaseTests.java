package com.appium.demo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
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
    public void LongPressAction(WebElement ele) throws InterruptedException {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),"duration",2000
        ));
        Thread.sleep(2000);
    }
    public void  ScrollToEndAction(){
        Boolean scrollToView;
        do {
            scrollToView = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        }while(scrollToView);
    }
    public void ScrollToElementAction(String ele) throws InterruptedException {
        //     when know the exact prior
        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\""+ele+"\"))"));
        Thread.sleep(2000);
    }
    public void SwipeAction(WebElement  ele, String direction){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.2
        ));
    }
    public void DragAction(WebElement ele,int endX,int endY){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "endX", endX,
                "endY", endY
        ));
    }
    public void GoToAppMenu(){
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
    }
    @AfterMethod
    public void Teardown(){
        driver.quit();
        //stop server
    }
}
