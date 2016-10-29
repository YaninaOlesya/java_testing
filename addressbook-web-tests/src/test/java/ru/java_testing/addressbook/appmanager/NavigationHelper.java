package ru.java_testing.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Олеся on 29.10.2016.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }
}
