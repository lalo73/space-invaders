package utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeTest {
    long fiveSeconds;

    @Before
    public void setUp(){
        fiveSeconds = 5;
    }

    @Test
    public void hasNotPassed5Seconds(){
        long from = System.nanoTime();
        boolean result = Time.havePassed(5, from, from + 10);
        Assert.assertFalse(result);
    }

    @Test
    public void hasPassed5Seconds(){
        long since = System.nanoTime() - TimeUnit.NANOSECONDS.convert(5, TimeUnit.SECONDS);
        boolean result = Time.havePassed(5, since);
        Assert.assertTrue(result);
    }
}
