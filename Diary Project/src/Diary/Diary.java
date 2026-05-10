package Diary;

import java.util.ArrayList;
import java.util.List;

public class Diary {

    private String username;
    private String password;
    private boolean isLocked = true;
    private List<Entry> entries = new ArrayList<>();
    private int entryCounter = 0;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void unlockDiary(String password) {

        if (!this.password.equals(password)) {
            throw new IllegalArgumentException("Incorrect Password");
        }

        isLocked = false;
    }

    public void lockDiary() {
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void createEntry(String title, String body) {

        if (isLocked) {
            throw new IllegalStateException("Diary is locked");
        }

        entryCounter++;

        Entry entry = new Entry(entryCounter, title, body);

        entries.add(entry);
    }

    public void deleteEntry(int id) {

        if (isLocked) {
            throw new IllegalStateException("Diary is locked");
        }

        Entry entry = findEntryById(id);

        if (entry != null) {
            entries.remove(entry);
        }
    }

    public Entry findEntryById(int id) {

        if (isLocked) {
            throw new IllegalStateException("Diary is locked");
        }

        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }

        return null;
    }

    public void updateEntry(int id, String newBody) {

        if (isLocked) {
            throw new IllegalStateException("Diary is locked");
        }

        Entry entry = findEntryById(id);

        if (entry != null) {
            entry.setBody(newBody);
        }
    }

    public String getUsername() {
        return username;
    }

    public List<Entry> getEntries() {

        if (isLocked) {
            throw new IllegalStateException("Diary is locked");
        }

        return entries;
    }
}