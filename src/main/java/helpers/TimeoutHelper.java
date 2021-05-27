package helpers;

public class TimeoutHelper {
    public static void waitTime(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }
}
