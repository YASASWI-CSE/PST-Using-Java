class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean flag=false;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                flag=true;
                break;
            }
        }
        return flag;
    }
}
