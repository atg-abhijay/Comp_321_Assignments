import java.util.*;

public class NarrowArtGall_260708548 {
    public static void main(String[] args) {
        final int negativeConstant = -10;
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
        int numCloseRooms = sc.nextInt();
        int[][] galleries = new int[numRows][2];
        for(int p = 0; p < numRows; p++) {
            galleries[p][0] = sc.nextInt();
            galleries[p][1] = sc.nextInt();
        }

        int[][][] table = new int[numRows][numCloseRooms+1][3];
        for(int p = 0; p < numRows; p++) {
            for(int q = 0; q < numCloseRooms+1; q++) {
                for(int r = 0; r < 3; r++) {
                    table[p][q][r] = negativeConstant;
                }
            }
        }

        int[] row_1 = table[0][0];
        row_1[0] = negativeConstant;
        row_1[1] = negativeConstant;
        row_1[2] = galleries[0][0] + galleries[0][1];

        for(int p = 1; p < numRows; p++) {
            int[] row_2 = table[p][0];
            row_2[0] = negativeConstant;
            row_2[1] = negativeConstant;
            row_2[2] = table[p-1][0][2] + galleries[p][0] + galleries[p][1];
        }

        if(numCloseRooms > 0) {
            int[] row_3 = table[0][1];
            row_3[0] = galleries[0][1];
            row_3[1] = galleries[0][0];
            row_3[2] = negativeConstant;
        }

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

                row_4[0] = galleries[p][1] + max_1;
                row_4[1] = galleries[p][0] + max_2;
                row_4[2] = galleries[p][0] + max_4 + galleries[p][1];


            }
        }

        int[] row_7 = table[numRows-1][numCloseRooms];
        int max_5 = Math.max(row_7[1], row_7[2]);
        int result = Math.max(row_7[0], max_5);
        System.out.println(result);
    }
}