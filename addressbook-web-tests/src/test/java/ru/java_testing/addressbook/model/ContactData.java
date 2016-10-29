package ru.java_testing.addressbook.model;

public class ContactData {
    private final String first_name;
    private final String last_name;
    private final String nikname;
    private final String title;
    private final String home_phone;
    private final String email;

    public ContactData(String first_name, String last_name, String nikname, String title, String home_phone, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nikname = nikname;
        this.title = title;
        this.home_phone = home_phone;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNikname() {
        return nikname;
    }

    public String getTitle() {
        return title;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public String getEmail() {
        return email;
    }
}
