int findMin(int* nums, int numsSize) {
    int final = nums[0];
    for(int i =0;i<numsSize;i++){
        if(nums[i]<final){
            final = nums[i];
        }
    }
    return final;
}