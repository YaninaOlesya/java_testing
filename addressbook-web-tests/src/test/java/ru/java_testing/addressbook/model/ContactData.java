package ru.java_testing.addressbook.model;

public class ContactData {
    private int id;
    private final String first_name;
    private final String last_name;
    private final String nickname;
    private final String title;
    private final String home_phone;
    private final String email;
    private String group;

    public ContactData(String first_name, String last_name, String nickname, String title, String home_phone, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.title = title;
        this.home_phone = home_phone;
        this.email = email;
        this.group = group;
    }
    public ContactData(int id, String first_name, String last_name, String nickname, String title, String home_phone, String email, String group) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.title = title;
        this.home_phone = home_phone;
        this.email = email;
        this.group = group;
    }

    public int getId() {

        return id;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
        return last_name != null ? last_name.equals(that.last_name) : that.last_name == null;

    }

    @Override
    public int hashCode() {
        int result = first_name != null ? first_name.hashCode() : 0;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        return result;
    }
}
