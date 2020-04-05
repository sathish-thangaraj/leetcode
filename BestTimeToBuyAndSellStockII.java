package leetcode;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitEasy(prices));
    }

    // You will buy the stock if price is going up i.e. prices[i] < prices[i+1 and you dont have any pending transaction
    // You will sell the stock if price is going down i.e. prices[i] > prices[i+1] and you already bought the stock
    // when ever you sell add the profit ( sellPrice-buyPrice) and reset the flag;
    public static int maxProfit(int[] prices) {

        boolean isBought = false;
        int maxProfit = 0;
        int buyPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1] && !isBought) {
                buyPrice = prices[i];
                isBought = true;
            } else if (prices[i] > prices[i + 1] && isBought) {
                maxProfit += prices[i] - buyPrice;
                isBought = false;
            }
        }

        if (isBought)
            maxProfit += prices[prices.length - 1] - buyPrice;

        return maxProfit;
    }


    public static int maxProfitEasy(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
