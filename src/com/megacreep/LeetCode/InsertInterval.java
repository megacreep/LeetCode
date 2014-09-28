package com.megacreep.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by megacreep on 2014/9/28.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();

        int insertPosition = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
                insertPosition++;
            } else if (interval.start > newInterval.end) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        result.add(insertPosition, newInterval);

        return result;
    }

    public List<Interval> insertMime(List<Interval> intervals, Interval newInterval) {
        int startIndex = -1;
        int endIndex = -1;
        int i;
        for (i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end >= newInterval.start) {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1) {
            intervals.add(newInterval);
            return intervals;
        }
        for (i = intervals.size() - 1; i >= startIndex; i--) {
            if (intervals.get(i).start <= newInterval.end) {
                endIndex = i;
                break;
            }
        }

        newInterval.start = Math.min(newInterval.start, intervals.get(startIndex).start);
        if (endIndex != -1) {
            newInterval.end = Math.max(newInterval.end, intervals.get(endIndex).end);
            while (endIndex >= startIndex) {
                intervals.remove(endIndex--);
            }
        }
        intervals.add(startIndex, newInterval);
        return intervals;
    }

    public static void main(String[] args) {
        int[][] intervalsOrigin = new int[][] {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newIntervalOrigin = new int[]{4, 9};

        List<Interval> intervals = new ArrayList<Interval>();
        for (int[] interval : intervalsOrigin) {
            intervals.add(new Interval(interval[0], interval[1]));
        }
        Interval newInterval = new Interval(newIntervalOrigin[0], newIntervalOrigin[1]);

        System.out.println(new InsertInterval().insert(intervals, newInterval));
    }
}
