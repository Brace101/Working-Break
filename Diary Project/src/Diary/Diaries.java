package Diary;

import java.util.ArrayList;
import java.util.List;

public class Diaries {

    private List<Diary> diaries = new ArrayList<>();

    public void add(String username, String password) {

        if (findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        Diary diary = new Diary(username, password);

        diaries.add(diary);
    }

    public Diary findByUsername(String username) {

        for (Diary diary : diaries) {

            if (diary.getUsername().equals(username)) {
                return diary;
            }
        }

        return null;
    }

    public void delete(String username, String password) {

        Diary diary = findByUsername(username);

        if (diary != null) {

            diary.unlockDiary(password);

            if (!diary.isLocked()) {
                diaries.remove(diary);
            }
        }
    }

    public List<Diary> getDiaries() {
        return diaries;
    }
}