package ru.java_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

/**
 * Created by Олеся on 29.10.2016.
 */
public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test_name", "test_surname", "test_nickname", "test_title", "test_phone", "test_email", "test1"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().returnToHomePage();
    }
}
