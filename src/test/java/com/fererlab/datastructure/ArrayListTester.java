package com.fererlab.datastructure;

import com.fererlab.datastructure.iterator.Iterator;
import com.fererlab.datastructure.list.array.ArrayList;
import com.fererlab.datastructure.pojos.PhoneNumber;
import com.fererlab.datastructure.pojos.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class ArrayListTester {

    // testing value
    private final String testValueOne = "Value One";
    private final String testValueTwo = "Value Two";
    private final String testValueThree = "Value Three";
    private final String testValueFour = "Value Four";
    private final String testValueFive = "Value Five";
    private final String testValueSix = "Value Six";

    // linked list reference to test
    private ArrayList<String> list;

    @Before
    public void prepare() {
        // create empty list
        list = new ArrayList<>(3);
    }

    @Test
    public void zeroSizeTest() {
        // initial size should be zero
        Assert.assertEquals(list.getSize(), 0);
    }

    @Test
    public void addRemoveValueTest() throws Exception {
        // add value, list value should be 1
        list.add(testValueOne);
        Assert.assertEquals(list.getSize(), 1);

        // list should contain test value
        Assert.assertTrue(list.contains(testValueOne));

        // first one should be our value
        Assert.assertEquals(list.get(0).orElseThrow(new RuntimeException("no value found at this index")), testValueOne);

        // after remove size should be 0
        list.remove(0);
        Assert.assertEquals(list.getSize(), 0);
    }

    @Test
    public void clearTest() {

        // after adding size should increase by one
        list.add(testValueOne);
        Assert.assertEquals(list.getSize(), 1);
        list.add(testValueTwo);
        Assert.assertEquals(list.getSize(), 2);
        list.add(testValueThree);
        Assert.assertEquals(list.getSize(), 3);
        list.add(testValueFour);
        Assert.assertEquals(list.getSize(), 4);
        list.add(testValueFive);
        Assert.assertEquals(list.getSize(), 5);
        list.add(testValueSix);
        Assert.assertEquals(list.getSize(), 6);

        // after clear size should be 0
        list.clear();
        Assert.assertEquals(list.getSize(), 0);

    }

    @Test
    public void removeOutOfIndexTest() {

        // after adding size should increase by one
        list.add(testValueOne);
        Assert.assertEquals(list.getSize(), 1);
        list.add(testValueTwo);
        Assert.assertEquals(list.getSize(), 2);
        list.add(testValueThree);
        Assert.assertEquals(list.getSize(), 3);
        list.add(testValueFour);
        Assert.assertEquals(list.getSize(), 4);
        list.add(testValueFive);
        Assert.assertEquals(list.getSize(), 5);
        list.add(testValueSix);
        Assert.assertEquals(list.getSize(), 6);

        // print all values
        list.forEach(System.out::println);

        // remove index greater than zero, this should NOT raise an exception!!!
        list.remove(99);

    }

    @Test
    public void removeOneValueTest() {

        // after adding size should increase by one
        list.add(testValueOne);
        Assert.assertEquals(list.getSize(), 1);
        list.add(testValueTwo);
        Assert.assertEquals(list.getSize(), 2);
        list.add(testValueThree);
        Assert.assertEquals(list.getSize(), 3);
        list.add(testValueFour);
        Assert.assertEquals(list.getSize(), 4);
        list.add(testValueFive);
        Assert.assertEquals(list.getSize(), 5);
        list.add(testValueSix);
        Assert.assertEquals(list.getSize(), 6);

        // get initial size
        int initialSize = list.getSize();

        // get iterator and remove one value
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (testValueFour.equals(value)) {
                iterator.remove();
                System.out.println("removed = " + value);
            } else {
                System.out.println("preserved = " + value);
            }
        }
        // after removing only one value, check size
        Assert.assertEquals(list.getSize(), initialSize - 1);
    }

    @Test
    public void removeAllValuesTest() {

        // after adding size should increase by one
        list.add(testValueOne);
        Assert.assertEquals(list.getSize(), 1);
        list.add(testValueTwo);
        Assert.assertEquals(list.getSize(), 2);
        list.add(testValueThree);
        Assert.assertEquals(list.getSize(), 3);
        list.add(testValueFour);
        Assert.assertEquals(list.getSize(), 4);
        list.add(testValueFive);
        Assert.assertEquals(list.getSize(), 5);
        list.add(testValueSix);
        Assert.assertEquals(list.getSize(), 6);

        // get iterator and remove all values
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println("removing value = " + value);
            iterator.remove();
        }
        // after removing only all values, size should be 0
        Assert.assertEquals(list.getSize(), 0);
    }

    @Test
    public void complexTypeIteratorTest() {

        ArrayList<User> list = new ArrayList<>(3);

        User user = new User("one", new Date(), 11);
        user.getPhoneNumbers().add(new PhoneNumber(1, 1, 111, 1));
        list.add(user);

        user = new User("two", new Date(), 22);
        user.getPhoneNumbers().add(new PhoneNumber(2, 2, 222, 2));
        list.add(user);

        user = new User("three", new Date(), 33);
        user.getPhoneNumbers().add(new PhoneNumber(3, 3, 333, 3));
        list.add(user);

        user = new User("four", new Date(), 44);
        user.getPhoneNumbers().add(new PhoneNumber(4, 4, 444, 4));
        list.add(user);

        user = new User("five", new Date(), 55);
        user.getPhoneNumbers().add(new PhoneNumber(5, 5, 555, 5));
        list.add(user);

        // get iterator and remove all values
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User value = iterator.next();
            System.out.println("removing user = " + value.getUsername());
            iterator.remove();
        }
        // after removing only all values, size should be 0
        Assert.assertEquals(list.getSize(), 0);
    }

    @Test
    public void complexTypeReverseIteratorTest() {

        ArrayList<User> list = new ArrayList<>(3);

        User user = new User("one", new Date(), 11);
        user.getPhoneNumbers().add(new PhoneNumber(1, 1, 111, 1));
        list.add(user);

        user = new User("two", new Date(), 22);
        user.getPhoneNumbers().add(new PhoneNumber(2, 2, 222, 2));
        list.add(user);

        user = new User("three", new Date(), 33);
        user.getPhoneNumbers().add(new PhoneNumber(3, 3, 333, 3));
        list.add(user);

        user = new User("four", new Date(), 44);
        user.getPhoneNumbers().add(new PhoneNumber(4, 4, 444, 4));
        list.add(user);

        user = new User("five", new Date(), 55);
        user.getPhoneNumbers().add(new PhoneNumber(5, 5, 555, 5));
        list.add(user);

        // get iterator and remove all values
        Iterator<User> iterator = list.reverseIterator();
        while (iterator.hasNext()) {
            User value = iterator.next();
            System.out.println("removing user = " + value.getUsername());
            iterator.remove();
        }
        // after removing only all values, size should be 0
        Assert.assertEquals(list.getSize(), 0);
    }

}
