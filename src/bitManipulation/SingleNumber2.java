package bitManipulation;

/*
Every number occurs thrice except one
Without extra space and linear time complexity
 */
class SingleNumber2 {
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,3,2}));
    }
}