public class MainApplication {

    private static Diaries diaries = new Diaries();

    public static void main(String[] args) {

        diaries.add("semicolon", "1234");

        Diary myDiary = diaries.findByUsername("semicolon");

        myDiary.unlockDiary("1234");

        myDiary.createEntry("My First Entry", "Java is interesting");
        myDiary.createEntry("Second Entry", "I am learning OOP");

        for (Entry entry : myDiary.getEntries()) {
            System.out.println(entry);
        }
    }
}