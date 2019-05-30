package com.codingfundas.datastructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunngupt on 8/12/18.
 */

/**
 * Basic Regex Parser
 * Implement a regular expression function isMatch that supports the '.' and '*' symbols.
 * The function receives two strings - text and pattern - and should return true if the text matches the pattern as a regular expression.
 * For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in the pattern string.
 * <p/>
 * In case you aren’t familiar with regular expressions, the function determines if the text and pattern are the equal,
 * where the '.' is treated as a single a character wildcard (see third example), and '*' is matched for a zero or more sequence of the previous letter (see fourth and fifth examples).
 * For more information on regular expression matching, see the Regular Expression Wikipedia page.
 * <p/>
 * Explain your algorithm, and analyze its time and space complexities.
 */

class BasicRegexParser {

    static boolean isMatch(String text, String pattern) {

        /**
         * This Map contains the index as key and expected charactor for * as value.
         * for example the pattern is abc*fgh*p
         * StartEffect will start from index 2, this map will have 2 as key and 'c' as value
         * The key value pairs in this Map will be (2, 'c') (6, 'h')
         */
        Map<Integer, Character> starMap = new HashMap<Integer, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {
                starMap.put(i - 1, pattern.charAt(i - 1));
            }
        }

        boolean starEffect = false;
        /**
         * expectedChar is the character I am expecting from
         * the at a particular text index after watching the pattern.
         */
        char expectedChar;
        int textItr = 0;
        int patItr = 0;
        while (patItr < pattern.length() && textItr < text.length()) {
            expectedChar = pattern.charAt(patItr);
            if (starMap.containsKey(patItr)) {
                starEffect = true;
                expectedChar = starMap.get(patItr);
                /* This check is for handling the .* case in the pattern */
                if (expectedChar == '.') {
                    expectedChar = text.charAt(textItr);
                }
                if (expectedChar == text.charAt(textItr)) {
                    while (starEffect && expectedChar == text.charAt(textItr)) {
                        textItr++;
                        if (textItr == text.length()) {
                            break;
                        }

                    }
                }
                patItr += 2;
                continue;
            }

            if (expectedChar == '.') {
                patItr++;
                textItr++;
                continue;
            }

            if (expectedChar == text.charAt(textItr)) {
                patItr++;
                textItr++;
            } else {
                return false;
            }

        }
        if (textItr < text.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", ""));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("", "a*"));
        System.out.println(isMatch("abbdbb", "ab*d"));
        System.out.println(isMatch("aba", "a.a"));
        System.out.println(isMatch("aba", "a.a"));
        System.out.println(isMatch("acd", "ab*c."));
        System.out.println(isMatch("abaa", "a.*a*"));
    }

}
