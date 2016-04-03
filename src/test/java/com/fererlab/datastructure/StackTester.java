package com.fererlab.datastructure;

import com.fererlab.datastructure.iterator.Iterator;
import com.fererlab.datastructure.pojos.PhoneNumber;
import com.fererlab.datastructure.pojos.User;
import com.fererlab.datastructure.stack.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class StackTester {

    // testing value
    private final String testValueOne = "Value One";
    private final String testValueTwo = "Value Two";
    private final String testValueThree = "Value Three";
    private final String testValueFour = "Value Four";
    private final String testValueFive = "Value Five";
    private final String testValueSix = "Value Six";

    private Stack<String> stack;

    @Before
    public void prepare() {
        // create stack
        stack = new Stack<>();
    }

    @Test
    public void zeroSizeTest() {
        // initial size should be zero
        Assert.assertEquals(stack.getSize(), 0);
    }

    @Test
    public void addRemoveValueTest() throws Exception {
        // push value
        stack.push(testValueOne);
        Assert.assertEquals(stack.getSize(), 1);

        // should contain test value
        Assert.assertTrue(stack.contains(testValueOne));

        // first one should be our value
        Assert.assertEquals(stack.peek().orElseThrow(new RuntimeException("no value found")), testValueOne);

        // after remove size should be 0
        stack.remove();
        Assert.assertEquals(stack.getSize(), 0);
    }

    @Test
    public void clearTest() {

        // after adding size should increase by one
        stack.push(testValueOne);
        Assert.assertEquals(stack.getSize(), 1);
        stack.push(testValueTwo);
        Assert.assertEquals(stack.getSize(), 2);
        stack.push(testValueThree);
        Assert.assertEquals(stack.getSize(), 3);
        stack.push(testValueFour);
        Assert.assertEquals(stack.getSize(), 4);
        stack.push(testValueFive);
        Assert.assertEquals(stack.getSize(), 5);
        stack.push(testValueSix);
        Assert.assertEquals(stack.getSize(), 6);

        // after clear size should be 0
        stack.clear();
        Assert.assertEquals(stack.getSize(), 0);

    }

    @Test
    public void removeOutOfIndexTest() {

        // after adding size should increase by one
        stack.push(testValueOne);
        Assert.assertEquals(stack.getSize(), 1);
        stack.push(testValueTwo);
        Assert.assertEquals(stack.getSize(), 2);
        stack.push(testValueThree);
        Assert.assertEquals(stack.getSize(), 3);
        stack.push(testValueFour);
        Assert.assertEquals(stack.getSize(), 4);
        stack.push(testValueFive);
        Assert.assertEquals(stack.getSize(), 5);
        stack.push(testValueSix);
        Assert.assertEquals(stack.getSize(), 6);

        // print all values
        stack.forEach(System.out::println);

        // remove index greater than zero, this should NOT raise an exception!!!
        stack.remove(99);

    }

    @Test
    public void removeOneValueTest() {

        // after adding size should increase by one
        stack.push(testValueOne);
        Assert.assertEquals(stack.getSize(), 1);
        stack.push(testValueTwo);
        Assert.assertEquals(stack.getSize(), 2);
        stack.push(testValueThree);
        Assert.assertEquals(stack.getSize(), 3);
        stack.push(testValueFour);
        Assert.assertEquals(stack.getSize(), 4);
        stack.push(testValueFive);
        Assert.assertEquals(stack.getSize(), 5);
        stack.push(testValueSix);
        Assert.assertEquals(stack.getSize(), 6);

        // get initial size
        int initialSize = stack.getSize();

        // get iterator and remove one value
        Iterator<String> iterator = stack.iterator();
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
        Assert.assertEquals(stack.getSize(), initialSize - 1);
    }

    @Test
    public void removeAllValuesTest() {

        // after adding size should increase by one
        stack.push(testValueOne);
        Assert.assertEquals(stack.getSize(), 1);
        stack.push(testValueTwo);
        Assert.assertEquals(stack.getSize(), 2);
        stack.push(testValueThree);
        Assert.assertEquals(stack.getSize(), 3);
        stack.push(testValueFour);
        Assert.assertEquals(stack.getSize(), 4);
        stack.push(testValueFive);
        Assert.assertEquals(stack.getSize(), 5);
        stack.push(testValueSix);
        Assert.assertEquals(stack.getSize(), 6);

        // get iterator and remove all values
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println("removing value = " + value);
            iterator.remove();
        }
        // after removing only all values, size should be 0
        Assert.assertEquals(stack.getSize(), 0);
    }

    @Test
    public void complexTypeIteratorTest() {

        Stack<User> stack = new Stack<>();

        User user = new User("one", new Date(), 11);
        user.getPhoneNumbers().add(new PhoneNumber(1, 1, 111, 1));
        stack.push(user);

        user = new User("two", new Date(), 22);
        user.getPhoneNumbers().add(new PhoneNumber(2, 2, 222, 2));
        stack.push(user);

        user = new User("three", new Date(), 33);
        user.getPhoneNumbers().add(new PhoneNumber(3, 3, 333, 3));
        stack.push(user);

        user = new User("four", new Date(), 44);
        user.getPhoneNumbers().add(new PhoneNumber(4, 4, 444, 4));
        stack.push(user);

        user = new User("five", new Date(), 55);
        user.getPhoneNumbers().add(new PhoneNumber(5, 5, 555, 5));
        stack.push(user);

        // get iterator and remove all values
        Iterator<User> iterator = stack.iterator();
        while (iterator.hasNext()) {
            User value = iterator.next();
            System.out.println("removing user = " + value.getUsername());
            iterator.remove();
        }
        // after removing only all values, size should be 0
        Assert.assertEquals(stack.getSize(), 0);
    }

    @Test
    public void postFixCalculatorTest() {
        /**
         * for each token
         *      if token is integer
         *          push token to stack
         *      else if token is an operation
         *          get and remove (pop) right side value
         *          get and remove (pop) left side value
         *          evaluate operation
         *          push result back
         * next
         *
         *  5 + 6 * 7 - 1
         *  5 6 7 * + 1 -
         */
        Stack<Integer> stack = new Stack<>();

        Object[] tokens = new Object[]{5, 6, 7, "*", "+", 1, "-"};
        for (Object token : tokens) {
            if (token instanceof Integer) {
                Integer currentNumber = (Integer) token;
                stack.push(currentNumber);
            } else {

                Integer rightSideValue = stack.peek().get();
                stack.remove();

                Integer leftSideValue = stack.peek().get();
                stack.remove();

                Integer result = null;
                switch (String.valueOf(token)) {
                    case "*":
                        result = leftSideValue * rightSideValue;
                        break;
                    case "/":
                        result = leftSideValue / rightSideValue;
                        break;
                    case "+":
                        result = leftSideValue + rightSideValue;
                        break;
                    case "-":
                        result = leftSideValue - rightSideValue;
                        break;
                }
                stack.push(result);
            }
        }
        Assert.assertEquals(stack.getSize(), 1);
        Assert.assertNotNull(stack.peek().get());
        System.out.println("calculation= " + Arrays.toString(tokens));
        System.out.println("result = " + stack.peek().get());
    }

}
