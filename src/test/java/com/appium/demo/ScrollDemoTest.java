package com.appium.demo;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;


public class ScrollDemoTest extends BaseTests{
    @Test
    public void ScrollViewTest() throws InterruptedException {
//     when know the exact prior
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        String ele = "WebView";
        ScrollToElementAction(ele);

//      when no have any prior
       ScrollToEndAction();


    }
}
