package utils;

import java.util.concurrent.TimeUnit;

public class Time {

    public static boolean havePassed(int seconds, long from){
        long now = System.nanoTime();
        return  havePassed(seconds, from, now);
    }

    public static boolean havePassed(int seconds, long from, long to){
        long passedTime = to - from;
        long nanoSeconds = TimeUnit.NANOSECONDS.convert(seconds, TimeUnit.SECONDS);
        return passedTime > nanoSeconds;
    }
}
