package ru.java_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Олеся on 29.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData("test_name", "test_surname", "test_nickname", "test_title", "test_phone", "test_email", "test1"));
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).getId(), "test_name123", "test_surname", "test_nickname", "test_title", "test_phone", "test_email", null);
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
