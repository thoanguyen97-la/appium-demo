package com.appium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTests {
    @Test
    public void BrowserTest() {
        driver.get("https://www.sendo.vn/sendofarm");
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='TP Hồ Chí Minh và lân cận']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sds-dialog")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Close']"))).click();
    }
}
