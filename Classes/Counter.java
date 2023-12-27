package Classes;

public class Counter {
    private static Integer counter = 0;

    public static Integer add() {
        counter++;
        return counter;
    }
}
