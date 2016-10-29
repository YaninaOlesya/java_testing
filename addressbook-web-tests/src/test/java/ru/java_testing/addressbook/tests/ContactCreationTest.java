package ru.java_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("test1", "test2", "test3", "test4", "test5", "test6"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

}
