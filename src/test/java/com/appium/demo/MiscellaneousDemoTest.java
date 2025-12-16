package com.appium.demo;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscellaneousDemoTest extends BaseTests{
    @Test
    public void MiscellaneousTest(){

        //actual automation here
        //xpath,id,assessibility id, className, uiAutomator
        //tagName[@attribute= value]
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
     //   driver.rotate(ScreenOrientation.LANDSCAPE);
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Thoawifi");
        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));




    }
}
