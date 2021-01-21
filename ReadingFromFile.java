/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genratingjob;

import java.io.*;
import java.util.Arrays;
import java.math.*;
/**
 *
 * @author wadelwazer
 */
public class ReadingFromFile {

    File file;
    int[][] AllJobs;
    int size;

    public ReadingFromFile(File file) {
        this.file = file;
    }

    public void dynamicProgramming(int[][] arr) {
        int k = 2;
        int[][] M1 = new int[size][2];
        int[][] M2 = new int[size][2];
        M1[0][0] = AllJobs[0][0];
        M1[0][1] = AllJobs[0][1];
        int[][] Xj = new int[(int)(Math.pow(2, (size-1)))][2];
        Xj[0][0] = M1[0][0];
        Xj[0][1] = M1[0][1];    
        System.out.println(Xj[0][0] + " " + Xj[0][1]);

    }

    public void readToArray() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        size = Integer.parseInt(br.readLine());
        AllJobs = new int[size][2];
        for (int i = 0; i < size; i++) {
            String[] st = br.readLine().trim().split(" ");
            for (int j = 0; j < 2; j++) {
                AllJobs[i][j] = Integer.parseInt(st[j]);
            }

        }
        SortJobs(AllJobs, 2);
        dynamicProgramming(AllJobs);

    }

    static void SortJobs(int[][] arr, int col) {
        Arrays.sort(arr, (int[] val1, int[] val2) -> {
            if (val1[col - 1] < val2[col - 1]) {
                return 3;
            } else {
                return -8;
            }
        });
    }
}
