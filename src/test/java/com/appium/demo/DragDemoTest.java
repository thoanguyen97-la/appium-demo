package com.appium.demo;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDemoTest extends BaseTests{
    @Test
    public void DragAndDropTest(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));
        DragAction(source, 659,587);
        String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/drag_result_text\"]")).getText();
        Assert.assertEquals(result,"Dropped!");




    }
}
