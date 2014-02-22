/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (intervals.size() == 0)
            return new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval a1, Interval a2) {
               return a1.start < a2.start ? -1 : 1;
           } 
        });
        ArrayList<Interval> results = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= last.end && cur.end > last.end)
                last.end = cur.end;
            else if (cur.start > last.end) {
                results.add(last);
                last = new Interval(cur.start, cur.end);
            }
        }
        results.add(last);
        return results;
    }
}