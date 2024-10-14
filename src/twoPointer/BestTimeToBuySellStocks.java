package twoPointer;

public class BestTimeToBuySellStocks {

    public static void main(String[] args) {
        BestTimeToBuySellStocks stocks = new BestTimeToBuySellStocks();
//        System.out.println(stocks.maxProfit(new int[] {7,1,4,5,6,3}));
        System.out.println(stocks.maxProfit(new int[] {2,4,1}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 0) {
            return maxProfit;
        }

        int min = prices[0];
        for (int i: prices) {
            if (min > i) {
                min = i;
            }

            maxProfit = Math.max(maxProfit, i-min);
        }
        return maxProfit;
    }

}
