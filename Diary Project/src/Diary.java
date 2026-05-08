import java.util.ArrayList;
import java.util.List;

public class Diary {

    private String username;
    private String password;
    private boolean isLocked = true;
    private List<Entry> entries = new ArrayList<>();

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void unlockDiary(String password) {
        if (this.password.equals(password)) {
            isLocked = false;
        }
    }

    public void lockDiary() {
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void createEntry(String title, String body) {
        int id = entries.size() + 1;
        Entry entry = new Entry(id, title, body);
        entries.add(entry);
    }

    public void deleteEntry(int id) {
        Entry entry = findEntryById(id);

        if (entry != null) {
            entries.remove(entry);
        }
    }

    public Entry findEntryById(int id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    public void updateEntry(int id, String newBody) {
        Entry entry = findEntryById(id);

        if (entry != null) {
            entry.setBody(newBody);
        }
    }

    public String getUsername() {
        return username;
    }

    public List<Entry> getEntries() {
        return entries;
    }
}