package ru.java_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

import java.util.List;

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
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
