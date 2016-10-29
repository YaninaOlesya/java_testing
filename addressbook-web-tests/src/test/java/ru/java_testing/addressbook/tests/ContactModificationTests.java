package ru.java_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

/**
 * Created by Олеся on 29.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test123", "test2", "test3", "test4", "test5", "test6"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

    }
}
