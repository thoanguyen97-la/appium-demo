package com.appium.demo;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class IOSBasicTests extends IOSBaseTests{
    //xpath,id,accessibilityId, iosclasschain,iOSNsPredicateString
    @Test
    public void IOSDemoTest() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Alert Views"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label=='Text Entry'`]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell")))
                .sendKeys("Hello world!");
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND label BEGINSWITH[c] 'Confirm'"))).click();
        String alterMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND label BEGINSWITH[c] 'A message'"))).getText();
        System.out.println(alterMessage);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Confirm"))).click();


    }
    @Test
    public void StepperTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Steppers"))).click();
        WebElement incrementEle = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]")));
        TouchAndHoldAction(incrementEle,5);
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == '10'`]"))).getText();
        System.out.println(value);
        Assert.assertEquals(value,"10");
    }
    @Test
    public void WebViewTest(){
        WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Web View")));
        ScrollAction(ele,"down");
        ele.click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("BackButton"))).click();
    }
    @Test
    public void PickerView(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Picker View"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == 'Red color component value'`]"))).sendKeys("105");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == 'Green color component value'`]"))).sendKeys("250");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == 'Blue color component value'`]"))).sendKeys("300");
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`name == 'Green color component value'`]"))).getText();
        System.out.println(value);
        Assert.assertEquals(value,"250");


    }
}
