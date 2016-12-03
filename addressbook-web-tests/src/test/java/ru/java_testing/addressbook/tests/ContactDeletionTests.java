package ru.java_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Олеся on 29.10.2016.
 */
public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData("test_name", "test_surname", "test_nickname", "test_title", "test_phone", "test_email", "test1"));
        }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

}
