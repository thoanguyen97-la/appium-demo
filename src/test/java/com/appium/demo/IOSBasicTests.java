package com.appium.demo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
