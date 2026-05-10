package Diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {

    private Diaries diaries;

    @BeforeEach
    public void setUp() {
        diaries = new Diaries();
    }

    @Test
    public void testAddDiary() {

        diaries.add("semicolon", "1234");

        assertEquals(1, diaries.getDiaries().size());
    }

    @Test
    public void testFindDiaryByUsername() {

        diaries.add("semicolon", "1234");

        Diary foundDiary = diaries.findByUsername("semicolon");

        assertNotNull(foundDiary);

        assertEquals("semicolon", foundDiary.getUsername());
    }

    @Test
    public void testDeleteDiary() {

        diaries.add("semicolon", "1234");

        diaries.delete("semicolon", "1234");

        assertEquals(0, diaries.getDiaries().size());
    }

    @Test
    public void testCannotAddDuplicateUsername() {

        diaries.add("semicolon", "1234");

        assertThrows(IllegalArgumentException.class, () -> {
            diaries.add("semicolon", "5678");
        });
    }
}