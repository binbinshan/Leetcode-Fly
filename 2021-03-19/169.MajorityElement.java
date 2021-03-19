class Solution {
    //时间复杂度O(n),空间复杂度O(n)
    public int majorityElement(int[] nums) {
      Map<Integer,Integer> counts =  countNums(nums);

        //给定一个初始值，开始循环map获取最大次数的map,返回key
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {

            while(majorityEntry == null ||  entry.getValue() > majorityEntry.getValue()){
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    private Map<Integer,Integer> countNums(int[] nums){
        //利用hashMap将 判断key 也就是nums的值是否重复，重复次数就加1
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i]) + 1);
            }
        }
        return map;
    }
}