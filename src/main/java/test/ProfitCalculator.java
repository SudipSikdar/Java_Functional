package test;

import java.util.Arrays;
import java.util.List;

public class ProfitCalculator {

    public static void main(String[] args) {

        List<Integer> transactions = Arrays.asList(10, 11, 9, 15, 31, 21);

        int profit = calculateProfit(transactions);
        System.out.println(profit);
    }

    private static int calculateProfit(List<Integer> transactions) {

        int profit = 0;

        int buyPrice = transactions.get(0);
        for (int currentPrise : transactions) {

            if (currentPrise > buyPrice) {
                profit = profit + (currentPrise - buyPrice);
                buyPrice = currentPrise;
            }else {
                buyPrice = currentPrise;
            }


        }
        return profit;

    }
}
