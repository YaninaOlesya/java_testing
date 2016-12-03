package ru.java_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData("test_name", "test_surname", "test_nickname", "test_title", "test_phone", "test_email", "test1");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
