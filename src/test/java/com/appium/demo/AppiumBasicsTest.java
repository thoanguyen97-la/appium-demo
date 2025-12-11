package com.appium.demo;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasicsTest extends BaseTests{
    @Test
    public void WifiSettingNameTest(){

        //actual automation here
        //xpath,id,assessibility id, className, uiAutomator
        //tagName[@attribute= value]
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Thoawifi");
        driver.findElement(AppiumBy.id("android:id/button1")).click();



    }
}
