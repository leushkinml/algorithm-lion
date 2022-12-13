package com.skypro.algorithmlion.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringListImplTest {

    private StringListImpl expected;
    private String[] array;
    String string1 = "String 1";
    String string2 = "String 2";
    String string3 = "String 3";
    String string4 = "String 4";


    @BeforeEach
    public void setUp() {
        expected = new StringListImpl(10);
        expected.addByItem(string1);
        expected.addByItem(string2);
        expected.addByItem(string3);
        expected.addByItem(string4);

        array = new String[10];
        array[0] = "String 1";
        array[1] = "String 2";
        array[2] = "String 3";
        array[3] = "String 4";
    }

    @Test // addByItem
    void testAddItem() {
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test // addByIndex
    void testAddItemByIndex() {
        expected.addByIndex(1, "test");
        array[1] = "test";
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test   //  set
    void testSet() {
        expected.set(1, "test");
        array[1] = "test";
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test   // remove
    void testRemove() {
        expected.remove("String 2");
        array[0] = "String 1";
        array[1] = "String 3";
        array[2] = "String 4";
        array[3] = null;
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test    // removeByIndex
    void testRemoveByIndex() {
        expected.removeByIndex(1);
        array[0] = "String 1";
        array[1] = "String 3";
        array[2] = "String 4";
        array[3] = null;
        Assertions.assertArrayEquals(array, expected.toArray());
    }

    @Test
    void contains() {
        Assertions.assertTrue(expected.contains("String 2"));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals((expected.indexOf("String 2")), 1);
    }

    @Test
    void lastIndexOf() {
        Assertions.assertEquals((expected.indexOf("String 2")), 1);
    }

    @Test
    void get() {
        String getTest = expected.get(1);
        String actual = "String 2";
        Assertions.assertEquals(getTest, actual);
    }

    @Test
    void testEquals() {
        StringListImpl actual = new StringListImpl(10);
        actual.addByItem(string1);
        actual.addByItem(string2);
        actual.addByItem(string3);
        actual.addByItem(string4);;
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    void size() {
        int sizeExpected = expected.size();
        int sizeActual = 4;
        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test
    void isEmpty() {
        StringListImpl isEmpty = new StringListImpl(10);
        int sizeExpected = isEmpty.size();
        int sizeActual = 0;
        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test
    void clear() {
        expected.clear();
        int sizeExpected = expected.size();
        int sizeActual = 0;
        Assertions.assertEquals(sizeExpected, sizeActual);
    }

    @Test // toArray
    void testToArray() {
        String[] expectedCopy = expected.toArray();
        Assertions.assertArrayEquals(array, expectedCopy);
    }
}