package Backtracking;

import java.util.Arrays;

public class crosspuzzle {
    public static void solve(char[][] grid, String[] words, int idx) {
        if (idx == words.length) {
            System.out.println("✅ Solution Found:");
            print(grid);
            return;
        }

        String word = words[idx];
        System.out.println("Trying to place word: " + word);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '-' || grid[i][j] == word.charAt(0)) {
                    if (canPlaceHorizontally(grid, word, i, j)) {
                        System.out.println("Placing " + word + " horizontally at (" + i + "," + j + ")");
                        boolean[] placed = placeHorizontally(grid, word, i, j);
                        print(grid);
                        solve(grid, words, idx + 1);
                        System.out.println("Backtracking: Removing " + word + " from (" + i + "," + j + ")");
                        unplaceWordHorizontally(grid, placed, i, j);
                    }

                    if (canPlaceVertically(grid, word, i, j)) {
                        System.out.println("Placing " + word + " vertically at (" + i + "," + j + ")");
                        boolean[] placed = placeVertically(grid, word, i, j);
                        print(grid);
                        solve(grid, words, idx + 1);
                        System.out.println("Backtracking: Removing " + word + " from (" + i + "," + j + ")");
                        unplaceWordVertically(grid, placed, i, j);
                    }
                }
            }
        }
        System.out.println("❌ No placement found for " + word + ", backtracking...");
    }

    public static boolean canPlaceHorizontally(char[][] grid, String word, int i, int j) {
        if (j + word.length() > grid[0].length) return false;
        if (j > 0 && grid[i][j - 1] != '+') return false;
        if (j + word.length() < grid[0].length && grid[i][j + word.length()] != '+') return false;

        for (int k = 0; k < word.length(); k++) {
            if (grid[i][j + k] != '-' && grid[i][j + k] != word.charAt(k)) return false;
        }
        return true;
    }

    public static boolean canPlaceVertically(char[][] grid, String word, int i, int j) {
        if (i + word.length() > grid.length) return false;
        if (i > 0 && grid[i - 1][j] != '+') return false;
        if (i + word.length() < grid.length && grid[i + word.length()][j] != '+') return false;

        for (int k = 0; k < word.length(); k++) {
            if (grid[i + k][j] != '-' && grid[i + k][j] != word.charAt(k)) return false;
        }
        return true;
    }

    public static boolean[] placeHorizontally(char[][] grid, String word, int i, int j) {
        boolean[] placed = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (grid[i][j + k] == '-') {
                grid[i][j + k] = word.charAt(k);
                placed[k] = true;
            }
        }
        return placed;
    }

    public static boolean[] placeVertically(char[][] grid, String word, int i, int j) {
        boolean[] placed = new boolean[word.length()];
        for (int k = 0; k < word.length(); k++) {
            if (grid[i + k][j] == '-') {
                grid[i + k][j] = word.charAt(k);
                placed[k] = true;
            }
        }
        return placed;
    }

    public static void unplaceWordHorizontally(char[][] grid, boolean[] placed, int i, int j) {
        for (int k = 0; k < placed.length; k++) {
            if (placed[k]) grid[i][j + k] = '-';
        }
    }

    public static void unplaceWordVertically(char[][] grid, boolean[] placed, int i, int j) {
        for (int k = 0; k < placed.length; k++) {
            if (placed[k]) grid[i + k][j] = '-';
        }
    }

    public static void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'},
            {'+', '-', '-', '-', '-', '-', '+', '+', '+', '+'},
            {'+', '+', '+', '-', '+', '+', '+', '+', '+', '+'},
            {'+', '+', '+', '-', '+', '+', '+', '+', '+', '+'},
            {'+', '+', '+', '-', '-', '-', '-', '-', '+', '+'},
            {'+', '+', '+', '-', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '-', '+', '+', '+'},
            {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}
        };

        String[] words = {"POLAND", "LHASA", "SPAIN", "INDIA"};
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length())); // Sort by word length (descending)
        solve(grid, words, 0);
    }
}
