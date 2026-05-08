package DataStructure;

import java.util.EmptyStackException;

public class Stack {

    int[] numbers = new int[10];
    int counter = 0;

    public boolean empty() {
        return counter == 0;
    }

    public int push(int number) {
        numbers[counter++] = number;
        return number;
    }


    public int pop() {
        if (counter == 0) throw new EmptyStackException();
        int value = numbers[counter-1];
        numbers[--counter] = 0;
        return value;
    }

    public int peek() {
        if (counter == 0) throw new EmptyStackException();
        return numbers[counter];

    }

    public int search() {
        if (counter == 0) return -1;
        return 0;
    }
}

