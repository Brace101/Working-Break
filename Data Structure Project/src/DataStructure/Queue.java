package DataStructure;

import java.util.NoSuchElementException;

public class Queue {
    private final String [] element = new String[3];
    private int size;
    private int rear;
    private int tail;
    private int front;

    public boolean add(Object item) {
        if(item == null){
            throw new NullPointerException();
        }
        if(!(item instanceof String value)){
            throw new IllegalArgumentException("invalid queue element");
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException("Blank values not allowed");
        }
        if(size == element.length) {
            throw new IllegalStateException("queue is unchanged");
        }
        element[rear]= value;
        rear++;
        size++;
        return true;
    }


    public boolean offer(Object item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if(!(item instanceof String value)) {
            throw new ClassCastException();
        }
        if(size == element.length){
            return false;
        }
        element[tail] = value;
        tail++;
        size++;
        return true;
    }

    public String remove(String item) {
        if(size==0){
            throw new NoSuchElementException();
        }
        String removedItem = element[0];
        for(int index = 0; index < size-1; index++){
            element[index] = element[index + 1];
        }
        element[size -1]=null;
        rear--;
        size--;
        return removedItem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String poll() {
        if(size == 0){
            return null;
        }
        String removeElement =element[front];
        front++;
        size--;
        return removeElement;

    }

    public int getSize() {
        return size;
    }
}
