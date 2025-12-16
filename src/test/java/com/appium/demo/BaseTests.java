package com.appium.demo;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTests {
    AndroidDriver driver;
    //AppiumDriverLocalService service;
    WebDriverWait wait;
    @BeforeClass
    public void TestConfigure() throws MalformedURLException {
        //code start server
//        service = new AppiumServiceBuilder()
//                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
//                .withIPAddress("127.0.0.1")
//                .usingPort(4723)
//                .build();
//        service.start();
        //AndroidDriver/iOSDriver
        //Appium > Appium server > Mobile
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554"); //emulator
//        options.setApp("/Users/thoanguyen/AppiumDemo/src/test/resources/ApiDemos-debug.apk");
        options.setApp("/Users/thoanguyen/AppiumDemo/src/test/resources/General-Store.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
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
    @AfterClass
    public void Teardown(){
        driver.quit();
        //stop server
    }
}
