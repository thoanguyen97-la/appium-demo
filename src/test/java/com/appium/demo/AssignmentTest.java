package com.appium.demo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentTest extends BaseTests{
    @Test
    public void DialogWithMessageTest() {
        GoToAppMenu();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/alertTitle")));
        String titleMessage = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(titleMessage,"Lorem ipsum dolor sit aie consectetur adipiscing\n" +
                "Plloaso mako nuto siwuf cakso dodtos anr koop.");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='OK']")).click();
        boolean closed = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(AppiumBy.id("android:id/alertTitle"))
        );
        Assert.assertTrue(closed,"Dialog is not closed!");
    }
    @Test
    public void SingleChoiceTest() {
        GoToAppMenu();
        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((AppiumBy.xpath("//android.widget.CheckedTextView[@text='Satellite']")))).click();

    }
}
