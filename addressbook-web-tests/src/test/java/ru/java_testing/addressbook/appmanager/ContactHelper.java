package ru.java_testing.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.java_testing.addressbook.model.ContactData;

/**
 * Created by Олеся on 29.10.2016.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirst_name());
        type(By.name("lastname"), contactData.getLast_name());
        type(By.name("nickname"), contactData.getNikname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("home"), contactData.getHome_phone());
        type(By.name("email"), contactData.getEmail());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }
}
