package com.appium.demo;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class GeneralStoreTest extends BaseTests{

    @Test
    public void LoginTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")))
                .sendKeys("thoa nguyen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/text1")))
                .click();
        driver.findElement(AppiumBy
                        .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"))"))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")))
                .click();
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")))
                .getText();
        Assert.assertEquals(title, "Products");
    }
    @Test
    public void LoginFailedTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/text1")))
                .click();
        driver.findElement(AppiumBy
                        .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"))"))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")))
                .click();
        WebElement toast = driver.findElement(AppiumBy.xpath("//android.widget.Toast"));
        String errorMessage = toast.getAttribute("name");
        Assert.assertEquals(errorMessage, "Please enter your name");

    }
    @Test
    public void AddToCartTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")))
                .sendKeys("thoa nguyen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/text1")))
                .click();
        driver.findElement(AppiumBy
                        .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"))"))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")));
        driver.findElement(AppiumBy
                        .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
        int productCount = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).size();
        for(int i=0; i<productCount; i++){
            String productName = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).get(i).click();
            }
        }
        String totalItemInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/counterText"))).getText();
        Assert.assertEquals(totalItemInCart,"1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"))).click();
        String titleCart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"))).getText();
        Assert.assertEquals(titleCart,"Cart");
        String productNameInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']"))).getText();
        Assert.assertEquals(productNameInCart,"Jordan 6 Rings");
    }
    @Test
    public void TotalAmountTest(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")))
                    .sendKeys("thoa nguyen");
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")))
                    .click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/text1")))
                    .click();
            driver.findElement(AppiumBy
                            .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"))"))
                    .click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")))
                    .click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")))
                    .click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")))
                    .click();
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")))
                    .click();
        int totalProducts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]"))).size();
            double Sum =0;
            for (int i=0; i<totalProducts; i++){
                String price = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]")).get(i).getText();
                price = price.substring(1);
                Sum += Double.parseDouble(price);
            }
            String purchaseAmount = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
            Double totalPurchaseAmount = Double.parseDouble(purchaseAmount.substring(2));
            Assert.assertEquals(totalPurchaseAmount,Sum);
    }
    @Test
    public void TermAndConditionsTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")))
                .sendKeys("thoa nguyen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/text1")))
                .click();
        driver.findElement(AppiumBy
                        .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"))"))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")))
                .click();
        WebElement termBtn = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/termsButton")));
        LongPressAction(termBtn);
        WebElement alertTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/alertTitle")));
        Assert.assertTrue(alertTitle.isDisplayed());
        Assert.assertEquals(alertTitle.getText(), "Terms Of Conditions");

    }
    @Test
    public void VisitWebSiteTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")))
                .sendKeys("thoa nguyen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/text1")))
                .click();
        driver.findElement(AppiumBy
                        .androidUIAutomator("new UiScrollable(UiSelector()).scrollIntoView(text(\"Aruba\"))"))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.CheckBox"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"))).click();
        wait.until(d->{
                // debug (có thể bỏ)
                Set < String > contexts = driver.getContextHandles();
                System.out.println("Contexts now: " + contexts);
                return contexts.stream().anyMatch(c -> c.toLowerCase().contains("webview"));
        });
        Set<String> contexts = driver.getContextHandles();
        for(String context : contexts) {
            if(context.toLowerCase().contains("webview")) {
                driver.context(context);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("appium automation");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");

    }

}
