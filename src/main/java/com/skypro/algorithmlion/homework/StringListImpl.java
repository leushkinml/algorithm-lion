package com.skypro.algorithmlion.homework;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] stringSet;

    private int size;

    public StringListImpl() {
        stringSet = new String[10];
    }

    public StringListImpl(int initialSize) {
        stringSet = new String[initialSize];
    }

    private void checkString(String item) {
        if (item == null) {
            throw new NullException();
        }
    }

    private void checkSize() {
        if (size == stringSet.length) {
            throw new SetIsFullException();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new WrongIndexException();
        }
    }

    @Override
    public String addByItem(String item) {
        checkSize();
        checkString(item);
        stringSet[size++] = item;
        return null;
    }

    @Override
    public String addByIndex(int index, String item) {
        checkSize();
        checkString(item);
        checkIndex(index);
        if (index == size) {
            stringSet[size++] = item;
            return item; // - добавили return, чтобы не писать блок else
        }
        System.arraycopy(stringSet, index, stringSet,index+1, size-index);
        stringSet[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkString(item);
        stringSet[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkString(item);
        int index = indexOf(item);

        if (index == -1) {
            throw new ItemNotFoundException();
        }

        if (index != size) {
            System.arraycopy(stringSet, index + 1, stringSet, index, size - index);
        }
        size--;
        return item;

        // цикл можно заменить на return remove(index);
    }

    @Override
    public String removeByIndex(int index) {

        checkIndex(index);

        String item = stringSet[index];

        if (index != size) {
            System.arraycopy(stringSet, index + 1, stringSet, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {

        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String str = stringSet[i];
            if (str.equals(item)) {   //  можно написать if (stringSet[i].equals(item))
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            String str = stringSet[i];
            if (str.equals(item)) {   //  можно написать if (stringSet[i].equals(item))
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return stringSet[index];
    }

    @Override
    public boolean equals(StringList otherList) {

        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringSet, size);
    }


}
