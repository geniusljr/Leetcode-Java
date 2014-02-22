/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (points.length <= 2)
            return points.length;
        
        int max = 0;
        for (int i = 0; i < points.length-1; i++) {
            HashMap<Line, Integer> map = new HashMap<Line, Integer>();
            int count = 0, curMax = 0;
            for (int j = i+1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    count++;
                    continue;
                }
                Line line = new Line(points[i], points[j]);
                if (!map.containsKey(line)) {
                    map.put(line, 2);
                } else {
                    map.put(line, map.get(line)+1);
                }
                curMax = map.get(line) > curMax ? map.get(line) : curMax;
            }
            curMax = curMax + (curMax == 0 ? 1 : 0) + (count > 0 ? count : 0);
            max = curMax > max ? curMax : max;
        }
        return max;
    }
    
    public class Line {
        double k;
        double b;
        double eps = 1e-5;
        boolean verticle;
        Line(Point p1, Point p2) {
            if (Math.abs(p1.x - p2.x) > eps) {
                k = (double)(p1.y-p2.y)/(p1.x-p2.x);
                b = (double)p1.y - (double)p1.x*k;
                verticle = false;
            } else {
                verticle = true;
                b = p1.x;
            }
        }
        
        public int hashCode() {
            return (10000*(int)k) | (10000*(int)b);
        }
        
        public boolean equals(Object object) {
            Line line = (Line)object;
            if ((this.verticle && line.verticle && Math.abs(this.b-line.b) < eps) || (!this.verticle && !line.verticle && Math.abs(this.k-line.k) < eps && Math.abs(this.b-line.b) < eps))
                return true;
            return false;
        }
    }
}