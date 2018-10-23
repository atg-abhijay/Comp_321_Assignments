import java.util.Scanner;

public class NarrowArtGall_260708548 {
    public static void main(String[] args) {
        /**
         * storing a constant "invalid"
         * value for the initializations
         * performed below.
         */
        final Integer negativeConstant = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        /**
         * keep running the loop until all
         * galleries have been evaluated.
         */
        while(sc.hasNextInt()) {
            int numRows = sc.nextInt();
            int numCloseRooms = sc.nextInt();
            int[][] artGallery = new int[numRows][2];
            for(int p = 0; p < numRows; p++) {
                artGallery[p][0] = sc.nextInt();
                artGallery[p][1] = sc.nextInt();
            }

            /**
             * 3-dimensional array to
             * keep track of everything.
             * the third dimension has
             * size three to store three
             * types of outcomes:
             * 1. closing left room
             * 2. closing right room
             * 3. closing neither room
             */
            int[][][] table = new int[numRows][numCloseRooms+1][3];
            for(int p = 0; p < numRows; p++) {
                for(int q = 0; q < numCloseRooms+1; q++) {
                    for(int r = 0; r < 3; r++) {
                        table[p][q][r] = negativeConstant;
                    }
                }
            }

            /**
             * values for the base cases
             */
            int[] row_1 = table[0][0];
            row_1[0] = negativeConstant;
            row_1[1] = negativeConstant;
            row_1[2] = artGallery[0][0] + artGallery[0][1];

            /**
             * making updates for the
             * values along different rows.
             */
            for(int p = 1; p < numRows; p++) {
                int[] row_2 = table[p][0];
                row_2[0] = negativeConstant;
                row_2[1] = negativeConstant;
                row_2[2] = table[p-1][0][2] + artGallery[p][0] + artGallery[p][1];
            }

            if(numCloseRooms > 0) {
                int[] row_3 = table[0][1];
                row_3[0] = artGallery[0][1];
                row_3[1] = artGallery[0][0];
                row_3[2] = negativeConstant;
            }

            /**
             * significant loop where entries
             * in the table are updated using
             * values of their "predecessors".
             */
            for(int p = 1; p < numRows; p++) {
                int bound = Math.min(p+1, numCloseRooms);
                for(int q = 1; q < bound + 1; q++) {
                    int[] row_4 = table[p][q];
                    int[] row_5 = table[p-1][q-1];
                    int[] row_6 = table[p-1][q];

                    int max_1 = Math.max(row_5[0], row_5[2]);
                    int max_2 = Math.max(row_5[1], row_5[2]);
                    int max_3 = Math.max(row_6[1], row_6[2]);
                    int max_4 = Math.max(row_6[0], max_3);

                    row_4[0] = artGallery[p][1] + max_1;
                    row_4[1] = artGallery[p][0] + max_2;
                    row_4[2] = artGallery[p][0] + max_4 + artGallery[p][1];
                }
            }

            /**
             * go to the last row to find
             * the maximum values and
             * store them to return them.
             */
            int[] row_7 = table[numRows-1][numCloseRooms];
            int max_5 = Math.max(row_7[1], row_7[2]);
            int result = Math.max(row_7[0], max_5);
            /**
             * skip over the last '0 0' which
             * denotes the end of a gallery.
             */
            sc.nextInt();
            sc.nextInt();
            System.out.println(result);
        }
        sc.close();
    }
}