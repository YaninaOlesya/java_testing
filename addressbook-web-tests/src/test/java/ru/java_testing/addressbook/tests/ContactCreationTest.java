package ru.java_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        app.initContactCreation();
        app.fillContactForm(new ContactData("test1", "test2", "test3", "test4", "test5", "test6"));
        app.submitContactCreation();
        app.returnToHomePage();
    }

}
