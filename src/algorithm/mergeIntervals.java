package com.jayce;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: ZhaoCong
 * @Date: 2018/11/19 20:53
 * @Description:
 */
public class mergeIntervals {
    public static void main(String args[]) {
        List<Interval> test = new LinkedList<>();

        test.add(new Interval(3, 6));
        test.add(new Interval(1, 3));
        test.add(new Interval(8,10));
        test.add(new Interval(11,13));
        test = merge(test);
        System.out.println("开始" + test.toString());
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }
        List<Interval> result = new LinkedList<>();
        for(int i=0;i<intervals.size();++i){
            result=insert(result,intervals.get(i));
        }
        return result;
    }

    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int n=intervals.size();
        for(int i=0;i<n;++i){
            if(intervals.get(i).end<newInterval.start){
                result.add(intervals.get(i));
            }else if(intervals.get(i).start>newInterval.end){
                result.add(intervals.get(i));
            }else{
                newInterval.start=Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
            }
        }
        result.add(newInterval);
        return result;

    }
}
