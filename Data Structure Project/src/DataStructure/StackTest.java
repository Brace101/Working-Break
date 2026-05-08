package DataStructure;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void testListIsEmpty(){
        Stack stack = new Stack();
        assertTrue(stack.empty());
    }

    @Test
    public void testListToAddItem(){
        Stack stack = new Stack();
        assertEquals(5, stack.push(5));

    }

    @Test
    public void testListToRemoveItem(){
        Stack stack = new Stack();
        stack.push(5);
        stack.push(9);

        assertEquals(9, stack.pop());

    }
    @Test
    public void testPopWhenStackIsEmpty(){
        Stack stack = new Stack();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testListToPeekItem(){
        Stack stack = new Stack();
        stack.push(5);

    }

    @Test
    public void testListToSearchItem(){
        Stack stack = new Stack();
        stack.search();

    }
}
