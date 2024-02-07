package com.example.tetr1.templates;

public class Template_UpDown implements Template {

    public int[][] matrix_1() {
        int[][] res = {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 0}
        };
        return res;
    }

    public int[][] matrix_2() {
        int[][] res = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 1, 0}
        };
        return res;
    }

    public int[][] matrix_3() {
        return matrix_1();
    }

    public int[][] matrix_4() {
        return matrix_2();
    }

}
