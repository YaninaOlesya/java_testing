package ru.java_testing.addressbook.appmanager;

import org.openqa.selenium.*;

/**
 * Created by Олеся on 29.10.2016.
 */
public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! existingText.equals(text)) {
                WebElement element = wd.findElement(locator);
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    protected void accept() {
        wd.switchTo().alert().accept();
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return  true;
        } catch (NoSuchElementException ex) {
            return  false;
        }
    }
}
