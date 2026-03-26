class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int a=kadane(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=-nums[i];
        }
        int b=sum+kadane(nums);
        if(b==0) return a;
        return Math.max(a,b);
    }
    static int kadane(int[] nums){
        int curr=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            curr=Math.max(nums[i],curr+nums[i]);
            max=Math.max(max,curr);
        }
        return max;
    }
}
