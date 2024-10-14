package Backtracking;

import java.util.Arrays;

public class FractionalKnapsack {

    class Item {
        int weight;
        int value;
        Item(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        FractionalKnapsack k = new FractionalKnapsack();
//        int[] values = new int[]{60,100,120};
//        int[] weights = new int[]{10,20,30};
//        int target = 50;
        int[] values = new int[]{3};
        int[] weights = new int[]{20};
        int target = 17;
        Double d = k.resolve(values, weights, target) * 100;
        int out = (int) Math.floor(d);
        System.out.println(out);

    }

    private Double resolve(int[] values, int[] weights, int target) {
        Item[] items = new Item[values.length];
        for (int i=0;i<values.length;i++) {
            items[i] = new Item(weights[i], values[i]);
        }
        Arrays.sort(items, (o1, o2) -> {
            Double a = (double) o1.value/ (double) o1.weight;
            Double b = (double) o2.value/ (double) o2.weight;
            return Double.compare(b, a);
        });

        int currentWeight = 0;
        double currentValue = 0;

        for(Item item: items) {
            if (currentWeight + item.weight <= target) {
                currentWeight += item.weight;
                currentValue += (double) item.value;
            } else {
                int remainingWeight = target - currentWeight;
                currentValue+= (double)(remainingWeight * (item.value/(double) item.weight));
                break;
            }
        }
        return currentValue;
    }


}
