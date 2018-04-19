// Talis Harris C1758203 //

import java.util.Scanner;

public class createMagicSQ {

    public static void main(String[] args) {
        String input = "";
        int value;
        while (true) {
            System.out.println("CM1210 APP TO CREATE A MAGIC SQUARE:");
            System.out.println("Please enter an odd number:");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            try {
                value = Integer.parseInt(input);
                if (value % 2 == 1) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        int[][] sq = magicSQ(value);
        int n = sq.length;
        System.out.println("Magic square of " + n +" rows and " + n + " columns");
        System.out.println("Necessary sum of each row and column: " + n*(n*n + 1)/2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sq[i][j] < 10)  System.out.print(" ");  // for alignment
                if (sq[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(sq[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static int[][] magicSQ(int n) {     // Used alternative algorithm as one given caused wrapping and index issue
        
        int[][] magicSQ = new int[n][n];
        int x = n/2;
        int y = n-1;

        for (int num = 1; num <= n * n; ) {
            if (x == -1 && y == n) {
                y = n - 2;
                x = 0;
            } else {
                if (y == n) y = 0;
                if (x < 0) x = n - 1;
            }

            if (magicSQ[x][y] != 0) {
                y -= 2;
                x++;
            } else {
                magicSQ[x][y] = num++;
                y++;
                x--;
            }
        }

        return magicSQ;
    }
}
