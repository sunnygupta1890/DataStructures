package com.codingfundas.datastructure.tree;

import java.util.Arrays;

/**
 * Created by sunngupt on 8/10/18.
 */
public class MinimumCoinWithMemorization {

    public static void main(String[] args) {
        MinimumCoinWithMemorization minimumCoinsMinimumCoinWithMemorization = new MinimumCoinWithMemorization();

        int[] coins = {1, 2, 5};

        System.out.print(minimumCoinsMinimumCoinWithMemorization.coinChange(coins, 100));
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
    public int coinChange(int[] coins, int amount) {

        int[] table = new int[amount + 1];
        Arrays.fill(table, amount+1);

        table[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    int count = table[i - coins[j]];
                    table[i] = Math.min(count, table[i]) + 1;
                }
            }
        }
        return table[amount];
    }

}