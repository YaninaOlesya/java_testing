package ru.java_testing.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Олеся on 03.12.2016.
 */
public class Contacts extends ForwardingSet<ContactData> {

    private  Set<ContactData> delegate;

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<>();
    }

    public Contacts withAdded(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return  contacts;
    }

    public Contacts without(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return  contacts;
    }
}
