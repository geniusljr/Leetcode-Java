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
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int same = 1, curMax = 0;
            for (int j = i+1; j < points.length; j++) {
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                int g = gcd(dx, dy);
                if (g == 0) {
                    same++;
                    continue;
                }
                boolean neg = dx < 0 || (dx == 0 && dy < 0);
                dx = neg ? -dx/g : dx/g;
                dy = neg ? -dy/g : dy/g;
                String s = dx+" "+dy;
                int num = map.containsKey(s) ? map.get(s)+1 : 1;
                map.put(s, num);
                curMax = num > curMax ? num : curMax;
            }
            max = max > (curMax+same) ? max : (curMax + same);
        }
        return max;
    }
    
    int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        return a == 0 ? b : gcd(b%a, a);
    }
}