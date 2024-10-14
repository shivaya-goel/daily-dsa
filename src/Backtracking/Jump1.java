package Backtracking;


public class Jump1 {

    public boolean jump(int[] nums) {
        int maxIndex = 0;
        for (int i=0;i<nums.length;i++) {
            if (i>maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Jump1 jump1 = new Jump1();
        boolean jum = jump1.jump(new int[]{3, 2, 1, 0, 4});
        System.out.println(jum);
    }

}
