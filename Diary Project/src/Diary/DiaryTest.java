package Diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private Diary diary;

    @BeforeEach
    public void setUp() {
        diary = new Diary("semicolon", "1234");
    }

    @Test
    public void testDiaryIsLockedByDefault() {
        assertTrue(diary.isLocked());
    }

    @Test
    public void testUnlockDiary() {

        diary.unlockDiary("1234");

        assertFalse(diary.isLocked());
    }

    @Test
    public void testCreateEntry() {

        diary.unlockDiary("1234");

        diary.createEntry("Title", "Body");

        assertEquals(1, diary.getEntries().size());
    }

    @Test
    public void testFindEntryById() {

        diary.unlockDiary("1234");

        diary.createEntry("Title", "Body");

        Entry foundEntry = diary.findEntryById(1);

        assertNotNull(foundEntry);

        assertEquals("Title", foundEntry.getTitle());
    }

    @Test
    public void testDiaryCannotCreateEntryWhenLocked() {

        assertThrows(IllegalStateException.class, () -> {
            diary.createEntry("Title", "Body");
        });
    }

    @Test
    public void testUnlockDiaryWithWrongPasswordThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {
            diary.unlockDiary("0000");
        });
    }
}