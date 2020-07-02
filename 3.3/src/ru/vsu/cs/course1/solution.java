package ru.vsu.cs.course1;

public class solution {
    public static int[][] result(int[][] doubleArray)
    {
        int[][] temp = new int[5][5];
        int one[] = {0, 0, 0, 0, 0};
        int c, str = -1;
        for (int i = 0; i < 4; i++) {
            c = 0;
            for (int j = 0; j < 5; j++) {
                if (doubleArray[i][j] == doubleArray[i + 1][j])
                {
                    c++;
                    str = i + 1;
                }
                if (c == doubleArray[0].length)
                {
                    one[str] = 1;
                    int rows = temp.length - 1;
                    int cols = doubleArray[0].length;
                    temp = new int[rows][cols];
                }
            }
        }
        int ii = 0;

        for (int n = 0; n < one.length; n++)
        {
            for (int k = 0; k < doubleArray[0].length; k++)
                if (one[n] != 1) {
                    temp[ii][k] = doubleArray[n][k];
                }
            if (one[n] != 1) ii++;
        }
        return temp;
    }
}