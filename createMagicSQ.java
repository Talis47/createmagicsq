private static int[][] shuffleSquare(int[][] square) {
        int n = square.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int idx = rand.nextInt(n);
            int idy = rand.nextInt(n);
            int dir = rand.nextInt(4);
            int a = square[idx][idy], otherX = 0, otherY = 0;
            switch (dir) {
                case 0: // up
                    otherY = (idy - 1 >= 0) ? idy - 1 : n - 1;
                    otherX = idx;
                    break;
                case 1: // right
                    otherX = (idx + 1 < n) ? idx + 1 : 0;
                    otherY = idy;
                    break;
                case 2: // down
                    otherX = idx;
                    otherY = (idy + 1 < n) ? idy + 1 : 0;
                    break;
                case 3: // left
                    otherX = (idx - 1 >= 0) ? idx - 1 : n - 1;
                    otherY = idy;
                    break;
            }
            square[idx][idy] = square[otherX][otherY];
            square[otherX][otherY] = a;
        }

        return square;
    }
}
