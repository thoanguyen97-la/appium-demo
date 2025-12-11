package com.appium.demo;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressTest extends BaseTests{
    @Test
    public void LongPressPeopleNameTest() throws InterruptedException {

        //actual automation here
        //xpath,id,assessibility id, className, uiAutomator
        //tagName[@attribute= value]
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        LongPressAction(ele);
        String menuText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());




    }
}
