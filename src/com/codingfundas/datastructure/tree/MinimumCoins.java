package com.codingfundas.datastructure.tree;

import java.util.Arrays;

/**
 * Created by sunngupt on 8/9/18.
 */
public class MinimumCoins {


    public static void main(String[] args) {
        MinimumCoins minimumCoins = new MinimumCoins();

        int[] coins = {1, 2, 5};

        System.out.print(minimumCoins.coinChange1(coins, 11));
    }

    /**
     * It will first run for amount 11
     * <p/>
     * Then I choose coin of denomination 1 : again it run for amount - 10
     * Then I choose coin of denomination 1 : again it run for amount - 9
     * <p/>
     * This solution will have exponential complexity
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                int count = coinChange1(coins, amount - coins[i]);
                if (count != Integer.MAX_VALUE && count + 1 < min) {
                    //System.out.println(coins[i]);
                    min = count + 1;
                }
            }
        }
        //System.out.print(min);
        //At this line I will get minimum number of coins for this value
        return min;
    }
}