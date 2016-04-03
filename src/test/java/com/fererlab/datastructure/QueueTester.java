package com.fererlab.datastructure;

import com.fererlab.datastructure.iterator.Iterator;
import com.fererlab.datastructure.pojos.PhoneNumber;
import com.fererlab.datastructure.pojos.User;
import com.fererlab.datastructure.queue.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class QueueTester {

    // testing value
    private final String testValueOne = "Value One";
    private final String testValueTwo = "Value Two";
    private final String testValueThree = "Value Three";
    private final String testValueFour = "Value Four";
    private final String testValueFive = "Value Five";

    private Queue<String> queue;

    @Before
    public void prepare() {
        // create queue
        queue = new Queue<>();
    }

    @Test
    public void zeroSizeTest() {
        // initial size should be zero
        Assert.assertEquals(queue.getSize(), 0);
    }

    @Test
    public void addRemoveValueTest() throws Exception {
        // push value
        queue.add(testValueOne);
        Assert.assertEquals(queue.getSize(), 1);

        // should contain test value
        Assert.assertTrue(queue.contains(testValueOne));

        // first one should be our value
        Assert.assertEquals(queue.peek().orElseThrow(new RuntimeException("no value found")), testValueOne);

        // after remove size should be 0
        queue.remove();
        Assert.assertEquals(queue.getSize(), 0);
    }

    @Test
    public void clearTest() {

        // after adding size should increase by one
        queue.add(testValueOne);
        Assert.assertEquals(queue.getSize(), 1);
        queue.add(testValueTwo);
        Assert.assertEquals(queue.getSize(), 2);
        queue.add(testValueThree);
        Assert.assertEquals(queue.getSize(), 3);
        queue.add(testValueFour);
        Assert.assertEquals(queue.getSize(), 4);
        queue.add(testValueFive);
        Assert.assertEquals(queue.getSize(), 5);

        queue.forEach(System.out::println);

        // after clear size should be 0
        queue.clear();
        Assert.assertEquals(queue.getSize(), 0);

    }

    @Test
    public void removeOutOfIndexTest() {

        // after adding size should increase by one
        queue.add(testValueOne);
        Assert.assertEquals(queue.getSize(), 1);
        queue.add(testValueTwo);
        Assert.assertEquals(queue.getSize(), 2);
        queue.add(testValueThree);
        Assert.assertEquals(queue.getSize(), 3);
        queue.add(testValueFour);
        Assert.assertEquals(queue.getSize(), 4);
        queue.add(testValueFive);
        Assert.assertEquals(queue.getSize(), 5);

        // print all values
        queue.forEach(System.out::println);

        // remove index greater than zero, this should NOT raise an exception!!!
        queue.remove(99);

    }

    @Test
    public void removeOneValueTest() {

        // after adding size should increase by one
        queue.add(testValueOne);
        Assert.assertEquals(queue.getSize(), 1);
        queue.add(testValueTwo);
        Assert.assertEquals(queue.getSize(), 2);
        queue.add(testValueThree);
        Assert.assertEquals(queue.getSize(), 3);
        queue.add(testValueFour);
        Assert.assertEquals(queue.getSize(), 4);
        queue.add(testValueFive);
        Assert.assertEquals(queue.getSize(), 5);

        // get initial size
        int initialSize = queue.getSize();

        // get iterator and remove one value
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (testValueOne.equals(value) || testValueTwo.equals(value)) {
                iterator.remove();
                System.out.println("removed = " + value);
            } else {
                System.out.println("preserved = " + value);
            }
        }
        // after removing only one value, check size
        Assert.assertEquals(queue.getSize(), initialSize - 2);
    }

    @Test
    public void removeAllValuesTest() {

        // after adding size should increase by one
        queue.add(testValueOne);
        Assert.assertEquals(queue.getSize(), 1);
        queue.add(testValueTwo);
        Assert.assertEquals(queue.getSize(), 2);
        queue.add(testValueThree);
        Assert.assertEquals(queue.getSize(), 3);
        queue.add(testValueFour);
        Assert.assertEquals(queue.getSize(), 4);
        queue.add(testValueFive);
        Assert.assertEquals(queue.getSize(), 5);

        // get iterator and remove all values
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println("removing value = " + value);
            iterator.remove();
        }
        // after removing only all values, size should be 0
        Assert.assertEquals(queue.getSize(), 0);
    }

    @Test
    public void complexTypeIteratorTest() {

        Queue<User> queue = new Queue<>();

        User user = new User("one", new Date(), 11);
        user.getPhoneNumbers().add(new PhoneNumber(1, 1, 111, 1));
        queue.add(user);

        user = new User("two", new Date(), 22);
        user.getPhoneNumbers().add(new PhoneNumber(2, 2, 222, 2));
        queue.add(user);

        user = new User("three", new Date(), 33);
        user.getPhoneNumbers().add(new PhoneNumber(3, 3, 333, 3));
        queue.add(user);

        user = new User("four", new Date(), 44);
        user.getPhoneNumbers().add(new PhoneNumber(4, 4, 444, 4));
        queue.add(user);

        user = new User("five", new Date(), 55);
        user.getPhoneNumbers().add(new PhoneNumber(5, 5, 555, 5));
        queue.add(user);

        // get iterator and remove all values
        Iterator<User> iterator = queue.iterator();
        while (iterator.hasNext()) {
            User value = iterator.next();
            System.out.println("removing user = " + value.getUsername());
            iterator.remove();
        }
        // after removing only all values, size should be 0
        Assert.assertEquals(queue.getSize(), 0);
    }

}
