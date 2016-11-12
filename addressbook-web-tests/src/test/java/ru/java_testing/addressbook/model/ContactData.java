package ru.java_testing.addressbook.model;

public class ContactData {
    private final String first_name;
    private final String last_name;
    private final String nickname;
    private final String title;
    private final String home_phone;
    private final String email;
    private String group;

    public ContactData(String first_name, String last_name, String nickname, String title, String home_phone, String email, String group) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.title = title;
        this.home_phone = home_phone;
        this.email = email;
        this.group = group;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNickname() {
        return nickname;
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

    public String getGroup() {
        return group;
    }
}
