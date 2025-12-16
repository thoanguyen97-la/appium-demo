package com.appium.demo;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeImageDemoTest extends BaseTests{
    @Test
    public void SwipeDemoTest() {
//     when know the exact prior
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement image1 = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
        WebElement image2 = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[2]"));
        SwipeAction(image1,"left");
        Assert.assertEquals(image1.getAttribute("focusable"),"false");
        Assert.assertEquals(image2.getAttribute("focusable"),"true");

    }
}
