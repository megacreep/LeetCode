package com.megacreep.LeetCode;

import java.util.HashMap;


public class MaxPoints {
    private class Line {
        int a;
        int b;
        Line(Point p1, Point p2) {
            a = p1.x - p2.x;
            b = p1.y - p2.y;
            int gcdVal = gcd(a, b);
            a /= gcdVal;
            b /= gcdVal;
        }
        @Override
        public boolean equals(Object arg0) {
            if (arg0 instanceof Line) {
                return ((Line) arg0).a == this.a && ((Line) arg0).b == this.b;
            }
            return false;
        }
        @Override
        public int hashCode() {
            int hash = 1;
            hash = hash * 17 + a;
            hash = hash * 31 + b;
            return hash;
        }
        
    }
    public int maxPoints(Point[] points) {
        int maxVal = 0;
        for (int i = 0; i < points.length - maxVal; i++) {
            Point p = points[i];
            HashMap<Line, Integer> counts = new HashMap<MaxPoints.Line, Integer>();
            int overlap = 0;
            int localMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[j];
                if (p.x == p1.x && p.y == p1.y) {
                    overlap++;
                } else {
                    Line line = new Line(p1, p);
                    Integer count;
                    if (counts.containsKey(line)) {
                        count = counts.get(line) + 1;
                    } else {
                        count = new Integer(1);
                    }
                    counts.put(line, count);
                    localMax = Math.max(localMax, count);
                }
            }
            maxVal = Math.max(maxVal, 1 + overlap + localMax);
        }
        
        return maxVal;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
