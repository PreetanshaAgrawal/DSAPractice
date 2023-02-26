public class search_rotated_array {

    // search with repeated elements in the sorted and rotated array
    static boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // if there are duplicates
            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s++;
                e--;
            }

            // left half is sorted
            else if (nums[s] <= nums[mid]) {
                if (target >= nums[s] && target <= nums[mid])
                    e = mid - 1;

                else
                    s = mid + 1;
            }

            // right half is sorted
            else {
                if (target <= nums[e] && target >= nums[mid])
                    s = mid + 1;

                else
                    e = mid - 1;
            }

        }
        return false;
    }

    // distinct elements
    public int searchDistinct(int[] nums, int target) {
        int s =0;
        int e = nums.length -1;
        while(s <= e){
            if(nums[s] == target) {
                return s;
            }
            else if(nums[e] == target) {
                return e;
            }

            else {
                s++;
                e--;
            }
        }
        return -1;

    }


    // find minimum in the rotated array with repeated values
    static int findMin(int[] nums) {
        int s =0;
        int e = nums.length -1;

        while(s < e){
            int mid = s + (e-s)/2;

            if(nums[mid] == nums[s] && nums[mid] == nums[e]){
                s++;
                e--;
            }
            else if (nums[mid] > nums[e]){
                s = mid + 1;
            }

            else e = mid;
        }

        return nums[s];
        
    }
}
