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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index = 0;
        while (index < intervals.size() && intervals.get(index).start <= newInterval.start) {
            index++;
        }
        index--;
        if (index < 0 || intervals.get(index).end < newInterval.start) {
            index++;
            if (index >= intervals.size() || intervals.get(index).start > newInterval.end) {
                intervals.add(index, newInterval);
                return intervals;
            }
        } else {
            newInterval.start = intervals.get(index).start;
        }
        int idx2 = index;
        while (idx2 < intervals.size() && intervals.get(idx2).start <= newInterval.end) {
            newInterval.end = Math.max(newInterval.end, intervals.get(idx2).end);
            intervals.remove(idx2);
        }
        intervals.add(index, newInterval);
        return intervals;
    }
}