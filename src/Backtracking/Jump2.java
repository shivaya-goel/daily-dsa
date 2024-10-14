package Backtracking;

// JITNI DUUR HO SKE TTO KUD JAO // kyuki minimum nikalna hai
public class Jump2 {

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int farthestJumpIndex = 0;
        int farthestJump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);
            if (i == farthestJumpIndex) {
                jumps++;
                farthestJumpIndex = farthestJump;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        Jump2 jump2 = new Jump2();
        int jum = jump2.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jum);
    }

}
