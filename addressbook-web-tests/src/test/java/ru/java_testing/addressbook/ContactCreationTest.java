package ru.java_testing.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("test1", "test2", "test3", "test4", "test5", "test6"));
        submitContactCreation();
        returnToHomePage();
    }

}
