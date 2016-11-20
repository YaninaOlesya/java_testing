package ru.java_testing.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java_testing.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Олеся on 29.10.2016.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isTheheAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test123", "test2", "test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
