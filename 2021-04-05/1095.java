/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        //查找峰顶
        int topIndex = findMountainTop(mountainArr,0,n-1);
        if(mountainArr.get(topIndex) == target)return topIndex;
        //查找峰顶左边
        int leftIndex = findMountainLeft(mountainArr,0,topIndex - 1,target);
        //如果左边不等于-1，返回，
        if(leftIndex != -1)return leftIndex;
        //查找峰顶右边
        int rightIndex = findMountainRight(mountainArr,topIndex + 1,n - 1,target);
        //返回右区间值
        return rightIndex;
    }

    public int findMountainTop(MountainArray mountainArr, int left , int right){
        while(left < right){
            int mid = left + ((right - left)>>>1);
            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    //都是升序 不重复
    public int findMountainLeft(MountainArray mountainArr, int left , int right,int target){
        while(left < right){
            int mid = left + ((right - left)>>>1);

            if(mountainArr.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid;
            }

        }

            if(mountainArr.get(left) == target){
                return left;
            }
        return  -1;
    }

    public int findMountainRight(MountainArray mountainArr, int left , int right,int target){

        while(left < right){
            int mid = left + (right - left + 1)/2;

            if(mountainArr.get(mid) < target){
                right = mid - 1;
            }else{
                left = mid;
            }

        }
        if(mountainArr.get(left) == target){
                return left;
        }
        return  -1;
    }
}