package ru.java_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirst_name("test_name").withLast_name("test_surname").withNickname("test_nickname")
                .withTitle("test_title").withHome_phone("test_phone").withEmail("test_email").withGroup("test1");
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
