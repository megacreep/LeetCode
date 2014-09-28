package com.megacreep.LeetCode;

/**
 * Created by megacreep on 2014/9/28.
 */
public class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}
