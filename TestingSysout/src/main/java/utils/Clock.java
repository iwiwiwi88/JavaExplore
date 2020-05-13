package utils;

import java.sql.Timestamp;

public class Clock {
    private long start;
    private long end;

    public void start() {
        start = now();
    }

    public void stop() {
        end = now();
    }

    public String toString() {
        return "Time duration [ms]: " + (end - start);
    }

    private long now() {
        return new Timestamp(System.currentTimeMillis()).getTime();
    }
}
