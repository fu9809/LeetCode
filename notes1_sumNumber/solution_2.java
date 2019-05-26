class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            temp = target - nums[i];
            if(map.containsKey(temp) && !map.get(temp).equals(i)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
