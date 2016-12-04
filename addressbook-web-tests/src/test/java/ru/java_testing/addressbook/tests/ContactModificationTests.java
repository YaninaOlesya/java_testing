package ru.java_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;
import ru.java_testing.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Олеся on 29.10.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("test_name").withLastName("test_surname")
                    .withNickname("test_nickname").withTitle("test_title").withAddress("test_address")
                    .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
                    .withEmail1("email1").withEmail2("email2").withEmail3("email3"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("test_name123").withLastName("test_surname")
                .withNickname("test_nickname").withTitle("test_title").withAddress("test_address")
                .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
                .withEmail1("email1").withEmail2("email2").withEmail3("email3");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
