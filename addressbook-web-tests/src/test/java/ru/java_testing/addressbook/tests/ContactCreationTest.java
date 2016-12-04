package ru.java_testing.addressbook.tests;

import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;
import ru.java_testing.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirst_name("test_name").withLast_name("test_surname").withNickname("test_nickname")
                .withTitle("test_title").withHome_phone("test_phone").withEmail("test_email").withGroup("test1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
