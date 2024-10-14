package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TopToBottomPathTriangle {
    public static void main(String[] args) {



        System.out.println(UUID.randomUUID().getMostSignificantBits());
    }

    public static String processTemplate(String template, Object... args) {
        StringBuilder sb = new StringBuilder(template);
        int index = sb.indexOf("{");
        int argsIndex = 0;
        while (index != -1) {
            sb.replace(index, index + 2, args[argsIndex].toString());
            index = sb.indexOf("{", index + 2);
            argsIndex++;
        }
        return sb.toString();
//        String tenp = "Dear Subscriber, Your vas purchase of {} of amount {} {} is successfully Processed.";
//        processTemplate(tenp, "1", 0.0, "NGN")
    }

    private static int findPath(int row, int col, List<List<Integer>> dp, List<List<Integer>> triangle) {
        if(row==triangle.size()-1) {
            return triangle.get(row).get(col);
        }

        if(dp.get(row).get(col) != -1) {
            return dp.get(row).get(col);
        }

        int adj = findPath(row+1, col, dp, triangle);
        int adj1 = findPath(row+1, col+1, dp, triangle);

        int ans = triangle.get(row).get(col) + Math.min(adj, adj1);

        dp.get(row).set(col, ans);
        return ans;
    }
}
