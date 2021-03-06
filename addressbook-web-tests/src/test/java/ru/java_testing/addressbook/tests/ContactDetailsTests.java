package ru.java_testing.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Олеся on 04.12.2016.
 */
public class ContactDetailsTests extends TestBase {

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
    public  void testContactDetails() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        String contactDetailsInfo = app.contact().detailsInfo(contact);

        assertThat(contactDetailsInfo, equalTo(mergeContactInfo(contactInfoFromEditForm)));
    }

    private String mergeContactInfo(ContactData contact) {
        return Arrays.asList(contact.getFirstName(), contact.getLastName(), contact.getNickname(), contact.getTitle(),
                contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
                contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining(""));
    }
}
