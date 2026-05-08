package DataStructure;

import java.util.ArrayList;

public class MySet {

    private ArrayList<Object> myList;

    public MySet() {
        myList = new ArrayList<>();
    }

    public int size() {
        return myList.size();
    }

    public boolean isEmpty() {
        return myList.isEmpty();
    }

    public boolean contains(Object element) {
        for (Object value : myList) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(Object element) {
        if (!contains(element)) {
            myList.add(element);
        }
    }

    public void remove(Object element) {
        if (contains(element)) {
            myList.remove(element);
        } else {
            throw new IllegalArgumentException("Element not found");
        }
    }

    public int union(MySet anotherSet) {
        ArrayList<Object> newList = new ArrayList<>(myList);

        for (Object value : anotherSet.myList) {
            if (!newList.contains(value)) {
                newList.add(value);
            }
        }

        return newList.size();
    }

    public int intersection(MySet anotherSet) {
        ArrayList<Object> newList = new ArrayList<>();

        for (Object value : anotherSet.myList) {
            if (contains(value)) {
                newList.add(value);
            }
        }

        return newList.size();
    }
}
