package DataStructure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }
    @Test
    void queueHasCapacity_WhenAddIsCalledOn(){
        assertTrue(queue.add("10"));
    }
    @Test
    void queueIsFull(){
        assertTrue(queue.add("10"));
        assertTrue(queue.add("20"));
        assertTrue(queue.add("30"));
        assertThrows(IllegalStateException.class,()->queue.add("40"));
    }
    @Test
    void queueRejectsNull(){
        assertThrows(NullPointerException.class,()->{queue.add(null);
        });
    }
    @Test
    void checkIfQueueIsTyped(){
        assertThrows(IllegalArgumentException.class,()->{queue.add(100);
        });
    }
    @Test
    void queueValidatesElements(){
        assertThrows(IllegalArgumentException.class,()->{queue.add(10.5);
        });
    }
    @Test
    void queueHasCallOnOfferWithAValidElement_ItShouldReturnTrue(){
        assertTrue(queue.offer("10"));
    }
    @Test
    void queueIsFull_WhenICallOnOffer_ItShouldReturnFalse(){
        queue.offer("50");
        queue.offer("10");
        queue.offer("wisdom");
        assertFalse(queue.offer("lekan"));
    }
    @Test
    void queueRejectsNull_WhenOfferIsCallOn(){
        assertThrows(NullPointerException.class,()->{queue.offer(null);});
    }
    @Test
    void checksQueueIsTypedWithInCompatibleType(){
        assertThrows(ClassCastException.class,()->{queue.offer(100);});
    }
    @Test
    void queueHasThreeElements_WhenRemoveIsCalledOnItShouldRemoveTheHeadQueueDecreaseByOne(){
        queue.add("10");
        queue.add("20");
        queue.add("wisdom");
        assertNotEquals(3,queue.remove("wisdom"));
    }
    @Test
    void queueIsEmpty_WhenRemoveIsCalledOn_ItShouldThrowException(){
        assertTrue(queue.isEmpty());
        assertThrows(NoSuchElementException.class,()->{queue.remove("39");});
        assertTrue(queue.isEmpty());
    }
    @Test
    void queueHasElement_WhenPollIsCalledOn_ItShouldReturnAndRemoveTheHeadElementAndDecreaseByOne(){
        queue.add("40");
        queue.add("90");
        assertEquals("40", queue.poll());
        assertEquals(1,queue.getSize());
    }
    @Test
    void queueIsEmpty_WhenPollIsCalledOn_ItShouldReturnNull(){
        queue.isEmpty();
        assertNull(queue.poll());
    }

}
