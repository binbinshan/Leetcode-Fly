
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //将列表中的区间按照左端点升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
        	//当前区间左值
            int L = intervals[i][0];
            //当前区间右值
            int R = intervals[i][1];

           	//如果集合为空，或者 集合的最后一个区间数据的右值 小于当前要插入的区间的左值
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
            	//就直接将这个区间加入数组 merged 的末尾
                merged.add(new int[]{L, R});
            } else {
            	//否则就是重合，重合的话需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}