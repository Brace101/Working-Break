package DataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    private MySet ourSet;

    @BeforeEach
    public void setUp() {
        ourSet = new MySet();
    }

    @Test
    public void testThatANewSetIsEmpty() {
        assertTrue(ourSet.isEmpty());
    }

    @Test
    public void testAddOneElementSetIsNotEmpty() {
        ourSet.add(23);
        assertFalse(ourSet.isEmpty());
    }

    @Test
    public void testSetDoesNotAddDuplicateElement() {
        ourSet.add(23);
        ourSet.add(23);

        assertEquals(1, ourSet.size());
    }

    @Test
    public void testRemoveSetElementSetLengthIsReducedWhenElementIsRemoved() {
        ourSet.add(23);
        ourSet.add(24);

        ourSet.remove(24);

        assertEquals(1, ourSet.size());
    }

    @Test
    public void testRemoveElementRaiseErrorWhenElementNotInSet() {
        ourSet.add(23);

        assertThrows(IllegalArgumentException.class,
                () -> ourSet.remove(24));
    }

    @Test
    public void testUnionOfTwoSetGivesOneSetOfAllElementsContained() {
        ourSet.add(23);
        ourSet.add(24);

        MySet anotherSet = new MySet();
        anotherSet.add(25);
        anotherSet.add(56);

        int expected = ourSet.union(anotherSet);

        assertEquals(4, expected);
    }

    @Test
    public void testIntersectionOfTwoSetGivesOneSetOfCommonElement() {
        ourSet.add(23);
        ourSet.add(24);

        MySet anotherSet = new MySet();
        anotherSet.add(23);
        anotherSet.add(56);

        int expected = ourSet.intersection(anotherSet);

        assertEquals(1, expected);
    }
}
