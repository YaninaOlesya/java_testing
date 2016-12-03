package ru.java_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Олеся on 29.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirst_name("test_name").withLast_name("test_surname").withNickname("test_nickname")
                    .withTitle("test_title").withHome_phone("test_phone").withEmail("test_email").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirst_name("test_name123").withLast_name("test_surname")
                .withNickname("test_nickname").withTitle("test_title").withHome_phone("test_phone").withEmail("test_email");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);

    }

}
