class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        for i in nums2:
            nums1.append(i)
        nums1.sort()
        n = len(nums1)
        if len(nums1)%2 != 0:
            a = n//2
            return float(nums1[a])
        else:
            mid1 = (n//2) -1
            mid2 = n//2
            return (nums1[mid1] + nums1[mid2]) / 2.0
        