//finding minimum time to get all fresh oranges affect with adjacent rotten oranges.
package Queues;
public class RotOranges {
    public static int solve(int[][] arr, int[][] temp) {
        int RottenCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    if (i > 0 && arr[i - 1][j] == 1) {
                        temp[i - 1][j] = 2;
                        RottenCount++;
                    }
                    if (i < arr.length - 1 && arr[i + 1][j] == 1) {
                        temp[i + 1][j] = 2;
                        RottenCount++;
                    }
                    if (j < arr[0].length - 1 && arr[i][j + 1] == 1) {
                        temp[i][j + 1] = 2;
                        RottenCount++;
                    }
                    if (j > 0 && arr[i][j - 1] == 1) {
                        temp[i][j - 1] = 2;
                        RottenCount++;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = temp[i][j];
            }
        }

        return RottenCount;
    }

    public static void Time(int arr[][]) {
        int FreshCount = 0;
        int Time = 0;
        int RottenCount = 0;
        int[][] temp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) FreshCount++;
                temp[i][j] = arr[i][j];  
            }
        }

        if (FreshCount == 0) {
            System.out.println("0");
            return;
        }

        while (true) {
            int current = solve(arr, temp);
            if (current == 0) break;
            RottenCount += current;
            Time++;
        }

        // Check 
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                if (arr[i][j] == 1) {
                    System.out.println("-1"); 
                    return;
                }

        System.out.println("time required: " + Time);
    }

    public static void main(String[] args) {
        int arr[][] = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        Time(arr);
    }
}
